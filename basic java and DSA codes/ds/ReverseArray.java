package ds;
import java.util.Scanner;
public class ReverseArray 
{
	
	
			public int[] Rev_Array(int[] arr,int size)
			{
				int[] arr1=new int[size];
				int j=0;
				for(int i=arr.length-1; i>=0;i--)
				{
					arr1[j]=arr[i];
					j++;
				}
				return arr1;
			}
	

	public void main(String[] args) 
	{
		// reversing array by creating method of reverse array
		System.out.println("enter the size of array");
		Scanner sc=new Scanner(System.in);
		int size=sc.nextInt();
       int[] arr=new int[size];
       System.out.println("enter the elements");
       
       for(int i=0;i<arr.length;i++)
       {
    	   arr[i]=sc.nextInt();
       }
       System.out.println("array before reverse");
       for(int i=0;i<arr.length;i++)
       {
    	   System.out.print(arr[i]+" ");
       }
       System.out.println();
       
       ReverseArray ac=new ReverseArray();
       
       int[] arr2=ac.Rev_Array(arr, size);
       
       System.out.println("reversed array is");
       for(int i=0; i<arr.length;i++)
       {
    	   System.out.print(arr2[i]+" ");
       }
       
       

	}

}


