import java.net.*;
import java.rmi.*;
public class Server
{
    public static void main(String args[])
	{
		try
		{
			ServerImpl serobj = new ServerImpl();
			Naming.rebind("rmiprog",serobj);
		}
		catch(Exception e)
		{
			System.out.println("Exception"+e);
		}
	}
}
