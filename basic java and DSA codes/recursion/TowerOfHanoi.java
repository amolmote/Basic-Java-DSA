package recursion;

public class TowerOfHanoi {

	public static void discTransfer(int n,String src,String helper, String dest) {
		if(n==1) {       //(Step: 2)now 1 disc is remaining in src this is directly transfered from src to destination
			System.out.println("disc transer "+n +" from "+src+" to "+ dest);
			return;
		}
		discTransfer(n-1, src, dest, helper);   //(step: 1)when=2 disc from this first disc transfer from src to helper
		System.out.println("disc transfer "+n+" from "+src+" to "+ dest);
		discTransfer(n-1, helper, src, dest);  //(step: 3)now the disc from helper is transfered to dest.
	}
	public static void main(String[] args) {
		//when disc=2 then 3 steps required to transfer all the discs from src to destination
	  int n=2;
	  discTransfer(n, "S","H", "D");

	}

}
