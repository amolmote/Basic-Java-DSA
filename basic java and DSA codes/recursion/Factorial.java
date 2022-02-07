package recursion;

import java.util.Scanner;

public class Factorial {

	
	public static int calFact(int num) {
		
		if(num==1 || num==0 ) {
			return 1;
		}
		int fact_nm1=calFact(num-1);
		int fact_num=num*fact_nm1;
		return fact_num;
	}
	public static void main(String[] args) {
		//n!=n*(n-1)+n*(n-2)+n*(n-3).....1   time complexity O(n)

		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number to calculate factorial");
		int num=sc.nextInt();
		int ans=calFact(num);
		System.out.println("factorial of "+num+" is "+ans);
	}

}
