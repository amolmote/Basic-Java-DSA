package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListToArray {

	public static void main(String[] args) {
		
		//converting arraylist into array
	   List<String> list=new ArrayList<String>();
	   list.add("sk");
	   list.add("sandesh");
	   list.add("amol"); 
	    Collections.sort(list);    // to sort the list with alphabatically order 
	  
	   String[] array=list.toArray(new String[list.size()]);
	   System.out.println(Arrays.toString(array));

	}

}
