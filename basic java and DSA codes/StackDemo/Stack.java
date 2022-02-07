package StackDemo;

import java.util.Arrays;

public class Stack 
{
	int top=-1;
	final int MAX_SIZE=3;
	
	int[] arr=new int[MAX_SIZE];

	
	public boolean push(int data)
	{
		boolean flag=false;
		if(top> MAX_SIZE-1)
		{
			System.out.println("Stack overflow");
			return flag;
			
		}
		else
		{
			arr[++top]=data; //index of top is 0
			System.out.println("data pushed= "+data+" and top is= "+top);
			System.out.println(Arrays.toString(arr));
			flag= true;
			
		}return flag;
	
	}
	public int pop()
	{
		if(top<=-1)
		{
			System.out.println("stack underflow");
			return 0;
		}
		else
		{
			int a= arr[top];
			top--;
			System.out.println(a);
			return a;
		}
	}
	public int peek()
	{
		if(top<=-1)
		{
			System.out.println("stack underflow");
			return 0;
		}
		else
		{
			int b=arr[top];
			System.out.println(b);
			return b;
		}
	}
	public static void main(String[] args) 
	{
		
		Stack s=new Stack();
		
		int data;
	
	    s.push(12);
	    s.push(37);
	    s.push(66);
	    s.pop();
	    s.pop();
	    s.pop();
	    s.peek();
	
		
		
		

	}

}
