package queue;

public class QueueFront {

	QueueFNode front,rear;
	public QueueFront() {
		this.front=null;
		this.rear=null;
	}
	//enqueue -->10(front)-->20-->30-->40(rear)
	public void enqueueFront(int data) {
		QueueFNode newNode=new QueueFNode(data);
		if(this.front==null && this.rear==null) {
			this.front=newNode;
			System.out.println("first data enqueued at front "+this.front.data);
			return;
		}
		newNode.next=this.front;
		this.front=newNode;
		System.out.println("data enqueued "+this.front.data);
	}
	//10(front)-->20-->30-->40(rear)<--dequeue
	public void rearDeque() {
		
		if(this.front==null && this.rear==null) {
			System.out.println("queue is empty");
			return;
		}
		else if(this.front.next!=this.rear) {
			//this.front=null;
			this.rear=null;
			System.out.println("all data dequeued ");
			
			return;
		}
		else {
			QueueFNode node=this.front;
			while(node.next.next!=null)
			{
				node=node.next;
			}
			int value=node.next.data;
			node.next=null;
			this.rear=node;
			System.out.println("data dequeued is "+value);
			
		}		
		
	}
	public void display() {
		
		
        if(this.front==null && this.rear==null) {
        	System.out.println("queuelist is empty");
        	return;
        }
		QueueFNode newNode=this.front;
		while(newNode.next!=null) {
			System.out.println(newNode.data);
			newNode=newNode.next;
		}
		System.out.println(newNode.data);
	}
	
	public static void main(String[] args) {
		QueueFront queue=new QueueFront();
          queue.enqueueFront(10);
          queue.enqueueFront(20);
         // queue.enqueueFront(30);
         // queue.enqueueFront(40);
          queue.rearDeque();
          queue.rearDeque();
          queue.rearDeque();
          queue.display();
          
	}

}
