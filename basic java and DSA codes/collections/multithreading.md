
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




   








