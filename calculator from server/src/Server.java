import java.util.*;
import java.net.*;
import java.io.*;
public class Server {

	public static void main(String[] args) throws SocketException, IOException {
		DatagramSocket serverSocket = new DatagramSocket(9443);
		Scanner scan = new Scanner(System.in);
		//String data = scan.nextLine();
		//System.out.println("Working fine till here after these changes 1 "+data+"\n");
       while(true)
        {
        	byte[] receiveBuffer = new byte[1024];
        	byte[] sendBuffer = new byte[1024];
            double ans=0.0;
        	DatagramPacket receivedPacket = new DatagramPacket(receiveBuffer,receiveBuffer.length);
        	serverSocket.receive(receivedPacket);
        	InetAddress address = receivedPacket.getAddress();
        	int portno = receivedPacket.getPort();
        	String clientData = new String(receivedPacket.getData());
            clientData = clientData.trim();
        	//System.out.println("Client: "+clientData);
            String[] clientDataArray = clientData.split(" ");
            int set = Integer.parseInt(clientDataArray[0]);
            if(set == 1)
            { 
             double operand1 = Double.parseDouble(clientDataArray[1]);
             double operand2 = Double.parseDouble(clientDataArray[3]);
             String operator = clientDataArray[2];
             clientData = clientDataArray[1]+" "+clientDataArray[2]+" "+clientDataArray[3];
             System.out.println("Client: "+clientData);
        	 System.out.print("Server: ");
                
                if (operator.equals("+"))
                       ans = operand1 + operand2;
                else if(operator.equals("-"))
                       ans = operand1 - operand2;
                else if (operator.equals("*"))
                       ans = operand1 * operand2;
                else if (operator.equals("/"))
                       ans = operand1 / operand2;
            }
            else if(set == 2)
            {
              String operator = clientDataArray[1];
              int operand = Integer.parseInt(clientDataArray[2]); 
              clientData = clientDataArray[1]+" "+clientDataArray[2];
              System.out.println("Client: "+clientData);
              System.out.print("Server: ");
                if (operator.equalsIgnoreCase("log"))
                    {
                       ans = Math.log10(operand);
                    }
                else if(operator.equalsIgnoreCase("fact"))
                {
                  int fact=1;
                  if(operand !=0)
                  {
                   for(int i=1;i<=operand;i++)
                     fact = fact*i;
                  } 
                  ans = fact;
                }
               
            }
             
                double serverDataInt = ans;
                String serverData = Double.toString(serverDataInt);
                //String serverData = scan.nextLine();
                System.out.println(serverDataInt+"\n");
        	sendBuffer = serverData.getBytes();
        	DatagramPacket sendPacket = new DatagramPacket(sendBuffer,sendBuffer.length,address,portno);
        	//serverSocket.send(sendPacket);
        	if(set == 0)
			{
				System.out.println("*Connection ended*");
				break;
			}
                 serverSocket.send(sendPacket);
        }
		scan.close();
		serverSocket.close();
	}

}
