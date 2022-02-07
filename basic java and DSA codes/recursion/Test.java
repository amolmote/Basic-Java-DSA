package recursion;

import java.util.Scanner;

public class Test {

	
	public static void printNum(int n)
	{
		//printing numbers from n to 1
		if(n==0)
		{
		    return;	
		}
			
			System.out.println(n);
			printNum(n-1);
	}
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number");
		int n=sc.nextInt();
		printNum(n);
	}
}
