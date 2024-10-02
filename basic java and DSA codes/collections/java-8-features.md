# Lambda expresssion #

Lambda expression is a anonymous funtion
- A function without name
- without modifier
- without return type


**Note**: Lambda expression is specific to FunctionalInterface only without it we can't write lambda expressions.  

example1: 
```
public void m1(){
  System.out.println("hello");
}

() -> { System.out.println("hello");}  //single statement no curly braces required

()-> System.out.println("hello");
```

example2:
```
public void sum(int a, int b){
   System.out.println("sum is: "+a+b);
}

(int a, int b) -> { System.out.println("sum is: "+a+b); } //removed method name, return type and modifier

(int a, int b) -> System.out.println("sum is: "+a+b); //removed braces

(a,b) -> System.out.println("sum is: "+a+b);//input argument type not required, compiler will understand
```

example3: 
```
public void square(int n){
  System.out.println("Square of num is: "+n*n);
}

(int n) -> { System.out.println("Square of num is: "+n*n); }

(int n) -> System.out.println("Square of num is: "+n*n);

(n) -> System.out.println("Square of num is: "+n*n);

n -> System.out.println("Square of num is: "+n*n); //single input argument, no need of parenthesis
```


which are valid 
```
n -> return n*n;//invalid- missing curly braces

n-> {return n*n;};//valid

n-> {return n*n};//invalid

n->{n*n;};//invalid return is missing

n-> n*n;//valid-  valid way of using 
```

- without curly braces we can't use return statement.
- with curly braces we have to use return statement.


## Functional Interface ##
- The interface which contains single abstract method is called Functional Interface.
- examples:
1. Runnable: run()
2. Callable: call()
3. Comparable: compareTo()
4. Comparator: compare()

```
@FunctionalInterface
interface Test{

public void m1();

default void m2(){

}
public static void m3(){

}
}
```

### FunctionalInterface wrt Inheritance ###

valid
```
@FunctionalInterface
interface A{

    public void m1();

}

@FunctionalInterface
interface B extends A{

}

```

valid
```
@FunctionalInterface
interface A{

    public void m1();

}

@FunctionalInterface
interface B extends A{
   public void m1();
}

```
invalid 
```
@FunctionalInterface
interface A{

    public void m1();

}

@FunctionalInterface
interface B extends A{
   public void m2();
}

```
valid
```
@FunctionalInterface
interface A{

    public void m1();

}

interface B extends A{
   public void m2();
}

```

### Lambda expression with FunctionalInterface ###

using interface without lambda
```
interface Interf{
    public void m1();
}

class Demo implements Interf{
    
    public void m1(){
        System.out.println("hello...");
    }
}

public class InterfaceConceptDemo {
    public static void main(String[] args) {
        Demo d=new Demo();
        d.m1();
    }
}
```
More concise way of writing using lambda express
```
interface Interf{
    public void m1();
}

public class InterfaceConceptDemo {
    public static void main(String[] args) {
        Interf i=()->System.out.println("hello...using lambda");
        i.m1();
    }
}
```

few more examples:
```
interface Interf{
    public int square(int num);
}

public class InterfaceConceptDemo {
    public static void main(String[] args) {
        Interf i=n->n*n;
        System.out.println(i.square(4));
    }
}
```
String based functional interface example:
```
interface Interf{
    public int nameLength(String name);
}

public class InterfaceConceptDemo {
    public static void main(String[] args) {
        Interf i=s->s.length();
        System.out.println(i.nameLength("amol"));
    }
}

```

## Lambda expression with Multithreading ##

```
class ThreadsWithLambda {
    public static void main(String[] args) {
       Runnable r=()-> {
           for(int i=0;i<6;i++){
               System.out.println("child thread..");
           }
       };
       
       Thread t=new Thread(r);
       t.start();
      
       for(int i=0;i<6;i++){
            System.out.println("main thread..");
       }
     
    }
}
```

## Lambda expression with Collection ##

with normal approach, without lambda:
```
import java.util.*;


class MyComparator implements Comparator<Integer>{
    
    public int compare(Integer i1, Integer i2){
        return i1>i2?-1:i1<i2?1:0;
    }
}
public class SortArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(12);
        list.add(2);
        list.add(7);
        list.add(1);
        
       // Collections.sort(list); calls Comparable's compareTo method which provides default natural sorting order
       
       Collections.sort(list, new MyComparator());//customized reverse order
        System.out.println(list);
    }
}
```

With lambda expression 

```
import java.util.*;

public class SortArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(7);
        list.add(1);
        
       System.out.println(list);
       Comparator<Integer> c=(i1,i2)->(i1>i2)?-1:(i1<i2)?1:0;
       Collections.sort(list, c);//customized reverse order
        System.out.println(list);
    }
}
```

### Lambda expression for Custom Object collection ###
```
import java.util.*;

class Student{
    
    int sid;
    String sname;
    
    public Student(int sid, String sname){
        this.sid=sid;
        this.sname=sname;
    }
    
    public String toString(){
        return sid+":"+sname;
    }
}
public class ApplyLambdaForCustomObject {
    public static void main(String[] args) {
        ArrayList<Student> l=new ArrayList<>();
        l.add(new Student(2891,"amol"));
        l.add(new Student(9832,"gunny"));
        l.add(new Student(3290,"joe"));
        l.add(new Student(8923,"muni"));
        System.out.println(l);
        
        Collections.sort(l, (s1,s2)->(s1.sid<s2.sid)?-1:(s1.sid>s2.sid)?1:0);//ascending order based on the sid
        System.out.println(l);
        
        Comparator<Student> s = (s1,s2)->s1.sname.compareTo(s2.sname);//aphabatial order
        
        Collections.sort(l,s);
        
        System.out.println(l);
    }
}
```


### Anonymous Inner class vs Lambda Expression ###

We are writing a class which is extending to the thread class(note this has doesn't have any name, called anonymous)
```
Thread t=new Thread{
   public void run(){

  }
// t is the object of child class of Thread
};
```
now we will create a anonymous class which will implements the Runnable interface.
```
Runnable r=new Runnable(){
   public void run(){

  }
//r is the object of class which is implementating Runnable interface.
};
```

- Anonymous inner class is not equivalent to the lambda expression
- If anonymous inner class implements a interface which contains single abstract method then only we can replace that anonymous inner class with
  lambda expression





















