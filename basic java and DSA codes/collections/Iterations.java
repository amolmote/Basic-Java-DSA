package collections;

import java.util.ArrayList;
import java.util.Iterator;

public class Iterations {

	public static void main(String[] args) {
		
		ArrayList<String> list=new ArrayList<String>();
		
		list.add("amol");
		list.add("sandesh");
		list.add("Santosh");
		list.add("suraj");
		// use of list iterator to traverse the elements
		java.util.ListIterator<String> list1=list.listIterator(list.size());
		System.out.println("iterating list by using listIterator");
		while(list1.hasPrevious()) {
			String list2=list1.previous();
			System.out.println(list2);
			
			
			System.out.println("iterating list by using for loop");
			// iterating by for loop
			for(int i=0;i<list.size();i++) {
			  System.out.println(list.get(i));
			}
			
			System.out.println("traversing list by using for_each loop and lambda xpre");
			
			list.forEach(a->{
				System.out.println(a);
			});
			
			System.out.println("iterating by forEachRemaining by using lambda and iterator");
			Iterator<String> itr=list.iterator();
			itr.forEachRemaining(a->{
				System.out.println(a);
			});
			
			
		}
	}

}
