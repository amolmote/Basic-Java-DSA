
# Multithreading # 


## Multitasking ##

Executing sevaral tasks simultaneously know as multitasking is the concept of Multitasking. there are two types of multitasking:
1. Process Based Multitasking.
2. Thread Based Multitasking.

### Process Based Multitasking ###

Executing several tasks simultaneously where each tasks is a seperate *independent program(Process)*, is called process based multitasking.


**Examples:** 
1. task manager showing all the processes that are running in the background, all these processes are nothing but the example of the multitasking.
and all these processes are independent.
2. process based multitasking is best suitable at OS level.


### Thread Based Multitasking ##

1. Executing several tasks simultaneously where each task is a seperate independent part part of the same program, is called thread based multitasking, and each independent part is called a *Thread*.
2. Thread based multitasking is best suitable at programatic level.

Whether it is process based or thread based the main objective of multitasking is to reduce responce time of the system & to improve performance.

### What is Thread? ###

Thread is nothing but the flow of execution.



### Defining a Thead ###
We can define a thread using following two ways:
1. By extending Thread class.
2. By implementing Runnable interface.

example of thread created using thread class:
```

//Defining Thread
class MyThread extends Thread{
    
    public void run(){
        /*Job of thread, executed by child thread..*/
        for(int i=1;i<6;i++){
            System.out.println("child thread: "+i);
        }
    }
}
public class ThreadDemo {
    /*main thread*/
    public static void main(String[] args) {
        /*Instantiation of child thread*/
        MyThread t = new MyThread();
        /*Starting of child thread..*/
        t.start();
        /*job executed by main thread*/
        for(int i=1;i<6;i++){
            System.out.println("main thread: "+i);
        }
    }
}
```

**Case 1: Thread Scheduler**

1. It is the part of JVM
2. It is responsible to schedule thread, because if multiple threads are waiting to get chance of execution, then in which order threads will be executed is decided by thread scheduler.
3. We can't expect exact algorithm followed by scheduler, it is varies from JVM to JVM, hence we can't expect the order of thread execution.
4. Hence whenever situation comes in multithreading there is no guarrenty of exact output, but we can provide several possible outputs.

The following are possible outputs for the above program.
1. main thread followed by child thread.
2. child thread followed by main thread.
3. mixed output of main & child thread.


**Case 2: Difference between t.start() & t.run()**

t.start()  | t.run()
------------- | -------------
In this case, a new thread will be created which is responsible for the execution of run() | In this case, a new thread won't be created & the run() method will be executed just like a normal method call by *main thread*

**Case 3: Importance of Thread class start()**
1. Thread class start() is responsible for to register the thread with thread scheduler & all other mandatory activities.
2. hence, without executing Thread class start method, there is no chance of executing new thread in java.
3. due to this Thread class start() is considered as heart of multithreading.

```
start(){

//1. Register the thread.
//2. Perform all other mandatory activities.
//3. Invoke run()
}
```

**Case 4: overloading of run()**

1. overloading of run() is always possible, but Thread class start() can invoke *no-args run()*.
2. The other overloaded run() method we have to call explicitly like a normal method call.

demo code:
```

class MyThread extends Thread{
    public void run(){
        System.out.println("no arg method");
    }
    public void run(int a){
        System.out.println("overloaded method "+a);
    }
}
public class OverloadingOfRun {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
        t.run(10);
    }
}
```
Output:
```
no arg method
overloaded method 10
```

**case 5: not overriding run()**

1. If we are not overriding run() then the Thread class run() will be executed which has empty implementation.
2. Hence we will not get any output.


```
class MyThread extends Thread{
   
}
public class NoOverridingOfRun {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
```
**Note**: It is highly recommonded to override run() otherwise don't go for multithreading concept.

**Case 6: overriding of start()**
1. If we override the start() then our start() will be executed, just like a normal method call.
2. new thread won't be created.

Demo code:

