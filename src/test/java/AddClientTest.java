import controller.ClientController;
import junit.framework.TestCase;
import model.Client;
import org.junit.Test;

public class AddClientTest extends TestCase {

     private ClientController ctrl;

    public void setUp() throws Exception{
        super.setUp();
        ctrl = new ClientController();
    }
//    @Test
//    public void testAddClient1() throws Exception {
//
////        assertTrue(ctrl.get_dataManager().Clients.size()==0);
////        ctrl.AddClient("Ion","Curcuber","5");
////        assertTrue(ctrl.get_dataManager().Clients.size()==1);
//    }
//
//    @Test
//    public void testAddClient2() throws Exception {
////
////        assertTrue(ctrl.get_dataManager().Clients.size()==0);
////        ctrl.AddClient("Ion)))))","Curcuber","5");
////        assertTrue(ctrl.get_dataManager().Clients.size()==1);
//    }

}
