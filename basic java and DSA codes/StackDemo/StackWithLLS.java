package StackDemo;

public class StackWithLLS {
	Node head,top;
	int length;
	public StackWithLLS() {
		this.head=null;
		this.top=null;
		this.length=0;
	}
	public void pushStack(int data) {
		Node newNode=new Node(data);
		
		if(top==null) {
			top=newNode;
			head=newNode;
			length++;
			System.out.println("data push is "+top.data+ " and length is "+length);
			return;
		}
		  top.next=newNode;
		  top=newNode;
		  length++;
		  System.out.println("data push is "+top.data+ " and length is "+length);
		
	}
	 public void popStack() {
		 Node temp=head;
		 if(isEmpty()) {
			 System.out.println("Stack list is  underFlow");
		 }
		 for(int i=0;i<length-2;i++) {
			 temp=temp.next;
		 }
		   temp.next=null;
		   System.out.println("data popped from stack list is "+this.top.data+" and length is "+length);
		   this.top=temp;
		   length--;
		   
		 
	 }

	private boolean isEmpty() {
		
		return length==0;
	}
	public static void main(String[] args) {
		StackWithLLS stackList=new StackWithLLS();
	 stackList.pushStack(10);
	 stackList.pushStack(20);
	 stackList.pushStack(30);
	 stackList.pushStack(40);
	 stackList.popStack();
	 stackList.popStack();
	}

}