```

class MyThread extends Thread{
   public void start(){
       System.out.println("start method called..");
   }
   public void run(){
       System.out.println("run method called..");
   }
}
public class StartMethodInClass {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
        
        System.out.println("main thread finished...");
    }
}
```
output:
```
start method called..
main thread finished...
```


Note: It is not recommonded to override the start() otherwise don't go for multithreading concept.

**Case 7**
Demo2: for above just one change calling super.start()
run code and check different results.
```
class StartMethodDemo2 extends Thread {
    
    public void start(){
        super.start();
        System.out.println("start method..");
    }
    
    public void run(){
        System.out.println("run method");
    }
    public static void main(String[] args) {
        StartMethodDemo2 t = new StartMethodDemo2();
        t.start();
        System.out.println("main method...");
    }
}
```

### Thread Lifecycle ###


![image](https://github.com/user-attachments/assets/534f71c5-afd1-44eb-9a86-fd0f25593158)



**case 8 - IllegalThreadStateException**
After starting a thread if we are trying to restart the same thread then we will get this RuntimeException.

```
 MyThread t = new MyThread();
        t.start();
        t.start(); //RE:IllegalThreadStateException
```



### Defining a Thread Using Runnable interface ###

We can define a thread by implementing Runnable interface. 
1. Runnable interface present in java.lang package.
2. It contains only one method: run()

![image](https://github.com/user-attachments/assets/65b1b256-8978-4901-8c5d-0c43bbe167e2)


```

class RunnableDemo implements Runnable  {
    //Defining Thread
    public void run(){
        System.out.println("child thread...");//child thread job
    }
    
    public static void main(String[] args) {
     RunnableDemo r = new RunnableDemo();
     Thread t = new Thread(r);//target thread-r
     t.start();
     System.out.println("main thread...");
    }
}
```


**case study**

```
MyRunnable r = new MyRunnable();
Thread t1=new Thread();
Thread t2=new Thread(r);
```
**case 1: t1.start()**
1. A new thread will be created and which is responsible for the execution of thread class run(), which has empty implementation 

**case 2: t1.run()**
No New thread will be created and Thread class run() will be executed just like a normal method call.

**case 3: t2.start()**
A new thread will be created which is responsible for the execution of MyRunnable run().

**case 4: t2.run()**
A new thread won't be created and MyRunnable run() will be executed just like a normal method call.

**case 5: r.start()**
We will get compile time error saying *MyRunnable class doesn't have start capability*. "can not find symbol symbol: method start

**case 6: r.run()**
No new thread won't be created and MyRunnable run() will be executed just like normal method calls.



### Which approach is best to define Thread ###
1. Among two ways of defining a Thread, implements Runnable appoach is recommonded.
2. In first approach our class Always extends Thread class, there is no chance of extending any other class hence we are missing inheretance benefit.
3. But in second approach, while implement Runnable interface we can extend any other class, hence we won't miss inheretance benefits.

Due to above reason creating thread using Runnable interface is recommonded.


### Thread class conructors ###

1. Thread t = new Thread();
2. Thread t = new Thread(Runnable r);
3. Thread t = new Thread(String name);
4. Thread t = new Thread(Runnable r, String name);
5. Thread t = new Thread(ThreadGroup tg, String name);
6. Thread t = new Thread(ThreadGroup tg, Runnable r);
7. Thread t = new Thread(ThreadGroup tg, Runnable r, String name);
8. Thread t = new Thread(ThreadGroup tg, Runnable r, String name, long stackSize);

### 3rd way of defining Thread but not recommonded to use ###

```

class MyThread extends Thread{
    public void run(){
        System.out.println("child thread..");
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        Thread t1 = new Thread(t);//MyThread extends Thread, Thread implements Runnable
        t1.start();
        System.out.println("main thread...");
    }
}
```


### Getting & Setting Name of Thread ###
Every thread in java has some name, it may be default name generated by JVM or customized name provided by programmer.

We can get and set name of a Thread by using the following two methods of Thread class.
```
public final String getName()

public final void setName(String name);
```
Example:
```
class MyThread extends Thread{
   
}

public class ThreadDemo {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());//main
        MyThread t = new MyThread();
        System.out.println(t.getName());//Thread-0
        Thread.currentThread().setName("amol");
        System.out.println(Thread.currentThread().getName());//amol
    }
}
```

### Thread Priority ###
Every thread in java has some priority, it may be default priority generated by JVM or customized priority provided by programmer.The valid range of thread priority is 1 to 10, where 1 is MIN_PRIORITY & 10 is MAX_PRIORITY. Thread class defines the following constants to represents some standard priorities.


Thread.MIN_PRIORITY = 1
Thread.MAX_PRIORITY = 10
Thread.NORM_PRIORITY = 5


Thread scheduler will use priorities while allocating processor. The Thread which is having highest priority will get chance first.

If two threads having same priority then we can't expect exact execution order. It depends on Thread Scheduler.


Thread class defined following methods to get and set Thread Priority.
```
public final int getPriority()

public final void setPriority(int p)  allowed values are in between 1-10, if we provide any other value then we will get RE: IllegalArgumentException
```

The default priority only for the main thread is **5**, but for all other thread default priority will be inhereted by parent thread. so whatever priority parent thread has the same priority will be there for child thread.


main Thread Priority
```
class MainThreadPriority{
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());//5
    }
}
```

Setting Priority Of Threads
```
class ThreadPriorityDemo extends Thread {
    
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        ThreadPriorityDemo t1 = new ThreadPriorityDemo();
        t1.setPriority(1);
        t1.setName("T1..");
        t1.start();
        
        ThreadPriorityDemo t2 = new ThreadPriorityDemo();
        t2.setPriority(10);
        t2.setName("T2..");
        t2.start();
    }
}
```
Setting Priority Outside the defined range demo:
```
class MainThreadPriority{
    public static void main(String[] args) {
        Thread.currentThread().setPriority(11);//java.lang.IllegalArgumentException
    }
}
```

Parent thread priority inherited by child thread:

```
class ParentPriorityInheritance extends Thread{
    
    public void run(){
        System.out.println("hello");
    }
    public static void main(String[] args) {
        Thread.currentThread().setPriority(7);
       ParentPriorityInheritance t = new ParentPriorityInheritance();
       t.start();
       System.out.println(t.getPriority());//7
    }
}
```
Main thread followed by child thread due to thread priority
```

class MainChildDemo extends Thread{
    
    public void run(){
      for(int i=1;i<=4;i++){
          System.out.println("child thread...");
      }
    }
    public static void main(String[] args) {
       MainChildDemo t = new MainChildDemo();
       t.setPriority(10);
       t.start();
       
       for(int i=1;i<=4;i++){
          System.out.println("main thread...");
      }
    }
}
```

**Note**: Some platforms won't provide proper support for thread priorities.


### Thread Prevention Methods ###
We can prevent a thread execution by using the following methods:
1. yield()
2. join()
3. sleep()

### yield()  ###
1. Yield method causes to pause current executing thread to give the chance for waiting thread of same priority.
2. If there is no waiting thread or all waiting threads have low priority then, same thread can continue its execution.
3. If multiple threads are waiting with the same priority then which waiting thread will get the chance, we can't expect it depends on thread scheduler.
4. the thread which is yielded, when it will get the chance again it depends on thread scheduler and we can't expect exactly.

```
public static native void yield()
```

...
```
class YieldDemo extends Thread {
    
    public void run(){
        for(int i=0;i<4;i++){
           System.out.println("child thread..");
           Thread.yield(); // ...1
       }
    }
    public static void main(String[] args) {
       YieldDemo t1 = new YieldDemo();
        
       t1.start();
       
       for(int i=0;i<4;i++){
           System.out.println("main thread..");
       }
    }
}
```
In the above program, if we are commenting line 1 then both the threads will be executed simultaneously and we can't except which thread will complete first. If we are not commenting line 1 then child thread will always call yield() then main thread will get chance more number of times and the chance of completing main thread first is high.



Some platforms won't provide proper support for yield method.


### join() ###

If a thread wants to wait until completing some other thread then we should go for go join method.

for eg. if t1 wants to wait until completing of t2 then  t1 has to call t2.join().


If t1 execute t2.join() then immediately t1 will be entered into waiting state until t2 completes. once t2 completes then t1 can continue its execution.



venu fixing thread(t1)    wedding card printing(t2)   wedding card distribution(t3)
                                t1.join()                       t2.join()

  t1 executes first then t2 and at last t3.

```
public final void join() throws InterruptedException
public final void join(long ms) throws InterruptedException
public final void join(long ms, int ns) throws InterruptedException
```

**Note** Every join method throws InterruptedException which is checked exception hence, compulsory we should handle this exception either by using try-catch or by throws keyword. otherwise we will get compile time error.



![image](https://github.com/user-attachments/assets/e4a57bee-ad9d-4ca9-af8f-244230d64432)


If thread scheduler allocates processor then only the thread will enter into running state.


### case 1: Waiting of Main Thread until completion of Child Thread ###
```

class JoinDemo extends Thread {
    
    public void run() {
        for(int i=0;i<6;i++){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            
            System.out.println(Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) throws InterruptedException{
        JoinDemo t = new JoinDemo();
        t.start();
        //t.join();//main will wait until t thread
        t.join(2000);//main will wait till 2 sec
        for(int i=0;i<6;i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
```


### case 2: wating of Child Method until main thread completes ###

```
class MyThread extends Thread{
    static Thread mainThread;
    
    public void run(){
        try{
            mainThread.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        for(int i =0;i<10;i++){
            System.out.println("child thread...");
        }
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException{
       MyThread.mainThread = Thread.currentThread();
       MyThread t = new MyThread();
       t.start();
       
       for(int i=0;i<10;i++){
           System.out.println("main thread...");
           Thread.sleep(1000);
       }
    }
}
```

In above example child thread calls join method on main thread thread object hence child thread has to wait until main thread completetion. 


### case 3: Both Child Thread and Main Thread calling join() ###
```


class MyThread extends Thread{
    static Thread mainThread;
    
    public void run(){
        try{
            mainThread.join();//child thread waiting for main thread completion
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        for(int i =0;i<10;i++){
            System.out.println("child thread...");
        }
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException{
       MyThread.mainThread = Thread.currentThread();
       MyThread t = new MyThread();
       t.start();
       t.join();//main thread  waiting for child thread completion
       
       for(int i=0;i<10;i++){
           System.out.println("main thread...");
           Thread.sleep(1000);
       }
    }
}
```

If main thread calling join() on the child thread object, and child thread calls join() on main thread object then, both the threads will wait forever, and the program be stucked( this is something like **DeadLock**)


### Case 4 ###

If a thread calls join() on the same thread itself then the program will be stucked(deadlock). In this case thread has to wait infite amount of time.

```
class Main {
    public static void main(String[] args) throws InterruptedException{
      Thread.currentThread().join();
    }
}
```

### sleep() ###
If a thread don't want to perform any activity for a particular amount of time then we should go for sleep().

sleep() stops the execution of thread for a mentioned time.

```
public static native void sleep(long ms) throws InterruptedException
public static void sleep(long ms, int ns) throws InterruptedException
```

Every sleep method throws InterruptedException, which is checked exception.  hence, whenwhere we are using sleep method compulsory we should handle InterruptedException either by try catch or by throws keyword otherwise, we will get compile time error.


![image](https://github.com/user-attachments/assets/3348c91a-5278-4e7b-9bb0-c295f4ee7241)


```
class SleepDemo {
    public static void main(String[] args) throws InterruptedException{
      for(int i=1;i<6;i++){
          System.out.println("ppt-slide-"+i);
          Thread.sleep(2000);
      }
    }
}
```


## How a Thread can Interrupt another thread ##

A thread can interrupt a sleeping thread or waiting thread by using interrupt() of Thread class.

```
public void interrupt()
```

Demo code of interrupt()
```
class InterruptThreadDemo extends Thread {
    
    public void run(){
        try{
            for(int i=1;i<6;i++){
              System.out.println("sleeping thread...");
               Thread.sleep(2000);
         }
        }catch(InterruptedException  e){
            System.out.println(" thread got interrupted.."+e);
        }
    }
    public static void main(String[] args) throws InterruptedException{
      InterruptThreadDemo t = new InterruptThreadDemo();
      t.start();
      t.interrupt();....1
      System.out.println("main completed...");
    }
}
```

if we comment line 1 then main thread won't interrupt child thread in this case child thread will execute for loop. 


If we are not commenting line 1 then main thread interrupt child thread in this case output is:
```
main completed...
sleeping thread...
 thread got interrupted..java.lang.InterruptedException: sleep interrupted

```

### Note ###
Whenever we are calling interrupt method if the target thread not in sleeping/waiting state then there is no impact of interrupt call immediately, Interrupt call will be wait for target thread to go in waiting state. if the target thread entered into waiting state then immediately interrupt call will interrupt the target thread.




If the target thread never entered into waiting/sleeping state in its lifetime then there is no impact of interrupt call this is only case where Interrupt call will be wasted.



```
class InterruptThreadDemo2 extends Thread {
    
    public void run(){
        for(int i=1;i<6;i++){
              System.out.println("sleeping thread..."+i);
         }
        try{
            Thread.sleep(2000);
        }catch(InterruptedException  e){
            System.out.println(" thread got interrupted.."+e);
        }
    }
    public static void main(String[] args) {
      InterruptThreadDemo2 t = new InterruptThreadDemo2();
      t.start();
      t.interrupt();
      System.out.println("main completed...");
    }
}
```


### Comparison of yield(), join() and sleep() ###

Property     | yield()   |  join()  | sleep()  |
------------- | ---------|----------|----------|
Purpose  | If a thread want to pause its execution to give the chance for remaining threads of same priority | If a thread wants to wait until completing some other thread then join() | If a thread don't want to perform any operation for a particular amount of time then we should go for sleep()  |
is it overloaded? | no | yes | yes |
is it final? | no | yes | no |
is it throws InterruptedException? | no | yes | yes |
is it native? | yes | no | sleep(long ms) -> native, sleep(long ms, int ns)-> java | 
is it static? | yes | no | yes |



## Thread Synchronization ##
   
1. synchronized is the modifier applicable only for methods and blocks but not for classes and variables.
2. If multiple threads are trying to operate on the same java object then there may be a chance of data inconsistency problem.
3. To overcome this problem we should go for synchronzed keyword.
4. If a method or block declared as a synchronized, then at a time only one thread is allowed to execute that method or block on the given object, so that data inconsistency problem will be resolved.
5. The main advantage of synchronized keyword is we can resolve data inconsistency problems but the main disadvantage of synchronzed keyword is, it increases waiting time of threads and creates performance problems, hence if there is no specific required then it is not recommonded to use synchronized keyword.
6. Internally synchronization concept is implemented by using lock. Every object in java has a unique lock. Wheneever we are using synchronized keyword then only lock concept will come into the picture.
7. If a thread wants to execute synchronized method on the given object first it has to get lock of that object. Once thread got the lock then it is allowed to execute any synchronized on that object. Once method execution completes automatically thread releases the lock. aquiring and releasing lock internally takes care by JVM and programmer not responsible for this activity.
8. While a thread executing synchronized method on the given object the remaining threads are not allowed to execute any synchronzed method simultaneously on the same object, remaining threads are allowed to execute non synchronized methods simultaneously.
9. Lock concept is implemented based on *object* but not based on method.



![image](https://github.com/user-attachments/assets/aea47b7a-10d5-4080-9c0f-826856579ac7)



### Areas of Object in java ###

![image](https://github.com/user-attachments/assets/fff28736-c586-45aa-ac78-d34955de13b6)



Synchronized area:
The area in which we perform update operation, i.e. where the state of object changing.



Non-synchronzed area:
The area in which we perform read operations only i.e where state of object won't be changing.



example code structure:

```
class MovieSeatBooking{

        seatAvailability(){
            // non synchronized method - read operation only
         }

         synchronized void bookTicket(){
           // update operation
         }

}

```
### Object level lock example ###
```

class Display{
    
    public synchronized void greet(String name){
       
        for(int i=0;i<6;i++){
            System.out.print("hello: ");
            try{
             Thread.sleep(2000);    
           }catch(InterruptedException e){
            System.out.println(e);
          }
           System.out.println(name);
        }
    }
}

public class MyThread extends Thread {
    Display d;
    String name;
    
    public MyThread(Display d, String name){
        this.d = d;
        this.name = name;
    }
    
    public void run(){
       d.greet(name);
    }
    public static void main(String[] args) {
        Display d= new Display();
        MyThread t1=new MyThread(d,"amol");
        MyThread t2=new MyThread(d,"ajay");
        t1.start();
        t2.start();
    }
}
```

### Case Study ###
```
Display d1 = new Display();
Display d2 = new Display();
MyThread t1= new MyThread(d1, "ajay");
MyThread t2 = nw MyThread(d2, "raj");

t1.start();
t2.start();
```
Even though the method is synchronized, in above case we will get irregular output. because threads are operating on different java objects.

demo code of this use case:

```

class Display{
    
    public synchronized void greet(String name){
       
        for(int i=0;i<6;i++){
            System.out.print("hello: ");
            try{
             Thread.sleep(2000);    
           }catch(InterruptedException e){
            System.out.println(e);
          }
           System.out.println(name);
        }
    }
}

public class MyThread extends Thread {
    Display d;
    String name;
    
    public MyThread(Display d, String name){
        this.d = d;
        this.name = name;
    }
    
    public void run(){
       d.greet(name);
    }
    public static void main(String[] args) {
        Display d1= new Display();
        Display d2= new Display();
        MyThread t1=new MyThread(d1,"amol");
        MyThread t2=new MyThread(d2,"ajay");
        t1.start();
        t2.start();
    }
}
```


### Conclusion ###
- If multiple threads are operating on same java object then synchronization is required.
- If multiple threads are operating on different java objects then synchronization is not required.


### Class Level Lock ###
- Every class in java has a unique lock, which is nothing but class level lock.
- If a thread wants to execute a static synchronized method then thread required class level lock. once thread got class level lock then it is allowed to execute any static synchronized method of that class.
- once method execetion completes, automatically thread releases the lock.

Demo code for class level lock:
```

class Display{
    
    public synchronized void greet(String name){
       
        for(int i=0;i<6;i++){
            System.out.print("hello: ");
            try{
             Thread.sleep(2000);    
           }catch(InterruptedException e){
            System.out.println(e);
          }
           System.out.println(name);
        }
    }
}

public class MyThread extends Thread {
    Display d;
    String name;
    
    public MyThread(Display d, String name){
        this.d = d;
        this.name = name;
    }
    
    public void run(){
       d.greet(name);
    }
    public static void main(String[] args) {
        Display d1= new Display();
        Display d2= new Display();
        MyThread t1=new MyThread(d1,"amol");
        MyThread t2=new MyThread(d2,"ajay");
        t1.start();
        t2.start();
    }
}
```

- While a thread executing static synchronized method, then the remaining threads are not allowed to execute any static synchronized of that class simultaneously.
- But remaining threads are allowed to execute the following methods simultaneously
1. Normal static methods.
2. synchronized instance methods.
3. normal instance methods.

   
## Synchronized block ##






   





 







