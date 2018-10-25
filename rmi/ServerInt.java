import java.rmi.*;
public interface ServerInt extends Remote
{
int fact(int n)throws Exception;
}
