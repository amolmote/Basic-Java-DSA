package singlywithConstructor;


import java.util.HashSet;

public class LinkedList 
{
    Node head;
    
    
    
    
    public LinkedList insertAtStart(LinkedList list,int data)
    {
    	Node newNode=new Node(data);	//System.out.println(newNode);  2 address for 2 data
    		                         	//singlywithConstructor.Node@6f2b958e    data=14
    										//singlywithConstructor.Node@5e91993f
    	if(list.head==null)
    	{
    		list.head=newNode;
    		return list;
    	}
    	else
    	{
    		newNode.next=head;
    		list.head=newNode;
    		
    		return list;
    		
    	}
      	
    }
   
    public LinkedList insertAtIndex(LinkedList list,int index, int data)
    {
    	Node newNode=new Node(data);
                          
    	Node currentNode=head;
                              
    	for(int i=0;i<index-1;i++)
    	{ 
    		currentNode=currentNode.next; 
    		
    	}
                                    
    	newNode.next=currentNode.next;     //node 16 and 77 linked
         currentNode.next=newNode;        //14 and 77 linked
                 
    	return list;
    	
    	
    }
    public LinkedList deleteAtIndex(LinkedList list, int index)
    {
    	
    
    	if(index==0)
    	{
    		list.head=list.head.next;
    	}
    	else
    	{
    		Node currentNode=list.head;
    		Node tempNode=null;
    		for(int i=0;i<index-1;i++)
    		{
    			currentNode=currentNode.next;
    		}
    		tempNode=currentNode.next;// 22 44 88 99
    		currentNode.next=tempNode.next;
    		System.out.println("deleted value is= "+tempNode.data);
    	}
    	return list;
    }
    
    public boolean detectLoop(LinkedList list)
    {
    	Node newNode=list.head;
    	
    	HashSet<Integer> hset=new HashSet<Integer>();
    	while(newNode.next!=null)
    	{
    		if(hset.contains(newNode.data))
    		{
    			return true;
    		}
    		hset.add(newNode.data);
    		newNode=newNode.next;
    	}
    	return false;
    	
    	
    }
    public boolean detectLoopF(LinkedList list)
    {
    	
    	Node slow_ptr=list.head;
    	Node fast_ptr=list.head;
    	boolean flag=false;
    	while(slow_ptr!=null && fast_ptr!=null && fast_ptr.next!=null)
    	{
    		slow_ptr=slow_ptr.next;
    		fast_ptr=fast_ptr.next.next;
    		
    		if(slow_ptr==fast_ptr)
    		{
    			flag=true;
    			break;
    		}
    	}if(flag==true)
    		System.out.println("by floyd algorithm loop found");
    	else
    	  System.out.println(" by floyd algorithm loop not found");
    	return flag;
    }
//    public boolean breakLoop(LinkedList list)
//    {
//    	Node slow_ptr=list.head;
//    	Node fast_ptr=list.head;
//    	Node preNode=
//    	boolean flag=false;
//    	if(slow_ptr!=null && fast_ptr!=null && fast_ptr.next!=null)
//    	{
//    		slow_ptr=slow_ptr.next;
//    		fast_ptr=fast_ptr.next.next;
//    	}
//    	if(slow_ptr==fast_ptr)
//    	{
//    		
//    	}
//    }
	public void insert(LinkedList list, int data) {
		Node newNode=new Node(data);
    	Node currentNode=list.head;
    	
    	while(currentNode.next!=null)
    	{
    		currentNode=currentNode.next;
    	}
    	currentNode.next=newNode;
    	
	}
	public void display()
    {
    	Node newNode=head;
    	while(newNode.next!=null)
    	{
    		System.out.print(newNode.data+ "-->");
    		newNode=newNode.next;
    	}
    	System.out.println(newNode.data+ " -->null");
    	
    	
    }
}
