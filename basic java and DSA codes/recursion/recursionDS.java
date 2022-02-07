package recursion;

public class recursionDS {

	
	public static void recursion(int a, int b,int n) {
		if(n==0) {
			return; 
		}
		int c=a+b;
		System.out.print(" "+ c);
		recursion(b, c, n-1);
		
	}
	public static void main(String[] args) {
		
       int a=0,b=1,n=10;
       System.out.print(a+" "+b);
       recursion(a, b, n-2);
	}

}
