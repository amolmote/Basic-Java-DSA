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
  lambda expression.

- Anonymous inner class can extends a normal class.
- Anonymous inner class can extend an abstract class.
- Anonymous inner class can implmenent interface, which contains any number of abstract methods.


- Lambda expression can interface which contains a single abstract method.


## Default methods in interface ##

- Without affecting if we want to add new methods to the interface then we should go for default method.
- dummy implementation
- implementation class is responsible for providing proper implementation.
- Object class methods we can't declare as default in interface, as implementation class already has the Object class all the methods.


-invoking default method 
```
interface Interf{
    default void m1(){
        System.out.println("default method of interface..");
    }
}
class Demo implements Interf {
    public static void main(String[] args) {
         Demo d=new Demo();
         d.m1();
    }
}
```
- overriding default method implementation

```
interface Interf{
    default void m1(){
        System.out.println("default method of interface..");
    }
}
class Demo implements Interf {
    
    public void m1(){
        System.out.println("overriden method from interface..");
    }
    public static void main(String[] args) {
         Demo d=new Demo();
         d.m1();
    }
}

```

### Concept of multiple inheritance for default method ###
- create multiple interfaces with same default method.
- ERROR: class Demo inherits unrelated defaults for m1() from types First and Second
- Code:
```
interface First{
    default void m1(){
        System.out.println("default method of First..");
    }
}

interface Second{
    default void m1(){
        System.out.println("default method of Second..");
    }
}
class Demo implements First, Second {
    
   
    public static void main(String[] args) {
         Demo d=new Demo();
        
    }
}
```
- Solve above problem by overriding m1 method in implementation class.
```
interface First{
    default void m1(){
        System.out.println("default method of First..");
    }
}

interface Second{
    default void m1(){
        System.out.println("default method of Second..");
    }
}
class Demo implements First, Second {
    public void m1(){
        System.out.println("default method of implementation class..");
    }
   
    public static void main(String[] args) {
         Demo d=new Demo();
        d.m1();//default method of implementation class..
    }
}
```

- invoke m1 method of First interface.
```
interface First{
    default void m1(){
        System.out.println("default method of First..");
    }
}

interface Second{
    default void m1(){
        System.out.println("default method of Second..");
    }
}
class Demo implements First, Second {
    public void m1(){
        First.super.m1();
    }
   
    public static void main(String[] args) {
         Demo d=new Demo();
        d.m1();//default method of First..
    }
}
```
- Similarly we can invoke the default method of Second interface also by using **Second.super.m1()**


## static method in interface ##
 - for general utility purpose we don't need to declare static method in class as it doesn't depend on the object, that we can declare in interface itself. hence this concept came in 1.8v of java.
 - this static method only invoked using interfaceName.methodName();
 - we can declare main method also inside interface.
 - This static method of interface is not avaliable to any implementation class of this interface hence we can't invoke this method using class name.
 - and No need to implement also, if interface contains any abstract method then we need to implement it.

code1:
```
interface First{
    static void m1(){
        System.out.println("static method of interface");
    }
}

class Demo  {
    
    public static void main(String[] args) {
        First.m1();
    }
}
```

- code2: main method inside interface
  ```
  interface First{
    public static void main(String[] args) {
        System.out.println("interface main method...");
    }
}
```
  





















