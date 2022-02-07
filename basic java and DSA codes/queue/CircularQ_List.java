package queue;

public class CircularQ_List {

	CirQueNode front,rear;
	public CircularQ_List() {
		this.front=null;
		this.rear=null;
	}
	public void enqueue(int data) {
		CirQueNode newNode=new CirQueNode(data);
		if(this.front==null && this.rear==null) {
			this.front=this.rear=newNode;
			System.out.println("first Node enqueued");
			return;
		}
		this.rear.next=newNode; //data inserted at the next the previous rear
		newNode.next=front;      //circular link
		this.rear=newNode;   //rear pointing to the newNode
	}
	    public void dequeue() {
	    	if(this.front==null && this.rear==null) {
	    		System.out.println("queueList is empty");
	    		return;
	    	}
	    	else
	    	    {
	        	int value=this.front.data;
	    	    this.front=this.front.next;                 //no need of while loop here
	    	    this.rear.next=this.front.next;      //77(front)--27--12(rear)
	    	    System.out.println("data dequeued is "+value);
	    	    }
	    	
	    }
	public void display(CircularQ_List queueList) {
		CirQueNode newNode=front;
		CirQueNode frontNode=rear;
		 
		do{
			System.out.println(newNode.data);
			newNode=newNode.next;
			
		}while(frontNode!=newNode);
		System.out.println(newNode.data);
	
	}
	public static void main(String[] args) {
	CircularQ_List queueList=new CircularQ_List();
	queueList.enqueue(12);
	queueList.enqueue(27);
	queueList.enqueue(77);
	queueList.display(queueList);
	queueList.dequeue();
	queueList.dequeue();
	queueList.dequeue();
	queueList.dequeue();
	//queueList.display(queueList);
	
	

	}

}
