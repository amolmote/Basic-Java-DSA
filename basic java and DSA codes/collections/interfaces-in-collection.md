#### 9 key interfaces in collection ####
1. Collection
2. List
3. Set
4. SortedSet
5. NavigableSet
6. Queue
7. Map
8. SortedMap
9. NavigableMap

**Collection(I) - 1.2v**
- If we want to represent a group of individual objects as a single entity then we should go for **Collection**
- Collection interface defines the most common methods which are applicable for any collection object.
- In general, collection interface is considered as *root* interface of collection framework.
- there is no concret class which implements collection interface directly.


Collection  | Collections
------------- | -------------
Collection is a interface  |  Collections is an utility class present in java.util package.
if we want to represent a group of individual objects a single entity => **Collection**  | To define sevaral utility methods for collection objects.like sorting, searching etc.





  **List(I) - 1.2v**(Duplicates Allowed, Insertion order Preserved)

  - It is the child interface of Collection.
  - If we want to represent a group of individual objects as a single entity where duplicates are allowed and insertion order must be preserved then we hould go for List.
  - implemented classes ArrayList(1.2v), LinkedList(1.2v), vector(1.0-legacy), Stack(1.0v-legacy)
  - In 1.2v Vector and Stack classes are reimplemented to implement List interface.
 
  **Set(I) - 1.2v**
  - It is the child interface of Collection.
  - If we want to represent a group of individual objects as a single entity where duplicates are not allowed and the insertion order not required, then we should go for **Set**.
  - Implementation classes: HashSet(1.2v), LinkedHashSet(1.4v)
 
  **SortedSet(I) - 1.2v**
  - It is a child interface of Set.
  - If we want to represent a group of individual objects as a single entity where duplicates are not allowed and all objects should be inserted according to the sorting order then we should go for SortedSet.


  **NavigableSet(I)-1.6v**
  - It is the child interface of SortedSet
  - It contains several methods for navigation purposes.
  - Implementation class: TreeSet(1.2v)
  - Which provides several methods for navigation purposes.

 **Differances Between List & Set**
  List  | Set
------------- | -------------
Duplicates are allowed | Not allowed
Insertion order preserved | not maintained


