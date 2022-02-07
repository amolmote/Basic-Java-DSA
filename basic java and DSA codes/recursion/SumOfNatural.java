package recursion;


// sum of n natural numbers
public class SumOfNatural {
 
    public static void printSum(int i, int num, int sum) {
    	if(i==num) {
    		sum+=i;
    		System.out.println(sum);
    	    return;
    	}
    	sum+=i;
    	printSum(i+1,num,sum);
    	System.out.println(i);           //output in the form of stack
    }
	public static void main(String[] args) {
		
       printSum(1, 5, 0);
	}

}
