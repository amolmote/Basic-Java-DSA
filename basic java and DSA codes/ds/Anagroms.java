package ds;

import java.util.Scanner;

public class Anagroms 
{

	public static void main(String[] args) 
	{
		String s1,s2;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter string 1");
              s1=sc.next();
              
         System.out.println("enter string 2");
             s2=sc.next();
             
         if(s2.compareTo(s2)==0)
         {
        	 System.out.println("anagroms");
         }
         else
        	 System.out.println("not anagroms");
	}

}
