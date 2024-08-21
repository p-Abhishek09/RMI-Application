import java.sql.PreparedStatement;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckLogin extends UnicastRemoteObject implements LoginInterface
{
    public CheckLogin() throws RemoteException
    {}
    
    //@Override
    public boolean check(String userId, String pass) throws RemoteException
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","tanu");
            PreparedStatement ps = con.prepareStatement("select * from chattab where userid=? and password=?");
            ps.setString(1,userId);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                return true;
            else 
                return false;
        }
        catch(SQLException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
            return false;
        }
    }
}