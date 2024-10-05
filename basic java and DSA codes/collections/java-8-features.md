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

- sample code
```
  interface First{
    public static void main(String[] args) {
        System.out.println("interface main method...");
    }
}
```

## Predefined Functional Interfaces ##

  
- java.util.function package
- Use whenever conditional checks are required.

### Predicate<I> ###
```
public interface java.util.function.Predicate<T> {
  public abstract boolean test(T);
  public default java.util.function.Predicate<T> and(java.util.function.Predicate<? super T>);
  public default java.util.function.Predicate<T> negate();
  public default java.util.function.Predicate<T> or(java.util.function.Predicate<? super T>);
  public static <T> java.util.function.Predicate<T> isEqual(java.lang.Object);
  public static <T> java.util.function.Predicate<T> not(java.util.function.Predicate<? super T>);
}
```

- Simple example
```
import java.util.function.*;

class PredicateDemo {
    public static void main(String[] args) {
        
        Predicate<String> p=s->s.length()>5;
        System.out.println(p.test("amol"));
        System.out.println(p.test("Anjali"));
        System.out.println(p.test("kajal"));
    }
}
```

- Create the list of employees and return the names of employees whose salary is greater then 40000

```
import java.util.function.*;
import java.util.*;

class Employee{
    
    String name;
    int salary;
    
    public Employee(String name, int salary){
        this.name=name;
        this.salary=salary;
    }
}
public class PredicateDemo {
    public static void main(String[] args) {
        
       ArrayList<Employee> l=new ArrayList<>();
       
       l.add(new Employee("A", 30000));
       l.add(new Employee("B", 10000));
       l.add(new Employee("C", 60000));
       l.add(new Employee("D", 70000));
       l.add(new Employee("E", 90000));
       
       Predicate<Employee> p=e->e.salary>40000;
       for(Employee emp: l){
           if(p.test(emp)){
               System.out.println(emp.name);
           }
       }
       
    }
}
```



### Predicate Joining ###

- p1-> return the number which are even
- p2-> return the number which are greater than 10
- return the number which is even and greater than 10 -> p1.and(p2)
- return the number which is even or greater than 10 -> p1.or(p2)
- return the number which is not even(add number)-> p1.negate()
  

```
import java.util.function.*;

class PredicateMoreutilities {
    public static void main(String[] args) {
        
        int[] nums={1,2,4,6,7,11,16,19};
        Predicate<Integer> p1=n->n%2==0;
        Predicate<Integer> p2=n->n>10;
        
        System.out.println("numbers which are even and greater than 10");
        for(int num: nums){
            if(p1.and(p2).test(num)){
                System.out.println(num);
            }
        }
        System.out.println("numbers which are even or greater than 10");
        for(int num: nums){
            if(p1.or(p2).test(num)){
                System.out.println(num);
            }
        }
        
        System.out.println("numbers which are not even(odd)");
        for(int num: nums){
            if(p1.negate().test(num)){
                System.out.println(num);
            }
        }
    }
}
```


## Function ##
- Perform some operation and produce result.

```
public interface java.util.function.Function<T, R> {
  public abstract R apply(T);
  public default <V> java.util.function.Function<V, R> compose(java.util.function.Function<? super V, ? extends T>);
  public default <V> java.util.function.Function<T, V> andThen(java.util.function.Function<? super R, ? extends V>);
  public static <T> java.util.function.Function<T, T> identity();
}
```
- Example:
```
import java.util.function.*;


class FunctionDemo1 {
    public static void main(String[] args) {
        Function<Integer,Integer> f=i->i*i;
        
        System.out.println("square is: "+f.apply(3));
        
        Function<String, Integer> f1=s->s.length();
        System.out.println(f1.apply("amol"));
        
        Function<String, String> upperCase=s->s.toUpperCase();
           System.out.println(upperCase.apply("amol"));
    }
}
```

- Example2:
```
import java.util.function.*;

class Student{
    
    String name;
    int marks;
    
    public Student(String name, int marks){
        this.name=name;
        this.marks=marks;
    }
}
public class FunctionDemo2 {
    public static void main(String[] args) {
        
        
        Student[] students = { 
            new Student("amol", 70),
           new Student("sagar", 66),
           new Student("joe", 54),
           new Student("dan", 34),
        };
        
        Function<Student,String> f=s-> {
            int mark = s.marks;
            String grade="";
            
            if(mark>=65) grade="A Grade";
            else if(mark>=50) grade="B Grade";
            else if(mark>=35) grade="C Grade";
            else grade="Fail";
            return grade;
        };
        //student data along with grades
        for(Student std: students){
            System.out.println("student name: "+std.name);
            System.out.println("student marks: "+std.marks);
            System.out.println("student grade: "+f.apply(std));
            System.out.println();
        }
        
        Predicate<Student> p=s->s.marks>60;
        
        System.out.println("student who are having marks greater than 60");
        for(Student std: students){
            if(p.test(std)){
                System.out.println("student name: "+std.name);
            System.out.println("student marks: "+std.marks);
            System.out.println("student grade: "+f.apply(std));
            System.out.println();
            }
        }
    }
}
```

