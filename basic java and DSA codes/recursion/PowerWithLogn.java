package recursion;

public class PowerWithLogn {

	public static int calPower(int x,int n) {
		if(n==0) {
			return 1;
		}
		if(x==0) {
			return 0;
		}
		if(n % 2==0) {
			return calPower(x, n/2)*calPower(x, n/2);         //x^4=x^2*x^2=2^2*2^2=16
		}														//x^2*x^2=x^1*x^1=2^1*2^1*2^1*2^1=16
		else														//power is spitted like this and return
			return calPower(x, n/2)*calPower(x, n/2)*x;
		
	}
	
	public static void main(String[] args) {
		// implementing logn for calculating power
		int x=2,n=4;
		int ans=calPower(2, 4);
		System.out.println(ans);

	}

}
