import controller.ClientController;
import junit.framework.TestCase;
import model.Client;
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
}