### Function chaining ###

- f1.andThen(f2).apply(i);
first f1 followed by f2
- f1.compose(f2).apply(i);
first f2 then followed by f1

```
import java.util.function.*;

public class FunctionDemo2 {
    public static void main(String[] args) {
        
        Function<Integer, Integer> f1=i->2*i;
        Function<Integer, Integer> f2=i->i*i;
        
        System.out.println(f1.andThen(f2).apply(2));//2*2=4, 4*4=16
        System.out.println(f1.compose(f2).apply(2));//2*2,2*4=8

    }
}
```


## Consumer ##
- Consumer won't return anything it just accept the data and consume it.
- Consumer interface -
```
public interface java.util.function.Consumer<T> {
  public abstract void accept(T);
  public default java.util.function.Consumer<T> andThen(java.util.function.Consumer<? super T>);
}
```

- example1:
```
public class FunctionDemo2 {
    public static void main(String[] args) {
        
        Consumer<String> c=s->System.out.println(s);
        c.accept("amol");
        c.accept("kajal");
    }
}
```

- example2: 


```
import java.util.function.*;

class Student{
    
    String name;
    int marks;
    
    public Student(String name, int marks){
        this.name=name;
        this.marks=marks;
    }
}
public class FunctionDemo2 {
    public static void main(String[] args) {
        
        
        Student[] students = { 
            new Student("amol", 70),
           new Student("sagar", 66),
           new Student("joe", 54),
           new Student("dan", 34),
        };
        
        Function<Student,String> f=s-> {
            int mark = s.marks;
            String grade="";
            
            if(mark>=65) grade="A Grade";
            else if(mark>=50) grade="B Grade";
            else if(mark>=35) grade="C Grade";
            else grade="Fail";
            return grade;
        };
        
        Consumer<Student> c=std->{
            System.out.println("student name: "+std.name);
            System.out.println("student marks: "+std.marks);
            System.out.println("student grade: "+f.apply(std));
            System.out.println();
        };
        //student data along with grades
        for(Student std: students){
          c.accept(std);
        }
        
        Predicate<Student> p=s->s.marks>60;
        
        System.out.println("student who are having marks greater than 60");
        for(Student std: students){
            if(p.test(std)){
                c.accept(std);
            }
        }
        
    }
}
```

### Consumer chaining ###

```
import java.util.function.*;

class MyActivities{
    
    String name;
    public MyActivities(String name){
        this.name=name;
    }
}

public class ConsumerChaining {
    public static void main(String[] args) {
        
        Consumer<MyActivities> c1=a->System.out.println(a.name+ " woke up early");
         
         Consumer<MyActivities> c2=a-> System.out.println(a.name+ " went for walking..");    
         
         Consumer<MyActivities> c3=a-> System.out.println(a.name+ "'s memories storing in db.."); 
         
         Consumer<MyActivities> cc=c1.andThen(c2).andThen(c3);
         
         MyActivities activator=new MyActivities("Amol");
         cc.accept(activator);
    }
    
}
```


## Supplier ##

- it won't take any inpur
- It only supplies my required object.

```
public interface java.util.function.Supplier<T> {
  public abstract T get();
}
```

- example:
```
import java.util.function.*;
import java.util.Date;


class SupplierDemo {
    public static void main(String[] args) {
        Supplier<Date> s=()-> new Date();
        System.out.println(s.get());
    }
}
```

- Supplier to get the 6 digit otp
```
import java.util.function.*;
import java.util.*;


class SupplierDemo {
    public static void main(String[] args) {
        Supplier<String> s=()-> {
            String otp="";
            for(int i=1;i<=6;i++){
               otp+=(int)(Math.random()*10);
            }
            return otp;
        };
        System.out.println(s.get());
       
    }
}
```

Summary
- Predicate ---> single argument--> test()   
- Function ----> single argument---> apply()
- Comsumer ----> single argument----> accept()
- Supplier ---> no argmument----> get()

## BiPredicate ##
- Two input arguments

```
public interface java.util.function.BiPredicate<T, U> {
  public abstract boolean test(T, U);
  public default java.util.function.BiPredicate<T, U> and(java.util.function.BiPredicate<? super T, ? super U>);
  public default java.util.function.BiPredicate<T, U> negate();
  public default java.util.function.BiPredicate<T, U> or(java.util.function.BiPredicate<? super T, ? super U>);
}
```

