package StackDemo;

import java.util.Arrays;

public class Stack1
{
	
	int top=-1;
	
	int[] arr=new int[4];
	
   public void  push(int data)
   {
	   if(top>=4-1)
	   {
		   System.out.println("stack overflow");
		   
	   }
	   else
	   {
		   arr[++top]=data;
		   System.out.println("data pushed= "+data);
	   }
   }
   public void pop(int data)
   {
	   if(top<=-1)
	   {
		   System.out.println("stack underflow");
		   
	   }
	   else
	   {
		   int a=arr[top];
		   top--;
		   System.out.println("data pop is= "+a);
		   
		   System.out.println(Arrays.toString(arr));
	   }
   }
   public void peek()
   {
	   if(top<=-1)
	   {
		   System.out.println("stack overflow");
	   }
	   else
	   {
		   int a=arr[top];
		   System.out.println("peek data is= "+a);
	   }
   }
   
}
