package ds;

import java.util.Scanner;

public class EvenArray
{
	 int evenCount(int[] arr1 , int size)
	{  int evenc=0;
		for(int i=0;i<arr1.length;i++)
		{
			if(arr1[i]%2==0)
			{
				evenc=evenc+1;
				
			}
		}
		return evenc;
	}
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size of array");
		int size=sc.nextInt();
		int[] arr=new int[size];
		System.out.println("enter the elements of array");
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=sc.nextInt();
		}
		EvenArray a=new EvenArray();
		
		int arr1=a.evenCount(arr,size);
	
		System.out.println("even count= "+arr1);
		
		
	}

	

}
