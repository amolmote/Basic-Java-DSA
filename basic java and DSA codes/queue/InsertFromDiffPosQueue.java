package queue;

public class InsertFromDiffPosQueue {

	QueueNode2 front,rear;
	
	public InsertFromDiffPosQueue() {
		this.front=null;
		this.rear=null;
	}
	public void enqueue(int data)
	{
		QueueNode2 newNode= new QueueNode2(data);
		if(this.front == null)
		{
			this.front= newNode;
			System.out.println("first data enqueued at front "+this.front.data);
			
		}
		else
		{
            newNode.next = this.front;
		    this.front = newNode;
		   System.out.println("data enqueued "+this.front.data);
		}
	
	}
	public void dequeue()
	{
		QueueNode2 temp = this.front;
		if(this.front==this.rear){
			System.out.println("last data dequeued "+this.front.data);
			return;
			
		}
		else {
			while (temp.next.next !=null)
			{
				temp = temp.next;
			}
	         int value=temp.next.data;
			temp.next = null;
			this.rear = temp;
			System.out.println(" data dequeued "+value);
		}
		
	}
	public void show()
	{
		QueueNode2 newNode = this.front;

		if(this.front == null && this.rear == null)
		{
			System.out.println(" queue is empty");
		}
		else
		{
			while(newNode.next!=null)
			{
				newNode=newNode.next;
			}
			System.out.println(newNode.data);
		}
	}

	
	public static void main(String[] args) {
		InsertFromDiffPosQueue queue=new InsertFromDiffPosQueue();
		queue.enqueue(12);
		queue.enqueue(16);
		queue.enqueue(99);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.show();

	}

}
