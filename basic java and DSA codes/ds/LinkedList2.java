package ds;

public class LinkedList2 
{

	Node head;

	class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	public LinkedList2  insertAtstart(LinkedList2 list,int data)
	{
		Node a =new Node(data);
		if(list.head==null)
		{
			list.head=a;
			return list;
		}
		else
		{
			a.next=head;
			list.head=a;
		}

		return list;
	} 
	public void display()
	{
		Node a=head;
		while(a.next!=null)
		{
			System.out.print(a.data+" -->");
			a=a.next;
			
		}
		System.out.println(a.data+" -->null");
	}

	// Set<Node> set = new HashSet<Node>();

	public boolean detectLoop(LinkedList2 list) {
		Node slow_ptr = list.head;
		Node fast_ptr = list.head;
		boolean flag=false;
		while(slow_ptr !=null && fast_ptr !=null && fast_ptr.next !=null)
			slow_ptr = slow_ptr.next;
		fast_ptr = fast_ptr.next.next;
		if(slow_ptr == fast_ptr)
		{
			//
			flag= true;
		
			
		}
         if(flag==true)
        	 System.out.println("loop found");
         else
        	 System.out.println("no loop found");
		return flag;
	}

	public static void main(String[] args) 
	{
		LinkedList2 list = new	LinkedList2();

		list.insertAtstart(list,2);
		list.insertAtstart(list,3);
		list.insertAtstart(list,2);
		list.insertAtstart(list,8);

		list.insertAtstart(list,2);
		list.display();
		list.head.next.next.next.next.next=list.head.next;
	    list.detectLoop(list);
		

	}

}
