
public class QueueTest {
	int front,rear,capacity,size;
	int[] arr=new int[capacity];
	
	

	public QueueTest(int front,int capacity, int size) {
		super();
		this.front = front;
		this.rear = capacity-1;
		this.capacity = capacity;
		this.size = size;
		this.arr = new int[capacity];
	}
	
	public void enQueue(int data) {
		if(isFull(this)) {
			System.out.println("stack is full");
		
		}
		this.rear=(this.rear+1)%capacity;
		this.arr[this.rear]=data;
		this.size++;
		System.out.println("data enqueued from "+this.rear+" and data is "+data);
		
	}



	private boolean isFull(QueueTest queue) {
		
		return (queue.size==queue.capacity);
	}
	public void deque() {
		if(isEmpty(this)) {
			System.out.println("queue is empty");
			return;
		}
		System.out.println("data deque is "+this.front+" data is "+this.arr[this.front]);
		this.front=(this.front+1)%capacity;
		this.size--;
	}

	private boolean isEmpty(QueueTest queue) {
		
		return queue.size==0;
	}

	public static void main(String[] args) {
	QueueTest queue=new QueueTest(0, 4, 0);
           queue.enQueue(10);
           queue.deque();
           queue.deque();
	}

}
