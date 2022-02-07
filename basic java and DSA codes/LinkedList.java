
public class LinkedList {

	Node head;
	
	
	
	
	public LinkedList insertAtStart(LinkedList list,int data) {
		Node newNode=new Node(data);
		if(head==null) {
			list.head=newNode;
			return list;
		}
		  newNode.next=head;
		  list.head=newNode;
		  return list;
		  
		
	}
	
	
	public LinkedList insertAtIndex(LinkedList list,int index,int data) {
		Node newNode=new Node(data);
		Node currentNode=head;
		for(int i=0;i<index-1;i++) {
			currentNode=currentNode.next;
		}
		newNode.next=currentNode.next;
		currentNode.next=newNode;
		return list;
	}
	
	public LinkedList insert(LinkedList list,int data) {
		Node newNode=new Node(data);
		Node currentNode=head;
		while(currentNode.next!=null) {
			currentNode=currentNode.next;
		}
		currentNode.next=newNode;
		return list;
	}
	public void display() {
		Node newNode=head;
		while(newNode.next!=null) {
			System.out.println(newNode.data+"-->");
			newNode=newNode.next;
		}
		System.out.println(newNode.data+"--->null");
		
	}
	
	
	public static void main(String[] args) {
		
			LinkedList list=new LinkedList();
			list.insertAtStart(list,12);
			list.insert(list, 14);
		
	}

}
