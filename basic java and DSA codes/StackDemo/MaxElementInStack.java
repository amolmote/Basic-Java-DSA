package StackDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxElementInStack 
{

	public static List<Integer> findMax(List<String> operations)
	{
		List<Integer> result=new ArrayList<Integer>();
		Stack<Integer> stack=new Stack<Integer>();
		int temp=-1;
		for(int i=0;i<operations.size();i++)
		{
			String[] type=operations.get(i).split(" ");
			switch(type[0])
			{
			 case "1" :
				       temp=Integer.parseInt(type[1]);
				       stack.push(temp);
				       System.out.println(stack.toString());
				       break;
			 case "2":
				      stack.pop();
				      System.out.println(stack.toString());
				      break;
			 case "3":
				        Stack<Integer> stack2=new Stack<Integer>();
				        int current,max=Integer.MIN_VALUE;
				        while(!stack.isEmpty())
				        {
				        	current=stack.pop();
				        	stack2.push(current);
				        	if(max<current)
				        	{
				        		max=current;
				        	}
				        }
				        while(!stack2.isEmpty())
				        {
				        	current=stack2.pop();
				        	stack.push(current);
				        }
				        System.out.println("max element ="+max);
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) 
	{
		List<String> operations=new ArrayList<String>();
		operations.add("1 66");
		operations.add("1 24");
		operations.add("2");
		operations.add("1 43");
		operations.add("3");
	    operations.add("2");
	    findMax(operations);

	}

}
