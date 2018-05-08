import controller.ClientController;
import junit.framework.TestCase;
import model.Client;
import model.Issue;
import org.junit.Before;
import org.junit.Test;

public class IncrementalTests extends TestCase {
    private ClientController ctrl;

    @Before
    public void setUp() throws Exception {
        ctrl = new ClientController();
    }

    @Test
    public void testAddClientSuccess() throws Exception {
        String response = ctrl.AddClient("teo", "str fericirii", "16");
        ctrl.get_dataManager().SaveChanges();
        assertEquals(null, response);
    }

    @Test
    public void testAddClientIndexSuccess() throws Exception {
        ctrl.AddClient("teo", "str fericirii", "16");
        String result = ctrl.AddClientIndex(new Client("teo", "str fericirii", "16"), 2018, 5, (float) 150.5);
        assertEquals( "Success", result);
    }

    @Test
    public void testListIssueSuccess() throws Exception {
        ctrl.AddClient("teo", "str fericirii", "16");
        ctrl.AddClientIndex(new Client("teo", "str fericirii", "16"), 2018, 5, (float) 150.5);
        String result = ctrl.ListIssue(new Client("teo", "str fericirii", "16"));
        assertEquals( "MONTH: 5 YEAR: 2018 TO PAY: 150.5 PAID: 0.0", result);
    }

    @Test
    public void testIncrementalA() throws Exception  {
        this.testAddClientSuccess();
        assertTrue(ctrl.get_dataManager().Clients.contains(new Client("teo", "str fericirii", "16")));
    }

    @Test
    public void testIncrementalAB() throws Exception {
        this.testAddClientSuccess();
        this.testAddClientIndexSuccess();

        assertTrue(ctrl.get_dataManager().Clients.contains(new Client("teo", "str fericirii", "16")));
        assertTrue(ctrl.get_dataManager().Issues.contains(new Issue(new Client("teo", "str fericirii", "16"), 2018, 5, 0, (float) 150.5)));
    }

    @Test
    public void testIncrementalABC() throws Exception {
        this.testAddClientSuccess();
        this.testAddClientIndexSuccess();
        this.testListIssueSuccess();

        assertTrue(ctrl.get_dataManager().Clients.contains(new Client("teo", "str fericirii", "16")));
        assertTrue(ctrl.get_dataManager().Issues.contains(new Issue(new Client("teo", "str fericirii", "16"), 2018, 5, 0, (float) 150.5)));
    }
}
