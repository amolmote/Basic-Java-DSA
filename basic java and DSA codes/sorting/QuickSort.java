package sorting;

public class QuickSort {

	
	
	
	public static int partitioning(int[] arr,int left,int right) {
		
		int pivot=arr[(left+right)/2];
		while(left<=right) {
			while(arr[left]<pivot) {
				left++;
			}
			while(arr[right]>pivot) {
				right--;
			}
			if(left<=right) {
				int temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				left++;
				right--;
			}
		}
		return left;
	}
	public static void quichSortRec(int[] arr,int left,int right) {
		int pi=partitioning(arr, left, right);
		if(left<pi-1) {
			quichSortRec(arr, left, pi-1);
		}
		if(pi<right) {
			quichSortRec(arr, pi, right);
		}
	}
	public static void printSortedArray(int[] arr) {
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
	public static void main(String[] args) {
		
			int[] arr= {14,9,7,13,12,16,4,18,11};
			
			int leng=arr.length;
			quichSortRec(arr, 0, leng-1);
			printSortedArray(arr);
			
			
			
			
	}

}
