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
    public void testAddClientToIndex0(){
        //addClientIndexWhenIndexRepoEmpty
        ctrl.AddClient("ana", "str", "1234");
        ctrl.get_dataManager().SaveChanges();
        String result = ctrl.AddClientIndex(new Client("ana", "str", "1234"), 2018, 2, (float)2.2);
        assertEquals("Success", result);
    }

    @Test
    public void testAddClientToIndex1() throws Exception {

        int oldSize = ctrl.get_dataManager().Issues.size();
        Client c = new Client ("test","test","test");
        String response = ctrl.AddClientIndex(c,-3,12,150);
        assertEquals(ctrl.get_dataManager().Issues.size(),oldSize);

    }

    @Test
    public void testAddClientToIndex2() throws Exception {

        int oldSize = ctrl.get_dataManager().Issues.size();
        Client c = new Client ("test","test","test");
        String response = ctrl.AddClientIndex(c,2018,-2,150);
        assertEquals(ctrl.get_dataManager().Issues.size(),oldSize );

    }

    @Test
    public void testAddClientToIndex3() {
        //addClientIndexSuccess
        ctrl.AddClient("teo", "str", "12345");
        ctrl.get_dataManager().SaveChanges();
        String result = ctrl.AddClientIndex(new Client("teo", "str", "12345"), 2018, 2, (float)10.5);
        assertEquals(result, "Success");
    }


    @Test
    public void testAddClientToIndex4() {
        //addClientIndexInvalidPayAmount
        ctrl.AddClient("teo", "str", "12345");
        ctrl.get_dataManager().SaveChanges();
        String result = ctrl.AddClientIndex(new Client("teo", "str", "1234"), 2018, 10, (float)-15);
        assertEquals(result, "Money to pay can't be less than 0!");
    }

    @Test
    public void testAddClientToIndex5() {
        //addClientIndexInexistentClient
        String result = ctrl.AddClientIndex(new Client("ulala", "str", "12345"), 2018, 5, (float)100);
        assertEquals(result, "Client does not exist!");
    }

    @Test
    public void testAddClientToIndex6(){
        //addClientIndexExistingMonth
        ctrl.AddClient("ana", "str", "12345");
        String result = ctrl.AddClientIndex(new Client("teo", "str", "12345"), 2000, 10, (float)10);
        assertEquals(result, "Success");
        result = ctrl.AddClientIndex(new Client("teo", "str", "12345"), 2000, 10, (float)10);
        assertEquals(result, "Monthly index already exists!");
    }

    @Test
    public void testAddClientToIndex7(){
        //addClientIndexInvalidClientData
        String result = ctrl.AddClientIndex(new Client("ana3", "str", "12345"), 2000, 10, (float)10);
        assertEquals("Invalid client data!", result);
    }

    @Test
    public void testAddClientToIndex8(){
        //addClientIndexWhenClientRepoEmpty
        String result = ctrl.AddClientIndex(new Client("ana", "str", "12345"), 2000, 10, (float)10);
        assertEquals("Client does not exist!", result);
    }


}
