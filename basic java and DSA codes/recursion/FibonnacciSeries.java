package recursion;

public class FibonnacciSeries {

	public static void printFib(int a, int b,int n) {
		if(n==0) {
			return;
		}
		 int c=a+b;
		 System.out.print(c+" ");
		 printFib(b, c, n-1); //number of terms reduced after every call
		 
	}
	public static void main(String[] args){
		// 0 1 1 2 3 5 8 13 21 
		int a=0;
		int b=1;
		System.out.println(a);
        System.out.println(b);
        int n=7;
        printFib(a, b,n-2);
	}

}
