package queue;


class Executive{
	
	public static void main(String[] args) {
		Queue queue=new Queue(6);
		
		queue.enque(10);
		queue.enque(12);
		queue.enque(30);
		queue.enque(77);
		queue.enque(33);
		queue.enque(33);
		queue.enque(77);  //queue is full
	    queue.deque();
	    queue.deque();
		
		
		
		
	}
	
	
}