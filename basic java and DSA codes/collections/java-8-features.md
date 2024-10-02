### Lambda expresssion ###

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

### Lambda expression with Multithreading ###

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
