```
import java.util.function.*;


class BiPredicateDemo {
    public static void main(String[] args) {
        BiPredicate<Integer, Integer> p=(a,b)->(a+b)%2==0;
        System.out.println(p.test(10,10));
    }
}
```
## BiFunction ##

## BiConsumer ##
- Create arraylist using the BiConsumer concept


## Premitive predicate types ##

- Normal Predicate type Integer object only, it converts int to Integer(autoboxing) and back to int (autounboxing) while evaluating expressions.
- This impacts the performance, hence type based Predicates are available those we can use.

- IntPredicate
- LongPredicate
- DoublePredicate

## Premitive Function Types ##
-----------------------------------------------------------------
- single argument which type fixed input and return any type
- DoubleFunction: can take input type as double and return any type
- IntFunction: can take input type as int and return any type
- LongFunction: can take input type as long and return any type


--------------------------------------------
- Single argument function which is having fixed input and fixed return type
- DoubleToIntFunction:
  input: Double
  return: int
applyAsInt(double value)
- DoubleToLongFunction
  input: double
return: long
func: applyAsLong(double value)
- IntToDoubleFunction: applyAsDouble(int value)
- IntToLongFunction: applyAsLong(int value)

--------------------------------------------
- Single argument fixed return type
- ToIntFunction: return type is int input anything
        applyAsInt(T u)
- ToLongFunction
- ToDoubleFunction
- ToLongFunction

-------------------------------------------------
- two argument and fixed return type
- ToIntBiFunction: return type must be int and input arguments can be of any type
     applyAsInt(T t, U u)

- ToDoubleBiFunction:  applyAsDouble(T t, U u)
- ToLongBiFunction:  applyAsLong(T t, U u)

 
## Premitive types of Consumer ##

- IntConsumer: void accept(int value)
- LongConsumer
- DoubleConsumer
- ObjDoubleConsumer<T>: void accept(T t, Double d)
- ObjLongConsumer
- ObjIntConsumer

## Premitive types of Supplier ##
- BooleanSupplier: boolean getAsBoolean()
- IntSupplier: int getAsLong()
- DoubleDuppier: double getAsDouble()
- LongSupplier: long getAsLong()


## UnaryOperator ##
- If input and return is of same type then use this
- child of Function interface

```
import java.util.function.*;

class UnaryDemo {
    public static void main(String[] args) {
        UnaryOperator<Integer> f=n->n*n;
        System.out.println(f.apply(12));
    }
}
```
### Premitive types of UnaryOperator ###
- IntUnaryOperator: return type is int function is: applyAsInt(int value)
```
import java.util.function.*;

class UnaryDemo {
    public static void main(String[] args) {
        IntUnaryOperator f=n->n*n;
        System.out.println(f.applyAsInt(7));
    }
}
```
- DoubleUnaryOperator: applyAsDouble
- LongUnaryOperator: applyAsDouble


## BinaryOperator ##
- child of **BiFunction interface**.
- BinaryOperator<T, T, T> all are same type
- example
```
import java.util.function.*;

class BinaryOperatorDemo {
    public static void main(String[] args) {
        BinaryOperator<Integer> f=(n1,n2)->n1+n2;
        System.out.println(f.apply(7,3));
    }
}
```

### Premitive types of BinaryOperator ###
- IntBinaryOperator 
```
import java.util.function.*;

class BinaryOperatorDemo {
    public static void main(String[] args) {
        IntBinaryOperator f=(n1,n2)->n1+n2;
        System.out.println(f.applyAsInt(7,3));
    }
}
```
- DoubleBinaryOperator: double applyAsDouble(double a, double b)
- LongBinaryOperator

-----------------------------------------------------------------------------------------
## Method and Construtor Reference ##
- FunctionalInterface abstract method refers to the existing method for code reusability.
- method referance is a alternative to the lambda expression.
- main rule is: in method reference the argument and argument type of methods should match, different modifiers/return types allowed.
- if the implementation is already available better to go for method reference otherwise use lambda expression.
example:
```
//acceptable
public void run();
public void m1(){}

//acceptable
public void run();
private void m1(){}

//acceptable
public void run();
public int m1(){}

//invalid
public void run();
public void m1(int a){}
```
- for static method: className::methodName
- for instance method: objectReference::methodName


### Case 1 using method reference for static method ###

