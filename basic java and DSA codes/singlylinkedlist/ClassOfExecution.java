package singlylinkedlist;



public class ClassOfExecution 
{

	public static void main(String[] args) 
	{
		LinkedList list=new LinkedList();

		list.insert(6);
		list.insert(8);
		list.insert(10);
		list.insertAtStart(99);
		list.insertAtIndex(2, 44);

		list.show();
	
	}

}
