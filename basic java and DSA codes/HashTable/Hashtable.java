package HashTable;

public class Hashtable {
	
	
	int capacity;
	int size;
	HashNode[] bucket;
	
	public Hashtable(int capacity) {
		this.capacity=capacity;
		this.bucket=new HashNode[capacity];
	}
	
	class HashNode{
		int key;
		String value;
		HashNode next;
		
		public HashNode(int key,String value) {
			this.key=key;
			this.value=value;
			
		}
	}
     
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if(size==0) {
			return true;
		}
		else
			return false;
	}
	
	public void put(int key,String value) {
		if(key==-1 || value==null) {
			System.out.println("key and values are not exists");
		}
		int bucketIndex=getBucketIndex(key);
		HashNode head=bucket[bucketIndex];
		while(head!=null) {
			if(head.key==key) {
				head.value=value;
				return;
			}
			head=head.next;
		}
		size++;
		head=bucket[bucketIndex];
		
		HashNode node=new HashNode(key,value);
		node.next=head;
		bucket[bucketIndex]=node;
	}
	public int getBucketIndex(int key) {
	      int index=key%capacity;
	      
		return index;
	}
	
	public String get(int key) {
		if(key==-1) {
			System.out.println("key not exists");
		}
		int bucketIndex=getBucketIndex(key);
		
		HashNode head=bucket[bucketIndex];
		
		while(head!=null) {
			if(head.key==key) {
				return head.value;
			}
			head=head.next;
		}
		return null;
	}
      
	public String remove(int key) {
		if(key==-1) {
			System.out.println("key does't exists");
		}
		int bucketIndex=getBucketIndex(key);
		HashNode head=bucket[bucketIndex];
		HashNode previous=null;
		while(head!=null) {
			if(head.key==key) {
				break;
			}
			previous=head;
			head=head.next;
		}
		if(head==null) {
			return null;
		}
		size--;
		if(previous!=null) {
			previous.next=head.next;
		}
		else {
			bucket[bucketIndex]=head.next;
		}
		return head.value;
	}
	public void display() {
		System.out.println("by display method \n");
		for(int i=0;i<bucket.length;i++) {
			HashNode head=bucket[i];
			HashNode temp=head;
			while(temp!=null) {
				System.out.println(temp.key+" , "+temp.value);
				temp=temp.next;
			}
		}
	}
	public static void main(String[] args) {
		Hashtable ht=new Hashtable(10);
		ht.put(11, "Amol");
		ht.put(12,"kajal");
		ht.put(13, "Shital");
		ht.put(14, "Akshay");
		ht.put(16, "venky");
		ht.put(17, "Suyog");
		ht.put(18, "Sagar");
		ht.put(41, "santosh");
		
		System.out.println("size of hashtable is "+ht.size());
		
		System.out.println("-----------------------------------");
		
		System.out.println("cheching hashtable is empty or not--->>"+ht.isEmpty());
		
		System.out.println("--------------------getting values------------------");
		
		System.out.println(ht.get(12));
		System.out.println(ht.get(11));
		
		System.out.println("----------------removing values----------------");
		
		System.out.println(ht.remove(17));
		System.out.println(ht.remove(18));
		
		System.out.println("------------------display all hashtable------------------");
		
		ht.display();

	}

}
