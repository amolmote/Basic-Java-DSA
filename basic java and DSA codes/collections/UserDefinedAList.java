package collections;

import java.util.ArrayList;
import java.util.Iterator;

class Students{
	int id,age;
	String name;
	public Students(int id,String name,int age) {
		this.id=id;
		this.name=name;
		this.age=age;
	}
	
}
public class UserDefinedAList {

	public static void main(String[] args) {
		Students s1=new Students(1,"amol",26);
		Students s2=new Students(2, "akshay", 24);
		Students s3=new Students(3,"santosh",26);
		
		ArrayList<Students> list=new ArrayList<Students>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		
		Iterator itr=list.iterator();
		while(itr.hasNext()) {
			Students st=(Students)itr.next();
			System.out.println("student id is "+st.id+" name is "+st.name+" and age is "+st.age);
		}

	}

}
