
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
1.It is the part of JVM
2. It is responsible to schedule thread, because if multiple threads are waiting to get chance of execution, then in which order threads will be executed is decided by thread scheduler.
3. We can't expect exact algorithm followed by scheduler, it is varies from JVM to JVM, hence we can't expect the order of thread execution.
4. Hence whenever situation comes in multithreading there is no guarrenty of exact output, but we can provide several possible outputs.


   








