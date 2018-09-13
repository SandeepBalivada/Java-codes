import java.util.*;
import java.net.*;
import java.io.*;
public class Client {
	public static void main(String[] args) throws SocketException, IOException {
		Scanner scan = new Scanner(System.in);
		//String data = scan.nextLine();
		InetAddress address = null;
		try{
			//System.out.println("Entered try block");
		    address = InetAddress.getByName("localhost");
		    System.out.println(address+"\n");
                    
		}
		catch (UnknownHostException e)
		{
			System.out.println("Exception caught");
			System.out.println(e);
		}
		DatagramSocket clientSocket = new DatagramSocket();
        System.out.println(" 1)Addition \n 2)Subtraction \n 3)Multiplication \n 4)Division \n 5)Log \n 6)Factorial. \n *Enter -1 to end connection* \n");
		//System.out.println(address);
		//System.out.println("Working fine till here after these changes 1 "+ data+"\n");
                
		
		while(true)
		{
			byte[] sendBuffer = new byte[1024];
			byte[] receiveBuffer = new byte[1024];
			int set = 0;
            System.out.println("Enter your choice:");
			int choice = scan.nextInt();
            if(choice== -1)
			{
				System.out.println("**Connection ended**");
				break;
			}
            else{
                if(choice<5 && choice>0)
                {
                    System.out.println("Enter the equation in format: operand1 operator operand2 (Ex: 6 + 5)");
                    set = 1;
                }
                else if(choice==6 || choice==5)
                {
                    System.out.println("Enter the equation in format: operator operand (Ex: log 6)");
                    set = 2;
                }
                else
                    {
                     System.out.println("*Invalid input*.Enter only between 1 to 6 or -1 to exit \n");
                     continue;
                    }
                }
                        
            System.out.print("Client: ");
            scan.nextLine();  //to overcome previous scan of int
			String clientData = scan.nextLine();
			//System.out.println("You entered :"+clientData+"\n");
			clientData = set + " " + clientData;
			sendBuffer = clientData.getBytes();
			//InetAddress address = InetAddress.getByName("localhost");
			DatagramPacket sendPacket = new DatagramPacket(sendBuffer,sendBuffer.length,address,9443);
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
