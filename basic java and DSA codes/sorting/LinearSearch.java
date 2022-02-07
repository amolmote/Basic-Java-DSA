package sorting;

public class LinearSearch {

	public static void main(String[] args) {
		
         int[] arr=new int[] {1,2,8,6,7,8};
         
         int key=8;
         for(int i=0;i<arr.length;i++) {
        	 if(arr[i]==key) {
        		 System.out.println("key present at "+i);
        		
        	 }else {
        		 System.out.println("key is not present "+i);
        	 }
         }
         
	}

}
