package sorting;

import java.util.Scanner;

public class BinaryRec {

	
	
	public static int bRec(int[] arr,int first,int last, int key) {
		if(first<=last) {
			int mid=first+(last-first)/2;
			
			if(arr[mid]==key) {
				return mid;
			}
			if(arr[mid]<key) {
				return bRec(arr, mid+1, last, key);
			}else {
				return bRec(arr, first, mid-1, key);
			}
		}
		return -1;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int[] arr=new int[] {1,2,3,4,6,7};
		int leng=arr.length;
		
		
		while(true) {
			System.out.println("enter key for search");
			int key=sc.nextInt();
			int ans=bRec(arr,0,leng-1,key);
			System.out.println("key present at index "+ans);
		
		}
			
	
		

	}

}
