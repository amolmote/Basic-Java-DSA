package sorting;

public class InsertionSort {
	
	
	
	private static int[] insertionSort(int[] arr) {
		int data,j;
	 for(int i=1;i<arr.length;i++){  //(0)22(j),(1)32,(2)26(data),(3)38,(4)3,(five)21
		 								
		 data=arr[i];
		 j=i-1;
		 while(j>=0 && arr[j]>data){
			 arr[j+1]=arr[j];   //
			 j--;
		 }
		 arr[j+1]=data;
		 	 
	 }
	 return arr;
	}
	
	public static void printinsertionSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] args) {
		int[] arr=new int[] {22,32,26,38,3,21};
		
		insertionSort(arr);
		System.out.println("sorted array is");
		printinsertionSort(arr);

	}

}
