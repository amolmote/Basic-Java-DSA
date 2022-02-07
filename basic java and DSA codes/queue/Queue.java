package queue;

public class Queue {
	
	int front,rear,capacity;
	int[] arr=new int[capacity];
	int size;
	public Queue(int capacity) {
		this.rear=capacity-1;
		this.front=0;
		this.capacity=capacity;
		this.size=0;
		this.arr=new int[capacity];
	}

	 public void enque(int data) {
		 if(isFull(this)) {
			 System.out.println("queue is full");
			 return;
		 }
		 this.rear=(this.rear+1)%this.capacity;
		 this.arr[this.rear]=data;
		 this.size++;
		 System.out.println("data enqueued "+this.rear+" and data is "+data);
			
	 }

	 private boolean isFull(Queue queue) {
			return (queue.size==queue.capacity);
					
		}
	 
	 public void deque() {
		 if(isEmpty(this)) {
			 System.out.println("queue is empty");
		  return;
		 }
		 System.out.println("data dequeued at "+this.front+ " and data is "+this.arr[this.front]);
		
		 this.front=(this.front+1)%this.capacity;
		 this.size--;
		 
	 }
	private boolean isEmpty(Queue queue) {
		return queue.size==0;
			 
	}

	

}
