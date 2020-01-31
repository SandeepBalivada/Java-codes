
public class LinkedList {
	Node head;
	
	public void put(int data)
	{
		Node node = new Node();
		node.data = data;
		node.next = null;
		
		if(head == null)
		{
			head = node;
			
		}
		else{
			Node n = head;
			while(n.next!=null)
			{
				n = n.next;
						
			}
			n.next= node;
			
		}
			
		
	}

	public void showUs()
	{
		if(head==null)
			System.out.println("Empty list");
		else
		{
			Node n = head;
			while(n.next!=null)
			{
				System.out.println(n.data);
				n = n.next;
			}
			System.out.println(n.data);
		}
	}

	public void takeOffAt(int pos)
	{
		Node n = head;
		//Node k = new Node();
		for(int i=0;i<pos-1;i++)
		{
			n = n.next;
		}
		 n.next = n.next.next;
	}
}
