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
        	DatagramPacket receivedPacket = new DatagramPacket(receiveBuffer,receiveBuffer.length);
        	serverSocket.receive(receivedPacket);
        	InetAddress address = receivedPacket.getAddress();
        	int portno = receivedPacket.getPort();
        	String clientData = new String(receivedPacket.getData());
        	System.out.println("Client: "+clientData.trim()+"\n");
                int clientDataInt = Integer.parseInt(clientData.trim());
        	System.out.print("Server: ");
        	//String serverData = scan.nextLine();
        	//System.out.println("You entered: "+serverData+"\n");
                int fact=1;
                if(clientDataInt !=0)
                 {
                for(int i=1;i<=clientDataInt;i++)
                {
                   fact = fact*i;
                }

                }
                int serverDataInt = fact;
                String serverData = Integer.toString(serverDataInt);
                //String serverData = scan.nextLine();
                System.out.println(serverDataInt);
        	sendBuffer = serverData.getBytes();
        	DatagramPacket sendPacket = new DatagramPacket(sendBuffer,sendBuffer.length,address,portno);
        	//serverSocket.send(sendPacket);
        	if(serverData.equalsIgnoreCase("bye"))
			{
				System.out.println("Connection ended by the server");
				break;
			}
                 serverSocket.send(sendPacket);
        }
		scan.close();
		serverSocket.close();
	}

}