**Queue(I) - 1.5v**
- Queue is the child interface of Collection.
- If we want to represent a group of individual objects prior to processing then, we should go for Queue.
- Usually, Queue follows First In First Out order, but based on our requirement we can implement our own priority order also.
- Example: Before sending a mail, all mail id's we have to store in some data structure. In which order we added mail id's in the same order only mail should be delivered for this requirement Queue is best choice.
- Implemetation classes: PriorityQueue
- BlockingQueue- this has two child classes:1) PriorityBlockingQueue 2) LinkedBlockingQueue
- All concepts came in 1.5v

  Note: All the above Interfaces( Collection, List, Set, SortedSet, NavigableSet, Queue) meant for representing a group of individual objects, If we want to represent a group of objects as key-value pairs then we should go Map.


  **Map(I) - 1.2v**
  - Map is *not* child interface of Collection.
  - If we want to represent a group of objects as key-value pair then we should go for Map.
  - both key and value are objects only.
  - Duplicate keys are not allowed but values can be duplicated.
  - Implementation classes: HashMap(1.2v), LinkedHashMap(1.4v), WeakHashMap(1.2v), IdentityHashMap(1.4v), Hashtable
  - Dictionary(AC)<---Hashtable(C)<----Properties(C)  <= All came in 1.0v(Legacy classes)
 
  **SortedMap(I)-1.2v**

  - It is the child interface of Map.
  - If we want to represent a group of key value pairs according to some *sorting order of keys* then we should go for SortedMap.
  - In SortedMap the sorting should be based on key but not based on value.
 
  **NavigableMap(I)- 1.6v**

  - it is the child interface of SortedMap
  - It defines sevaral methods for navigation purposes.
  - Implementation Class: TreeMap(1.2v)
 
 ![image](https://github.com/user-attachments/assets/ecc119fc-0f0b-4b97-9e7f-1da1b5ac0b7a)



![image](https://github.com/user-attachments/assets/8e841723-5c63-408f-a66e-08d8c3a28140)


**Collection(I)**
- If we want to represent a group of Individual objects as a single entity then we should go Collection.
- Collection interface defines the most common methods which are applicable for any collection object.
- methods which are present in Collection:
```
boolean add(Object o)
boolean addAll(Collection c)
boolean remove(Object o)
boolean removeAll(Collection c)
boolean retainAll(Collection c) - this is also one more removal method which removes everything except the Collection that we are passing in a function as an argument.
void clear(): clear/remove everything from Collection.
boolean contains(Object o)
boolean containsAll(Collection c)
boolean isEmpty()
int size()
Object[] toArray()
Iterator iterator()
```
*Note: there is no concret class which implemenents Collection interface directly.*

**List(I)**
- List is a child interface of Collection.
- if we want to represent a group of individual objects as a single entity where duplicates are allowed and insertion order must be preserved, then we should go for List.
- we can preserve insertion order via index and we can differentiate duplicate objects by using index. Hence index will play very important role in List.
- method which are present in List interface:
```
void add(int  index, Object o): add element at specified index, if that index already contain any element then it will shift to the next vacant space, and element will get added to the specified index.
```
example below:
```
     l.add(1,10)
```
output: 
```
[1, 2, 3]
[1, 10, 2, 3
```
```
want to add group of object starting from the specified index:
boolean addAll( int index, Collection c)


Object remove(int index)
Object get(int index)
Object set(int index, Object o)
int indexOf(Object o): return the first occurance index.
int lastIndexOf(Object o): return the last occurance index.
ListIterator listIterator()
```
**ArrayList(c)**
- The underlying data structure is resizable array or growable array.
- Duplicates are allowed.
- Insertion order is preserved.
- Heterogeneous objects are allowed.(Except TreeSet & TreeMap everywhere heterogeneous objects are allowed.)
- null insertion is possible.

  **Constructors:**
 1.  ArrayList list = new ArrayList();
  creates an empty ArrayLst, with default initial capacity 10, Once ArrayList reaches its max capacity then a new ArrayList object will be created with:
```
  newCapacity = (currentCapacity * 3/2)+1
```
2. ArrayList l= new ArrayList(int initialCapacity);
   Created an empty ArrayList object with specified initialCapacity.
3. ArrayList l= new ArrayList(Collection c);
   Creates an equivalent ArrayList object for the given Collection.

Example:
```
import java.util.*;
class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList l = new ArrayList();
        l.add("A");
        l.add(10);
        l.add("A");
        l.add(null);
        System.out.println(l);
        l.add(2,"M");
        l.add("N");
        System.out.println(l);
    }
}
```
Output: 
```
Note: /tmp/QaW0SMK88D/ArrayListDemo.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
java -cp /tmp/QaW0SMK88D/ArrayListDemo
[A, 10, A, null]
[A, 10, M, A, null, N]
```

Note: We are getting warning on console, because since java 1.5, it is highly recommonded to use Generic for type safety purpose.


- Usually, we can use Collection to hold and transfer objects from one location to another(Container). to provide support for this requirement every Collection class implements serializable and Clonable interfaces.
- ArrayList & Vector classes implements RandomAccess interface, so that any random element we can access with the same speed.

**RandomAccess(I):**
This interface present in java.util package and it doesn't contain method, it is a **MarkerInterface**, where required ability will be provided automatically by the **JVM**.

```
import java.util.*;
class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList l1 = new ArrayList();
        LinkedList l2= new LinkedList();
       //System.out.println(l2  instanceof Serializable);check why this is not working
        System.out.println(l1  instanceof Cloneable); //true
        System.out.println(l1  instanceof RandomAccess); //true
        System.out.println(l2  instanceof RandomAccess); //false
    }
}
```

**When should use/ not use ArrayList**
- ArrayList is a best choice if our frequent operation is retrival operation, because ArrayList implements RandomAccess interface.
- ArrayList is a worst choice if our frequent operation is insertion/deletion in the middle.(Recommondade LinkedList)
example: list.remove(2,"B");

**Differences Between ArrayList & Vector:**

ArrayList  | Vector
------------- | -------------
Every method present in the ArrayList is Non-synchronized | Every method present in the Vector is a synchronized
At a time, multiple threads are allowed to operate on ArrayList object, not thread safe  | Only one thread allowed to operate, hence thread safe.
Relatively performance is high, because threads are not required to wait to operate on ArrayList object | Relatively performance is low, because thread are required to wait to operate on Vector object.
Introduced in 1.2v and it is a Non-legacy class | Introduced in 1.0v, and it is a legacy class of Collection.


**How to get synchronized version of ArrayList object?**

By default, ArrayList is non synchronized, but we can get synchronized version of ArrayList object by using **synchronzedList()**
of *Collections* class.

```
public static List synchronzedList(List l)
{}
```
Example:
```
ArrayList l = new ArrayList();
List l1 = Collections.synchronizedList(l);
where, l is non-synchronized & l1 is synchronized.
```

Similarly, we can get synchronized version of Set & Map object by using the following methods of Collections class:
```
public static Set synchronizedSet(Set s){
}

public static Map synchronizedMap(Map m){
}
```
**LinkedList(C)**:
- The underlying data structure is doubly LinkedList.
- Insertion order is preserved and duplicates objects are allowed.
- Heterogeneous objects are allowed and null insertion is possible.
- LinkedList implements Seriablizable & Cloneable interfaces but not RandomAccess.
- LinkedList is the best choice if our frequest operation is insertion in middle.
- LinkedList is the worst choice if our frequest operation is retrival.

  **Contructors in LinkedList:**
  - LinkedList list= new LinkedList();
   Creates an empty LinkedList objec.
  - LinkedList list= new LinkedList(Collection c);
  Create an equivalent LinkedList object for the given Collection.

 **LinkedList class specific methods:**
 Usually, we can use LinkedList to develop Stacks & Queues. To provide support for this requirement, LinkedList class defines the following specific methods

  void addFirst(Object o)
  void addLast(Object o)
  Object getFirst()
  Object getLast()
  Object removeFirst()
  Object removeLast()

Example code:
```
import java.util.*;
class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("amol");
        list.add(101);
        list.add(null);
        list.add("amol");//[amol, 101, null, amol]
        
        list.set(0, "kajal");//[kajal, 101, null, amol]
        
        list.add(0, "anjali");//[anjali, kajal, 101, null, amol]
        list.removeLast();
        list.addFirst("Dyaneshwar");//[Dyaneshwar, anjali, kajal, 101, null]
        System.out.println(list);     
    }
}
```
**Differences between ArrayList & LinkedList**

ArrayList  | LinkedList
------------- | -------------
ArrayList is the best choice is our frequest operation is retrival  | LinkedList is the best choice if our frequent operation is insertion/deletion in the middle.
ArrayList is the worst choice if our frequent operation is insertion/updation in middle  | LinkedList is the worst choice if our frequent operation is retrival.
In ArrayList, Elements are stored in consecutive memory location, hence retrival operation become easy | LinkedList elements are stored at Random location, hence retrival operation become complecated.
Underlying data structure used is Array | Underlying data structure used is doubly linkedlist.


**Vector(C)**

- Resizable Array/ Growable array
- Duplicates allowed, insertion order preserved.
- Heterageneous Elements & null insertions allowed.
- Vector class implements Serializable, Cloneable & RandomAccess interface.
- Every method present in the vector is synchronized and hence Vector object is thread safe.

  **Constructors of Vector:**
  -  Vector v = new Vector();
    It creates an empty Vector object of default size of 10, once Vector object reaches to its initial default capacity then a new vector object created with *double size*
```
newCapacity = currentCapacity*2
```

   - Vector v = new Vector(int initialCapacity);
It creates an empty Vector object with the specified initial capacity.

   - Vector v = new Vector(int initialCapacity, int increamentalCapacity);
   - Vector v = new Vector(Collection c);
It creates an equivalent Vector object for the given collection. this contructor meant for interconversion between Collection objects.

    **Vector class Specific methods hint: old generation long names**

 - To add element   
 add(Object o) --> Collection
 add(int idx, Object o)---> List 
 addElement(Object o) ---> Vector

- To remove specific element based on Object & index
 remove(Object o);---> C
 remove(int index, Object o)---> L
 removeElement(Object o) ----> V

- To remove everything from Collection
 clear()----> C
 removeAllElements()---> V
 removeElementAt(int index)

 - To get objects:
Object get(int index)---> L
Object elementAt(int index)--->V
Object firstElement()--> V
Object lastElement()----> V

- other methods of Vector class
size()
capacity()
Enumeration elements()

- Demo code:
```
import java.util.*;
class VectorDemo {
    public static void main(String[] args) {
        Vector v = new Vector();
         System.out.println(v.capacity());//10
        for(int i=1;i<=10;i++){
            v.addElement(i);
        }
        System.out.println(v.capacity());//10
        v.addElement("amol");//11th element added
        System.out.println(v.capacity());//size doubled 20
        System.out.println(v);
    }
}
```

Example with initialCapacity vector object:
```
import java.util.*;
class VectorDemo {
    public static void main(String[] args) {
        Vector v = new Vector(22);
         System.out.println(v.capacity());//22
        for(int i=1;i<=10;i++){
            v.addElement(i);
        }
        System.out.println(v.capacity());//22
        v.addElement("amol");
        System.out.println(v.capacity());//22
        System.out.println(v);
    }
}
```
Example with incremental capacity
```
import java.util.*;
class VectorDemo {
    public static void main(String[] args) {
        Vector v = new Vector(10,3);
         System.out.println(v.capacity());//10
        for(int i=1;i<=10;i++){
            v.addElement(i);
        }
        System.out.println(v.capacity());//10
        v.addElement("amol");
        System.out.println(v.capacity());//13 after adding 11th element
        System.out.println(v);
    }
}
```

**Stack(C)**

- It is the child class of Vector.
- Specially designed class for Last In First Out *LIFO*.
- Constructor only once:
```
Stack s = new Stack();
```
- Stack class methods:
Object push() - to add object
Object pop() - remove the top object of Stack
Object peek() - return the top of Stack without removal
boolean empty() - check Stack is empty or not
int search(Object o) - if object present then it returns the offset of Object, otherwise returns -1;

Example of search("C") = 3

| 3 | C| 2  |
|---|--|----|
| 2 | B|  1 |
| 1 | A|  0 |
|OfS|ele|idx

Example sample code:

```
import java.util.*;
class StackDemo {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push("A");
        s.push("B");
        s.push("C");
        
        System.out.println(s.search("A"));
        System.out.println(s.search("B"));
        System.out.println(s.search("C"));
        System.out.println(s.search("V"));
        System.out.println(s.peek());
        s.pop();
        System.out.println(s);
        
    }
}
```
Output
```
3
2
1
-1
C
[A, B]
```

**3 Cursors of Java**

If you want the objects from Collection one by one then we should go for Cursors. There are three types of cursors available in java.

1. Enumeration
2. Iterator
3. ListIterator

**Enumeration**

We can use Enumeration to get Objects one by one from legacy Collection object. we can create Enumeration object by using *elements()* of Vector class.
```
Public Enumeration elements();
example: 
Vector v = new Vector();
Enumeration e = v.elements();
```

Method of Enumeration:
```
public boolean hasMoreElements();
public Object nextElement();
```

Example code for Enumeration:
```
import java.util.*;
class EnumerationDemo {
    public static void main(String[] args) {
       Vector v = new Vector();
       for(int i=0;i<=10;i++){
           v.addElement(i);
       }
       System.out.println("All Elements: "+ v);
       Enumeration e = v.elements();
       while(e.hasMoreElements()){
           int i = (int)e.nextElement();
           if(i % 2 ==0){
            System.out.print(i+" ");   
           }else{
               v.removeElement((Object)i);
           }
       }
       System.out.println("remaining elements: "+v);
    }
}
```

**Limitations of Enumerations(1.0v)**
- We can apply Enemuration concepts only for legacy classes and it is not a universal cursor.
- By using Enumeration, we can get only read access and we can't perform **remove** operation.

*To overcome above limitations we should go for Iterator*

**Iterator**
- We can apply iterator concept for any Collection object and hence it is a universal cursor.
- By using Iterator we can perform both **read & remove** operations.
- We can create Iterator object by using iterator() of Collection interface.
 ```
public Iterator iterator();

example:
Iterator itr = c.iterator();
where, c is any Collection object.
```
 - methods:
public boolean hasNext();
public Object next();
public void remove();


Iterator Demo Code:
```
import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("am");
        list.add("ak");
        list.add("au");
        list.add("ai");
        
        Iterator<String> itr = list.iterator();
        while(itr.hasNext()){
            String str = itr.next();
            if(str.contains("ai")){
                System.out.print(str+" ");
            }else{
                itr.remove();
            }
        }
    }
}
```

**Limitations of Iterator**
1. By using Enumeration & Iterator we can always move only towards forward direction and we can't move towards backward direction these are single direction cursors but not bidirectional cursor.
2. By using Iterator, we can perform only **Read & Remove** operations and we can't perform **replacement & addition** of new objects.


To overcome above limitations, we should go for **ListIterator**.

**ListIterator**
- By using ListIterator, we can move either to the forward or to the backward direction and hence it is **Bi-directional** cursor.
- By using ListIterator, we can perform **Replacement & Addition** of new objects, in addition to **Read & Remove** operations.
- ListIterator is the child interface of Iterator and hence all method present in Iterator by default available to the ListIterator.

We can create ListIterator, by using listIterator() of **List** interface.

```
public ListIterator listiterator();

ListIterator ltr = list.listIterator();
where, list is any List object.
```


ListIterator defines the following methods:
1. public boolean hasNext();
2. public Object next();
3. public int nextIndex();

*above 3 are for forward movement.*
4. public boolean hasPrevious();
5. public Object previous();
6. public int previousIndex();

*above 3 are for backward movement.*

7. public void remove();
8. public void add(Object o);
9. public void set(Object o);

*above 3 are for add, remove & replacement operation.*

ListIterator demo code
```
import java.util.*;
class ListIteratorDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList<>();
        list.add("amol");
        list.add("ajay");
        list.add("suraj");
        list.add("mani");
        
        ListIterator itr = list.listIterator();
        System.out.println(list);
        while(itr.hasNext()){
            String str = (String)itr.next();
            if(str.equals("mani")){
                itr.remove(); //[amol, ajay, suraj]
            }else if(str.equals("suraj")){
                itr.add("santosh");//[amol, ajay, suraj, santosh]
            }else if(str.equals("ajay")){
                itr.set("vijay");//[amol, vijay, suraj, santosh]
            }
        }
        System.out.println(list);
    }
}
```


**Note**: The most powerful cursor is ListIterator but its limitation is it is application only List implementated objects.

    
 
Property | Enumeration | Iterator | ListIterator | 
---------|-------------|----------|--------------|
where we can apply? | Applicable only for legacy classes | applicable for any Collection objects | only for List objects |
is it legacy ? | Yes 1.0v | No 1.2v | No 1.2v |
movement | single direction cursor(only forward) | single direction cursor(only forward) | bi-directional cursor |
allowed operations | only read operation | read and remove | read, remove, replace(using set()), add |
how we can get? | by using elements() of Vector class | by using iterator() of Collection interface | by using listIterator() of List interface|
methods | 2- hasMoreElements(), nextElement() | 3- hasNext(), next(), remove() | 9 methods |


** Know the implemented classes of all 3 cursors as all we are using is interfaces, we are creating the object of implemented class not of the interface**

```
import java.util.*;
class ImplementedClassesDemo {
    public static void main(String[] args) {
        Vector v = new Vector();
        Enumeration e = v.elements();
        Iterator itr = v.iterator();
        ListIterator ltr = v.listIterator();
        
        System.out.println(e.getClass().getName());
        System.out.println(itr.getClass().getName());
        System.out.println(ltr.getClass().getName());
    }
}
```

Output: note, before $ we have the outer class after $ we have the inner class of that outer class.
```
java.util.Vector$1
java.util.Vector$Itr
java.util.Vector$ListItr
```

**Set(I)**

- Set is child interface of Collection.
- If we want to represent a group of individual objects as a single entity where duplicates are *not allowed* and insertion order not preserved.
- Set interface doesn't any new method and we have to use only Collection interface methods.
   
**HashSet(C)**

1. The underlying data structure is *Hashtable*.
2. Duplicate objects are not allowed.
3. Insertion order is not preserved & insertion is based on hashcode of object.
4. null insertion is possible(only once).
5. Heterogeneous objects are allowed.
6. Implements Serializable & Cloneable but not RandomAccess interface.
7. HashSet is the best choice if our frequent operation is **search** operation.

**Note**
In HashSet duplicates are not allowed, if we are trying to insert the duplicates then won't get any compiletime  or runtime errors and add method simply returns false.

example:
```
HashSet set = new HashSet();
System.out.println(set.add("A"));//true
System.out.println(set.add("A"));//false
```

Constructors of HashSet:

```
HashSet h =new HashSet();
```
It creates an empty Hashset object with the default initial capacity **16** & and the default fill ratio is **0.75**.


```
HashSet h = new HashSet(int initialCapacity);
```
Creates an empty HashSet object with the specified initial capacity & the default fill ratio is 0.75.

```
HashSet h = new HashSet(int initialCapacity, float fillRatio);
```
It creates an empty object with the specified initial capacity & fill ratio.

```
HashSet h = new HashSet(Collection c);
```
Creates an equivalent HashSet object for the given Collection object. This contructor meant for inter convertion between Collection objects.


** fill ratio/ load factor**


After filling how much ratio a new Hashset object will be created, this ratio is called *fill ratio/load factor*


example: fill ratio 0.75 means after filling 75 percent ratio a *HashSet* object will be created.




  

