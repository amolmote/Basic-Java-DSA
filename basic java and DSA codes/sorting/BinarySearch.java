package sorting;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] arr=new int[] {1,2,3,4,6,7,8};
		int key=3;
		int first=0;
		int last=arr.length-1;
		
		int mid=(first+last)/2;
		
		while(first<=last) {
			if(arr[mid]==key) {
				System.out.println("element at "+mid);
				break;
			}
			else if(arr[mid]<key) {
				first=mid+1;
			}
			else {
				last=mid-1;
			}
			
			mid=(first+last)/2;
		}
		
		if(first>last) {
			System.out.println("not found");
		}

	}

}
