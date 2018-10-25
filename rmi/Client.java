import java.io.*;
import java.rmi.*;
import java.util.*;
public class Client
{
       public static void main(String args[ ])throws Exception
   {
     try
       {
         	String s="rmi://localhost/rmiprog";
			ServerInt val=(ServerInt)Naming.lookup(s);
			System.out.print("Enter the number to find the factorial : ");
			/*DataInputStream m=new DataInputStream(System.in);
			int n1=Integer.parseInt(m.readLine());*/
			Scanner scan = new Scanner(System.in);
			int n1 = scan.nextInt();

			System.out.println("The factorial of "+n1+" is :" + " " + val.fact(n1));
			scan.close();
		}
	catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
