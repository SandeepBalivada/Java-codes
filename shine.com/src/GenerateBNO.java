import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class GenerateBNO {

    static void generatePrintBinary(int n)
    {
        // Create an empty queue of strings
        Queue<String> q = new LinkedList<String>();
        int count=0;
        // Enqueue the first binary number
        q.add("1");
       
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();
        while(n-- > 0)

            String s1 = q.peek();
            int s1int = Integer.parseInt(s1);
            s1int = s1int*9;
            q.remove();
            
            if(s1int % N == 0)
            {
            	System.out.println(s1int);
            	break;
            }
            
            // Store s1 before changing it
            String s2 = s1;
             
            // Append "0" to s1 and enqueue it
            q.add(s1 + "0");
        
            q.add(s2 + "1");
        }
    }
	public static void main(String[] args) {

		  int n=511;
	        generatePrintBinary(n);

	}

}
