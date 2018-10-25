import java.rmi.*;
import java.rmi.server.*;
public class ServerImpl extends UnicastRemoteObject implements ServerInt
{
      public ServerImpl( )throws Exception
		{

		}
	public int fact(int n)
 	{
		int i,c=1;
		for(i=1;i<=n;i++)
		{
			c=i*c;
		}
		return c;
	}
}
