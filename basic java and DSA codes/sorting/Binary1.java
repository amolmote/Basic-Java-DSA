package sorting;

public class Binary1 {

	
	public static int binarySearch(int[] arr,int key) {
		int first=0,last=arr.length-1,mid=-1;
		
		while(first<=last) {
			
			mid=first+(last-first)/2;
			
			if(arr[mid]==key) {
				return mid;
			}
			else if(arr[mid]<key) {
				first=mid+1;
			}
			else {
				last=mid-1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		 int[] arr=new  int[] {1,2,3,4,6,7,8};
		 int ans=binarySearch(arr, 6);
			System.out.println("key present at index "+ans);
	}

}
