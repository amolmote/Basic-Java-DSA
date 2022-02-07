package ds;

import java.util.Scanner;

public class Sum67 
{

	int sum6_7(int[] arr1, int size) 
	{    int sum=0;
	    for(int i=0;i<arr1.length;i++)
	    {
	    	if(arr1[i]==6)
	    	{
	    		for(int j=i+1;j<arr1.length;j++)
	    		{
	    			if(arr1[j]==7)
	    			{
	    				i=j;
	    				break;
	    			}
	    		}
	    	}
	    	else if(arr1[i]==6)
	    	{
	    		sum=sum+arr1[i];
	    	}
	    	else
	    	{
	    		sum=sum+arr1[i];
	    	}
	    }
		
		return sum;
	}

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the size of an array");
		int size=sc.nextInt();
		int[] arr=new int[size];
		System.out.println("enter the elements of array");
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=sc.nextInt();
		}
		Sum67 s=new Sum67();
		
		int arr1=s.sum6_7(arr,size);
		System.out.println("sum is= "+arr1);
		
		

	}

	 
}
/*case 1:-->>
 * enter the size of an array
6
enter the elements of array
1
4
7
6
7
8
sum is= 20
case 2-->>
enter the size of an array
6
enter the elements of array
1
2
6
4
9
8
sum is= 24
case 3-->>
enter the size of an array
7
enter the elements of array
2
8
3
6
8
9
7
sum is= 13
*/
