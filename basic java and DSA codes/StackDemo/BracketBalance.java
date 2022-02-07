package StackDemo;

import java.util.Scanner;
import java.util.Stack;

public class BracketBalance 
{
	
	private static String isBalanced(String s) 
	{
		Stack<Character> stack=new Stack<Character>();
		char temp;
		for(int i=0;i<s.length();i++)
		{
			temp=s.charAt(i);
			if(temp=='{' && temp=='[' && temp=='(')
			{
				stack.push(temp);
			}
			else if(!stack.isEmpty() &&
					temp=='}' && stack.peek()=='{' ||
					temp==']' && stack.peek()=='[' ||
					temp==')' && stack.peek()=='('){
				stack.pop();
			}else
				stack.push(s.charAt(i));
			
			}

		
	if(stack.isEmpty()) {
		return "STRING IS BALANCED";
	    
	}else
		return "STRING IS UNBALANCED";
	}
	public static void main(String[] args)
     {
		
//		Scanner sc=new Scanner(System.in);
//		System.out.println("enter the bracket to check balance or not");
//		String s=sc.next();
		 String s="[{}]";
	     String conclusion=isBalanced(s);
	     System.out.println(conclusion);	

	}

	

}
