package recursion;

public class CalPower {

	
	public static int calPower(int x,int n) {
		if(n==0) {
			return 1;
		}
		if(x==0) {
			return 0;
		}
		int xpowerm=calPower(x, n-1);
		int xpower=x*xpowerm;
		return xpower;
	}
	public static void main(String[] args) {
		// power calculation of given base time complexity O(n)
		int x=2;
		int n=3;
		
         int ans=calPower(2, 5);
         System.out.println("ans is "+ans);
	}

}
