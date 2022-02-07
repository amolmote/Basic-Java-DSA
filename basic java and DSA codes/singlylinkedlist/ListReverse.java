package singlylinkedlist;


public class ListReverse {

	static Node head;

	static class Node {

		int data;
		Node next;

		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	public Node reverse(Node node)
	{
		Node prev = null;
		Node next = null;
		Node temp = node;
		while (temp != null) 
		{
			next = temp.next;   //10.next=null--->next=10
			temp.next = prev;   //temp.next=null
			prev = temp;         //prev=
			temp = next;
		}
		node = prev;
		return node;
	}


	void show(Node node)
	{
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	
	public static void main(String[] args)
	{
		ListReverse list = new ListReverse();
		list.head = new Node(10);
		list.head.next = new Node(15);
		list.head.next.next = new Node(20);
		list.head.next.next.next = new Node(25);
		
		
		
        System.out.println("Given Linked list");
		list.show(head);
		head = list.reverse(head);
		System.out.println("\nReversed linked list ");
		list.show(head);
	}
}