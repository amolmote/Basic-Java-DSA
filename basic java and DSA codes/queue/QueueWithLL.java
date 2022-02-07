package queue;

public class QueueWithLL {

	
	QueueNode front,rear;
	
	
	public QueueWithLL() {
		this.front = null;
		this.rear = null;
	}

	public void enqueList(int data) {
		QueueNode node=new QueueNode(data);
		
		if(this.front==null) {
			this.front=node;
			this.rear=node;
			System.out.println("first data enqued "+this.rear.data);
			return;
		}
		else {
			this.rear.next=node;        //insert from rear
			this.rear=node;
			System.out.println("data enqueued "+this.rear.data);	
		
		}
		
		
	}
	public void dequeList() {
		if(this.front==null&& this.rear==null) {
			System.out.println("queue list is empty");
			return ;
		}
		else if(this.front==this.rear) {
			this.rear=null;
			this.front=null;
			System.out.println("data dequeued at front "+this.front.data);
			return;
		}
		else
		{
		    QueueNode secondLastNode=this.front;       
		    //deque from front
	        //rear.next is always null       deque-->10(front)--->17--->90(rear)-->null<--enque
		    while(secondLastNode.next.next!=null)
		   {            //so traverse from front
		      	
			    secondLastNode=secondLastNode.next;
		   }
		       int value=secondLastNode.next.data;
		       secondLastNode.next=null;
		       //this.front=secondLastNode;
		       System.out.println("data dequeued "+value);
		       
		}
		
	}
	public void displayQueue() {
		//System.out.println(front.data);
		QueueNode node=front;
		if(front==null && rear==null) {
			System.out.println("queue list is empty");
			return;
		}
		while(node!=null ) {
			System.out.println(node.data);
			node=node.next;
			
		}
		
	
	}

	public static void main(String[] args) {
		QueueWithLL queue=new QueueWithLL();
		queue.enqueList(10);
	    queue.enqueList(17);
		queue.enqueList(90);
     	//System.out.println(queue.front.next.data);
		queue.dequeList();
		queue.dequeList();
		queue.dequeList();   
		/*queue.enqueList(12);
		queue.dequeList();
		queue.dequeList();*/
		//queue.displayQueue();
	}

}
