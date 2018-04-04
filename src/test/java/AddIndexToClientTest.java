import controller.ClientController;
import junit.framework.TestCase;
import model.Client;
import org.junit.Before;
import org.junit.Test;

public class AddIndexToClientTest extends TestCase {

    private ClientController ctrl;

    @Before
    public void setUp() throws Exception{
        super.setUp();

        ctrl = new ClientController();
        //add a client with a normal name
        ctrl.AddClient("Tudor", "str Alexandru Cel Bun", "1");
        //add a client with a name with spaces
        ctrl.AddClient("Ana Maria", "str Lacramioarelor", "2");

    }

    @Test
    public void testAddClientToIndex1() throws Exception {

        int oldSize = ctrl.get_dataManager().Issues.size();
        Client c = new Client ("test","test","test");
        String response = ctrl.AddClientIndex(c,-3,12,150);
        assertEquals(ctrl.get_dataManager().Issues,oldSize);

    }

    @Test
    public void testAddClientToIndex2() throws Exception {

        int oldSize = ctrl.get_dataManager().Issues.size();
        Client c = new Client ("test","test","test");
        String response = ctrl.AddClientIndex(c,2018,-2,150);
        assertEquals(ctrl.get_dataManager().Issues,oldSize );

    }
}
