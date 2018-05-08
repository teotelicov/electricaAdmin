import controller.ClientController;
import junit.framework.TestCase;
import model.Client;
import model.Issue;
import org.junit.Before;
import org.junit.Test;


public class ListIndexTest extends TestCase {
    private ClientController ctrl;

    @Before
    public void setUp() throws Exception{
        super.setUp();
        ctrl = new ClientController();

    }

    @Test
    public void testListIndex1(){
        Client c = new Client("ana", "str", "1234");
        ctrl.AddClient("ana", "str", "1234");
        ctrl.get_dataManager().SaveChanges();
        String result = ctrl.AddClientIndex(new Client("ana", "str", "1234"), 2018, 2, (float)2.2);
        result = ctrl.ListIssue(c);
        assertEquals("MONTH: 2 YEAR: 2018 TO PAY: 2.2 PAID: 0.0", result);
    }

    @Test
    public void testListIndex2() throws Exception {
        //address is empty

        String result = ctrl.AddClient("ana","str","1234");
        assertEquals(null, result );

        result = ctrl.AddClientIndex(new Client("ana", "str", "1234"), 2018, 2, (float)2.2);
        assertEquals("Success", result );

        result = ctrl.ListIssue(new Client("ana","str","1234"));
        assertEquals("MONTH: 2 YEAR: 2018 TO PAY: 2.2 PAID: 0.0", result);

    }

    @Test
    public void addClientSuccess() throws Exception {
        String response = ctrl.AddClient("teo", "str fericirii", "16");
        ctrl.get_dataManager().SaveChanges();
        assertEquals("Success", response);
    }

    @Test
    public void addClientIndexSuccess() throws Exception {
        ctrl.AddClient("teo", "str fericirii", "16");
        String result = ctrl.AddClientIndex(new Client("teo", "str fericirii", "16"), 2018, 5, (float) 150.5);
        assertEquals( "Success", result);
    }

    @Test
    public void listIssueSuccess() throws Exception {
        ctrl.AddClient("teo", "str fericirii", "16");
        ctrl.AddClientIndex(new Client("teo", "str fericirii", "16"), 2018, 5, (float) 150.5);
        String result = ctrl.ListIssue(new Client("teo", "str fericirii", "16"));
        assertEquals( "Year: 2018, Month: 5, Penalty: 150.50\n", result);
    }

    @Test
    public void IncrementalA() throws Exception  {
        this.addClientSuccess();
        assertTrue(ctrl.get_dataManager().Clients.contains(new Client("teo", "str fericirii", "16")));
    }

    @Test
    public void IncrementalAB() throws Exception {
        this.addClientSuccess();
        this.addClientIndexSuccess();

        assertTrue(ctrl.get_dataManager().Clients.contains(new Client("teo", "str fericirii", "16")));
        assertTrue(ctrl.get_dataManager().Issues.contains(new Issue(new Client("teo", "str fericirii", "16"), 2018, 5, 0, (float) 150.5)));
    }

    @Test
    public void IncrementalABC() throws Exception {
        this.addClientSuccess();
        this.addClientIndexSuccess();
        this.listIssueSuccess();

        assertTrue(ctrl.get_dataManager().Clients.contains(new Client("teo", "str fericirii", "16")));
        assertTrue(ctrl.get_dataManager().Issues.contains(new Issue(new Client("teo", "str fericirii", "16"), 2018, 5, 0, (float) 150.5)));
    }
}
