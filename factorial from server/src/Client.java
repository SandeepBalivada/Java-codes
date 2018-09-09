import java.util.*;
import java.net.*;
import java.io.*;
public class Client {
	public static void main(String[] args) throws SocketException, IOException {
		Scanner scan = new Scanner(System.in);
		//String data = scan.nextLine();
		try{
			System.out.println("Entered try block");
		    InetAddress address = InetAddress.getByName("localhost");
		    System.out.println(address+"\n");
                    System.out.println("Enter a number to find its factorial. \n *Enter -1 to end connection \n*");
		}
		catch (UnknownHostException e)
		{
			System.out.println("Exception caught");
			System.out.println(e);
		}
		DatagramSocket clientSocket = new DatagramSocket();
		//System.out.println(address);
		//System.out.println("Working fine till here after these changes 1 "+ data+"\n");
		
		while(true)
		{
			byte[] sendBuffer = new byte[1024];
			byte[] receiveBuffer = new byte[1024];
			System.out.print("Client: ");
			int clientDataInt = scan.nextInt();
                        if(clientDataInt== -1)
			{
				System.out.println("**Connection ended**");
				break;
			}
			String clientData = Integer.toString(clientDataInt);
			//System.out.println("You entered :"+clientData+"\n");
			sendBuffer = clientData.getBytes();
			InetAddress address = InetAddress.getByName("localhost");
			DatagramPacket sendPacket = new DatagramPacket(sendBuffer,sendBuffer.length,address,9443);
			//clientSocket.send(sendPacket);
			/*if(clientData.equalsIgnoreCase("bye"))
			{
				System.out.println("Connection ended by client");
				break;
			}*/
			clientSocket.send(sendPacket);
			DatagramPacket receivePacket = new DatagramPacket(receiveBuffer,receiveBuffer.length);
			clientSocket.receive(receivePacket);
			String serverData = new String(receivePacket.getData());
			System.out.println("Server: "+ serverData.trim()+"\n");
		}
		clientSocket.close();		
		scan.close();
	}
	
}
