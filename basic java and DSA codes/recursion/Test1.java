package recursion;

import java.util.Scanner;

public class Test1 {
   
	
	public static void printNum(int num) {
		
		
		if(num==10) {
			return;
		}
		System.out.println(num);
		printNum(num+1);
		
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number");
		int num=sc.nextInt();
		
		printNum(num);
	}
}
