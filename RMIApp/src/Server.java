import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server
{
    public static void main(String[] args) throws Exception
    {
        Registry reg = LocateRegistry.createRegistry(2002);
        System.out.println("SERVER IS READY");
        
        CheckLogin cl=new CheckLogin();
        reg.bind("AUTH", cl);
    }
}