import controller.ClientController;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

public class AddClientHomeworkTest extends TestCase {

    private ClientController ctrl;
    private String emptyMessage = "Id, Name or address cannot be empty!";

    @Before
    public void setUp() throws Exception{
        super.setUp();
        ctrl = new ClientController();
    }

    @Test
    public void testAddClient1() throws Exception {

        //add a client with a normal name
        System.out.println(ctrl.get_dataManager().Clients.size());
        int oldSize = ctrl.get_dataManager().Clients.size();
        String response = ctrl.AddClient("Tudor", "str Alexandru Cel Bun", "1");
        assertEquals(response, null);

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Test Completed");
    }

//    @Test
//    public void testAddClient2() throws Exception {
//
//        //add a client with a name with spaces
//        int oldSize = ctrl.get_dataManager().Clients.size();
//        oldSize = ctrl.get_dataManager().Clients.size();
//        String response = ctrl.AddClient("Ana Maria", "str Lacramioarelor", "2");
//        assertEquals(ctrl.get_dataManager().Clients.size(), oldSize + 1);
//
//
//    }
//
//    @Test
//    public void testAddClient3() throws Exception {
//
//        //add a client with a normal name
//        int oldSize = ctrl.get_dataManager().Clients.size();
//        oldSize = ctrl.get_dataManager().Clients.size();
//        String response = ctrl.AddClient("Ana", "str Unicorni", "3");
//        assertEquals(ctrl.get_dataManager().Clients.size(), oldSize + 1);
//    }
//
//    @Test
//    public void testAddClient4() throws Exception {
//
//        //add a client with a normal name
//        int oldSize = ctrl.get_dataManager().Clients.size();
//        oldSize = ctrl.get_dataManager().Clients.size();
//        String response = ctrl.AddClient("Teo", "str Flamingo", "4");
//        assertEquals(ctrl.get_dataManager().Clients.size(), oldSize + 1);
//    }
//
//    @Test
//    public void testAddClient5() throws Exception {
//
//        //name is empty
//        int oldSize = ctrl.get_dataManager().Clients.size();
//        String response = ctrl.AddClient("", "haha", "haha");
//        assertEquals(response, emptyMessage);
//        assertEquals(ctrl.get_dataManager().Clients.size(), oldSize);
//    }
//
//    @Test
//    public void testAddClient6() throws Exception {
//
//        //address is empty
//        int oldSize = ctrl.get_dataManager().Clients.size();
//        String response = ctrl.AddClient("haha", "", "haha");
//        assertEquals(response, emptyMessage);
//        assertEquals(ctrl.get_dataManager().Clients.size(), oldSize);
//    }
//
//    @Test
//    public void testAddClient7() throws Exception {
//
//        //id is empty
//        int oldSize = ctrl.get_dataManager().Clients.size();
//        String response = ctrl.AddClient("haha", "haha", "");
//        assertEquals(response, emptyMessage);
//        assertEquals(ctrl.get_dataManager().Clients.size(), oldSize);
//    }
//
//    @Test
//    public void testAddClient8() throws Exception {
//
//        //client already exist
//        int oldSize = ctrl.get_dataManager().Clients.size();
//        ctrl.AddClient("test", "test", "test");
//        String response = ctrl.AddClient("test", "test", "test");
//        String alreadyExistsMessage = "Client already exists!";
//        assertEquals(response, alreadyExistsMessage);
//        assertEquals(ctrl.get_dataManager().Clients.size(), oldSize + 1);
//    }
//
//    @Test
//    public void testAddClient9() throws Exception {
//
//        //name contains illegal character
//        //address is empty
//        int oldSize = ctrl.get_dataManager().Clients.size();
//        String response = ctrl.AddClient("Elena", "str Nicaieri", "5");
//        assertEquals(response, emptyMessage);
//        assertEquals(ctrl.get_dataManager().Clients.size(), oldSize);
//    }
//
//    @Test
//    public void testAddClient10() throws Exception {
//
//        //name contains illegal character
//        int oldSize = ctrl.get_dataManager().Clients.size();
//        String response = ctrl.AddClient("Elena?", "str Nicaieri", "5");
//        assertEquals(response, emptyMessage);
//        assertEquals(ctrl.get_dataManager().Clients.size(), oldSize);
//    }
//
//    @Test
//    public void testAddClient11() throws Exception {
//
//        //address contains illegal character
//        int oldSize = ctrl.get_dataManager().Clients.size();
//        String response = ctrl.AddClient("Elena", "str Nicaieri?", "5");
//        assertEquals(response, emptyMessage);
//        assertEquals(ctrl.get_dataManager().Clients.size(), oldSize);
//    }
//
//    @Test
//    public void testAddClient12() throws Exception {
//
//        //id contains illegal character
//        int oldSize = ctrl.get_dataManager().Clients.size();
//        String response = ctrl.AddClient("Elena", "str Nicaieri", "5?");
//        assertEquals(response, emptyMessage);
//        assertEquals(ctrl.get_dataManager().Clients.size(), oldSize);
//    }

}
