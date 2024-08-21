import static java.lang.System.out;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
       
public class Client 
{
 public static void main(String[] args) throws Exception
 {
     Scanner sc = new Scanner(System.in);
     out.println("Enter Server name:");
     String serverName = sc.next();
     out.println("Enter port name:");
     int portNo = sc.nextInt();
     out.println("Enter unique Id:");
     String uniqueId = sc.next();
     out.println("Enter user id:");
     String userId = sc.next();
     out.println("Enter password");
     String password = sc.next();
     
     Registry reg = LocateRegistry.getRegistry(serverName,portNo);
     
     LoginInterface li = (LoginInterface)reg.lookup("AUTH");
     
     boolean bool = li.check(userId,password);
     if(bool)
     {
         out.println("HELLO WORLD");
     }
     else
     {
         System.exit(0);
     }    
 }
}
