package ds;
import java.util.Scanner;
public class ArrayShift 
{

	public static void main(String[] args) 
	{
		int[] arr=new int[5];
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the array element");
		
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=sc.nextInt();
		}
		
		System.out.println("Array before shifting");
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
         System.out.println();
		int n;
		System.out.println("enter the range do u want to shift the array");
		n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			int j,first;
			first=arr[0];
			
			for( j=0;j<arr.length-1;j++)
			{
				arr[j]=arr[j+1];
			}
			arr[j]=first;
			
		}
		System.out.println();
		System.out.println("array after shift");
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}

	}

}


