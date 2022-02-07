package collections;

import java.util.Iterator;
import java.util.LinkedList;

public class ReverseLinkedList {

	public static void main(String[] args) {
		LinkedList<String> list=new LinkedList<String>();
		
		list.add("amol");
		list.add("sandesh");
		list.add("santosh");
		list.add("suraj");
		
		System.out.println(list);
		//iterating list in decending order
		System.out.println("printing in decending order");
		Iterator<String> itr=list.descendingIterator();
		
		while(itr.hasNext()) {
			String str=itr.next();
			System.out.println(str);
		}
		System.out.println("printing in ascending order");
          Iterator<String> itr1=list.iterator();
          for (String string : list) {
			System.out.println(string);
		}
          
	}

}
