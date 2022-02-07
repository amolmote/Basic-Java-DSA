package sorting;

public class SelectionSort {

	
	
	public static int[] selectionSort(int[] arr) {
		int temp;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<arr[i]) {
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		return arr;
	}
	
	public static void printBubble(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] args) {
	
       int[] arr=new int[] {1,3,2,7,6,9};
       selectionSort(arr);
       printBubble(arr);
       
	}

}