```
class Case1 {

   public static void test(){
        for(int i=0;i<6;i++){
              System.out.println("child thread.."+i);
          } 
    }
    public static void main(String[] args) {
        Runnable r=()->{
          for(int i=0;i<6;i++){
              System.out.println("child thread.."+i);
          }  
        };
        
        Thread t=new Thread(r);
        t.start();
    }
}
```
- Refer to above implementation run method(lambda expression) to the existing test method
```
class Case1 {
    
    public static void test(){
        for(int i=0;i<6;i++){
              System.out.println("child thread.."+i);
          } 
    }
    public static void main(String[] args) {
        Runnable r=Case1::test;
        
        Thread t=new Thread(r);
        t.start();
    }
}
```
### Case 2 using method reference for instance method ###
```
class Case2 {
    
    public void test(){
        for(int i=0;i<6;i++){
              System.out.println("child thread.."+i);
          } 
    }
    public static void main(String[] args) {
        Case2 c=new Case2();
        
        Runnable r=c::test;
        
        Thread t=new Thread(r);
        t.start();
    }
}
```
### Case3 using different return type for implementated method ###
```
class Case3 {
    
    public static int test(){
        for(int i=0;i<6;i++){
              System.out.println("child thread.."+i);
          } 
          return 0;
    }
    public static void main(String[] args) {
        
        
        Runnable r=Case3::test;
        
        Thread t=new Thread(r);
        t.start();
    }
}
```
### Case4 using different method argument implementated method ###
```


class Case4 {
    
    public static void test(int a){
        for(int i=0;i<6;i++){
              System.out.println("child thread.."+i);
          } 
    }
    public static void main(String[] args) {
        
        
        Runnable r=Case4::test;
        
        Thread t=new Thread(r);
        t.start();
    }
}

error:
Runnable r=Case3::test;
                   ^
    method test in class Case3 cannot be applied to given types
      required: int
      found: no arguments
      reason: actual and formal argument lists differ in length
```

- Example:
```


interface Interf{
    public void add(int a, int b);
}
public class Example {
    
    public static void test(int x, int y){
        System.out.println("sum is: "+(x+y));
    }
    public static void main(String[] args) {
        
        Interf i = Example::test;
        i.add(40,30);
    }
}
```


## Constructor reference ##
- Test::new => constructor reference
- If the functional interface method return the object then we should go for constructor reference.

```
interface Interf{
    public Student getObject();
}

class Student{
    public Student(){
        System.out.println("Student class object instantiated..");
    }
}
public class ConstructorRefDemo {
    public static void main(String[] args) {
        Interf i=Student::new;
        Student s1=i.getObject();
        Student s2=i.getObject();
    }
}
```
- Constructor reference Student::new refers to the FunctionalInterface getObject method.

- Constructor reference with argument
```
interface Interf{
    public Student getObject(String name);
}

class Student{
    public Student(String name){
        System.out.println("Student class object instantiated for student: "+name);
    }
}
public class ConstructorRefDemo {
    public static void main(String[] args) {
        Interf i=Student::new;
        Student s1=i.getObject("Amol");
        Student s2=i.getObject("Kajal");
    }
}
```

## Streams API ##

- If we want to process objects from collection then we should go for streams.
- Stream s=c.stream()
- present in java.util.stream package 

### Example1: create the list of even elements ###
```
import java.util.*;
import java.util.stream.*;

class StreamDemo {
    public static void main(String[] args) {
        ArrayList<Integer> l=new ArrayList<>();
        l.add(9);
        l.add(3);
        l.add(8);
        l.add(7);
        l.add(12);
        l.add(10);
        
        
        System.out.println(l);
        List<Integer> ans= l.stream().filter(e->e%2==0).collect(Collectors.toList());
        
        System.out.println(ans);
    }
}
```
--------------------------------------------------------------------------
### Example1: add 10 marks in final score ###

```
import java.util.*;
import java.util.stream.*;

class Student{
    String name;
    int marks;
    
    public Student(String name, int marks){
        this.name=name;
        this.marks=marks;
    }
    
    public String toString(){
        return name+" : "+marks;
    }
}
public class StreamMapDemo {
    public static void main(String[] args) {
        ArrayList<Student> list=new ArrayList<>();
        list.add(new Student("A", 68));
        list.add(new Student("D", 66));
        list.add(new Student("E", 90));
        list.add(new Student("B", 78));
        list.add(new Student("E", 47));
        System.out.println(list);
        
       List<Student> finalList = list.stream().map(s->(new Student(s.name,s.marks+5))).collect(Collectors.toList());
        
        System.out.println(finalList);
    }
}
```

- filter(Predicate)
- map(Function) 
- collect
- count
- sorted
- sorted(Comparator)
- min(Comparator)
- max(Comparator)
- forEach()
- toArray()
- Stream.of(..)
  









