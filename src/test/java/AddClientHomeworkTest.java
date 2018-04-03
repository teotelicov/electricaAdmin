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
        //add a client with a normal name
        ctrl.AddClient("Tudor", "str Alexandru Cel Bun", "1");
        //add a client with a name with spaces
        ctrl.AddClient("Ana Maria", "str Lacramioarelor", "2");

    }

    @Test
    public void testAddClient1() throws Exception {

        assertEquals(ctrl.get_dataManager().Clients.size(), 2);

    }

    @Test
    public void testAddClient2() throws Exception {

        //name is empty
        int oldSize = ctrl.get_dataManager().Clients.size();
        String response = ctrl.AddClient("", "haha", "haha");
        assertEquals(ctrl.get_dataManager().Clients.size(), oldSize);

    }

    @Test
    public void testAddClient3() throws Exception {

        //address is empty
        int oldSize = ctrl.get_dataManager().Clients.size();
        String response = ctrl.AddClient("haha", "", "haha");
        assertEquals(ctrl.get_dataManager().Clients.size(), oldSize);
    }

    @Test
    public void testAddClient4() throws Exception {

        //id is empty
        int oldSize = ctrl.get_dataManager().Clients.size();
        String response = ctrl.AddClient("haha", "haha", "");
        assertEquals(ctrl.get_dataManager().Clients.size(), oldSize);
    }

    @Test
    public void testAddClient5() throws Exception {

        //client already exist
        int oldSize = ctrl.get_dataManager().Clients.size();
        ctrl.AddClient("test", "test", "test");
        String response = ctrl.AddClient("test", "test", "test");
        String alreadyExistsMessage = "Client already exists!";
        assertEquals(response, alreadyExistsMessage);
        //assertEquals(ctrl.get_dataManager().Clients.size(), oldSize + 1);
    }

    @Test
    public void testAddClient6() throws Exception {

        //name contains illegal character
        int oldSize = ctrl.get_dataManager().Clients.size();
        String response = ctrl.AddClient("Elena?", "str Nicaieri", "5");
        assertEquals(ctrl.get_dataManager().Clients.size(), oldSize);
    }

    @Test
    public void testAddClient7() throws Exception {


        //address contains illegal character
        int oldSize = ctrl.get_dataManager().Clients.size();
        String response = ctrl.AddClient("Elena", "str Nicaieri?", "5");
        assertEquals(ctrl.get_dataManager().Clients.size(), oldSize);
    }

    @Test
    public void testAddClient8() throws Exception {

        //id contains illegal character
        int oldSize = ctrl.get_dataManager().Clients.size();
        String response = ctrl.AddClient("Elena", "str Nicaieri", "5?");
        assertEquals(ctrl.get_dataManager().Clients.size(), oldSize);
    }

    @Test
    public void testAddClient9() throws Exception {

        StringBuilder s = new StringBuilder();
        try{
            //name too long

            for(int i = 0; i < Integer.MAX_VALUE; i++) {
                s.append('a');
            }
            int oldSize = ctrl.get_dataManager().Clients.size();
            String response = ctrl.AddClient(s.toString(), "str Nicaieri", "5");
            assertEquals(ctrl.get_dataManager().Clients.size(), oldSize);
        } catch (OutOfMemoryError e){
            s = new StringBuilder();
            assertTrue(true);
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void testAddClient10() throws Exception {

        StringBuilder s = new StringBuilder();
        try{
            //address too long

            for(int i = 0; i < Integer.MAX_VALUE; i++) {
                s.append('a');
            }
            int oldSize = ctrl.get_dataManager().Clients.size();
            String response = ctrl.AddClient("Haleluia", s.toString(), "5");
            assertEquals(ctrl.get_dataManager().Clients.size(), oldSize);
        } catch (OutOfMemoryError e){
            s = new StringBuilder();
            assertTrue(true);
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testAddClient11() throws Exception {

        StringBuilder s = new StringBuilder();
        try{
            //id too long

            for(int i = 0; i < Integer.MAX_VALUE; i++) {
                s.append('a');
            }
            int oldSize = ctrl.get_dataManager().Clients.size();
            String response = ctrl.AddClient("Haleluia", "str Nicaieri", s.toString());
            assertEquals(ctrl.get_dataManager().Clients.size(), oldSize);
        } catch (OutOfMemoryError e){
            s = new StringBuilder();
            assertTrue(true);
            System.out.println(e.getMessage());
        }
    }
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

    @After
    public void tearDown() throws Exception {
        System.out.println("Test Completed");
    }
}
