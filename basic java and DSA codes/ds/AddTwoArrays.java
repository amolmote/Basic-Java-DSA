package ds;

import java.util.Arrays;

public class AddTwoArrays 
{


	
	

	public int Findsum(int arr[], int size)
	{
		int sum=0;
	    for (int i = 0; i <arr.length; i++)
	    {
	           sum=sum+arr[i];
	    }
	    return sum;
	}
	 
	public static void main(String[] args)
	{
		AddTwoArrays s=new AddTwoArrays ();
		
		  int arr[] = {10,20,30,40,70};
		 int  arr_sum=s.Findsum(arr, 4);
		 
		 System.out.println("sum is: "+arr_sum);
		  

	}

}