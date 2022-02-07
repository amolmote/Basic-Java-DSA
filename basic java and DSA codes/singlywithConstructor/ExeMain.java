package singlywithConstructor;



public class ExeMain 
{

	public static void main(String[] args) 
	{
		LinkedList list=new LinkedList();
		//insert at start
		list.insertAtStart(list, 14);
		list.insertAtStart(list, 19);
		list.insert(list, 16);
		list.insert(list, 29);
		list.insert(list, 37);
		list.insert(list, 22);
		list.insert(list, 37);
		//System.out.println(list.head);
		/*list.insertAtStart(list, 8);
		list.insertAtStart(list, 14);
		list.insertAtStart(list, 19);
		list.insertAtStart(list, 26);
		//System.out.println(list.head.data);
		//System.out.println(list.head.next.data);
		boolean flag=list.detectLoop(list);
		System.out.println(flag);
		
		//delete node at perticular index
		
		
		list.delete(list,14);
		list.insertAtIndex(list, 2, 77);*/
		//System.out.println(list.head.next.next.next.data);
		//insert at perticular index
		
		list.insertAtIndex(list, 2, 77);
		
		//list.head.next.next.next.next.next.next.next=list.head.next;  //for making loop
		//list.deleteAtIndex(list,3);
		list.display();
		
		list.detectLoopF(list);
		//Stack<E>
		//java.util.LinkedList<E>
	}

}

