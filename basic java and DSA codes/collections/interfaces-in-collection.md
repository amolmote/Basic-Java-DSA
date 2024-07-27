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


**fill ratio/ load factor**


After filling how much ratio a new Hashset object will be created, this ratio is called *fill ratio/load factor*


example: fill ratio 0.75 means after filling 75 percent ratio a *HashSet* object will be created.

Demo code which has all concepts of HashSet:
```
import java.util.*;
class HashSet {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add("D");
        set.add("B");
        set.add(10);
        set.add("C");
        set.add(null);
        System.out.println(set.add("B"));//false
        System.out.println(set);//[null, B, C, D, 10]
    }
}
```
**LinkedHashSet(C)**

1. It is the child class of HashSet.
2. It is exactly same as HashSet including constructors and methods except the following differences.

**Difference between HashSet & LinkedHashSet**

HashSet  | LinkedHashSet
------------- | -------------
The underlying data structure is Hashtable | The underlying data structure is a combination of Hashtable & LinkedList.
Insertion order not preserved | Insertion order is preserved.
Introduced in 1.2v | Introduced in 1.4v

In the above program, if we replace the Hashset with LinkedHashSet then the output is:
```
false
[D, B, 10, C, null]
```

i.e. Insertion order is preserved.

**Note:** In general, we can use LinkedHashSet to develop cache based applications where duplicates are not allowed & insertion order preserved.

**SortedSet(I)**
1. SortedSet is the child interface of the Set.
2. If we want to represent a group of individual objects according to some sorting order without duplicates then we should go for SortedSet.

**methods of SortedSet with example:**
101|102|103|106|109|114|120
---|---|--|----|----|---|--
   
1. Object first() - 101
2. Object last() - 120
3. SortedSet headSet(109) - [101,102,103] exclusive the passed object arg.
4. SortedSet tailSet(109) - [109, 114, 120]
5. SortedSet subSet(101, 114) - [101,102,103,106] first is inclusive arg & last is exclusive.
6. Comparator comparator() - return Comparator object that describes underlying sorted technique. If we are using default *Natural* sorting order technique then we will get **null**.

**Default Sorting Order** - for String alphabatical & for numbers Ascending order.

**TreeSet(C)**
1. The underlying data structure is balanced tree.
2. Duplicate objects are not allowed.
3. Insertion order is not preserved.
4. Heterogeneous objects are not allowed, otherwise we will get RuntimeException saying **ClassCastException**
5. from 1.7 version null insertion is not allowed at all(because compare() of Comparator invoked on null object- **NullPointerException**). till 1.6v null is allowed on empty set object.
6. TreeSet implements Serializable & Cloneable interface but not RandomAccess.
7. All objects will be inserted based on some sorting order, it may be default natural sorting order or customized sorting order.


**Constructors**
```
TreeSet set = new TreeSet();
```
It creates an empty TreeSet object and all elements are inserted in default sorting order. If we want to use default natural sorting order using above contructor then the objects that we are inserting should be **Homogeneous & Comparable**. The element(object class) should implements Comparable interface.

to see this on cmd use below command:
```
javap java.lang.StringBuffer
```


```
TreeSet set = new TreeSet(Comparator c);
```
It creates an empty TreeSet object with customized sorting order.

```
TreeSet set = new TreeSet(Collection c);
```
It creates equivalent set object with default natural sorting order.

```
TreeSet t = new TreeSet(SortedSet s);
```
Creates TreeSet equivalent to the passed SortedSet which follows the sorting techique of object s.


TreeSet Demo code:
```
import java.util.*;
class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        set.add("A");
        set.add("a");
        set.add("P");
        set.add("Z");
        set.add("B");
       // set.add(new Integer(19));//ClassCastException
       //set.add(null);//NullPointerException
        System.out.println(set);//[A, B, P, Z, a]
        
    }
}
```


**Comparable(I)**

1.It is present in java.lang package and it contains only one method *compareTo*.

```
public int compareTo(Object obj)

obj1.compareTo(obj2)
1. -ve => if obj1 has to come **before** obj2.
2. +ve => if obj1 has to come **after** obj2.
3. 0 => both are  equal


obj1: The object which are trying to insert.
obj2: already inserted element.

```
**compareTo above rules demo code**
```
class CompareToDemo {
    public static void main(String[] args) {
              System.out.println("A".compareTo("Z"));//-ve
              System.out.println("M".compareTo("B"));//+ve
              System.out.println("A".compareTo("A"));//0
              System.out.println("A".compareTo(null));//NullPointerException
    }
}
```

If we are depending on default natural sorting order then while adding the objects into the TreeSet, jvm will call *compareTo()*

**Demonstration on compareTo()**
```
TreeSet t = new TreeSet();
t.add("K") => no comparison
t.add("Z") => "Z".compareTo("K") return +ve, "Z" should added after the "k"
t.add("A") => "A".compareTo("K") return -ve, "A" should added before the "K".
```


**Note**
If default natural sorting order not available or if we are not satisfied with the default natural sorting order then we  should go for customized sorting by using **Comparator**- which has compare().


**Customized sorting demo code- reverse order of String objects**


**Comparator(I)**
1. Comparator present in java.util package and it defines two methods compare() & equals()
2. prototype of method:
```
public int compare(Object obj1, Object obj2)

same concept like compareTo method, -ve, +ve & 0

public boolean equals(Object obj)

```
**Note**: Whenever we are implementing the Comparator interface, we need to provide the implementation only for compare(), because Object class already have the implementation for equals(). and Object class is the parent class of every class in java.


**Program**: Insert Integer objects in the TreeSet object & maintain the sorting order descending.

Comparator Integer based demo code:
```
import java.util.*;
class ComparatorIntDemo implements Comparator {
    
    public int compare(Object obj1, Object obj2){
        int num1 = (int)obj1;
        int num2 = (int)obj2;
        if(num1<num2){
            return +1;
        }else if(num2 < num1){
            return -1;
        }else{
            return 0;
        }
    }
    public static void main(String[] args) {
        TreeSet t = new TreeSet(new ComparatorIntDemo());
          t.add(19);
          t.add(29);=> compare(29, 19)
          t.add(23);=> compare(23,19), 23 before 19 then compare(23,29), 23 after 29
          t.add(77);=> compare(77, 19), 77 before 19 then compare(77, 23), 77 before the 23, compare(77, 29), 77 before the 29
     
          
          System.out.println(t);//[77, 29, 23, 19] printed in inorder traversal of tree.
    }
}
```

Comparator String based Demo Code:
```
import java.util.*;
class MyComparator implements Comparator {
    
    public int compare(Object obj1, Object obj2){
        String str1 = (String)obj1;
        String str2 = obj2.toString();
        
        if(str1.compareTo(str2)<0){
            return +1;
        }else if(str1.compareTo(str2)>0){
            return -1;
        }else{
            return 0;
        }
        
    }
    public static void main(String[] args) {
             TreeSet set = new TreeSet(new MyComparator());
             set.add("A");
             set.add("B");
             set.add("Z");
             set.add("K");
             System.out.println(set);//[Z, K, B, A]
    }
}
```

Few other customization in compare();
1. compare() always returns +1, then insertion order is followed.
2. compare() always return -1, then it returns the reversal of insertion order.
3. compare() always return 0, then only first element is returned.
 
  
**Defference Between Comparable(I) & Comparator(I)**
Comparable(I)  | Comparator(I)
------------- | -------------
Present in java.lang package | Present in java.util package
Comparable meant for default natural sorting order | Comparator meant for customized sorting order
methods present- compareTo(Object o) | methods present - compare(Object obj1, obj2), equals(Object obj)



**Map(I)**
1. Map is *not* child interface of Collection.
2. If we want to represent a group of objects as **Key-value pairs**, then we should go for Map.
   key  | value
------------- | -------------
101  | amol
102  | Jack
103 | Josh
104 | Mike

3. Both key and value are Objects only.
4. Duplicate keys not allowed but value can be.
5. Each key-value pair is called **Entry**, hence Map is considered as Collection of Entry objects.

**Map specific methods:**
```
Object put(Object key, Object value);
void put(Map m);
Object get(Object key) -  get the value associated with specified key.
Object remove(Object key) - remove the Entry associated with the specified key
boolean containsKey(Object key)  - check if the map contains this key
boolean containsValue(Object value) - check if the map contains this value
boolean isEmpty() - check if Map is empty or not
int size()
void clear()
```
1.To add key-value pair in Map.
2. If the key is already present in Map then old value will be replaced with new and it returns old value, if no replacement then put() return null.
```
map.put(101, "amol");//returns null
map.put(102,"mike");//returns null
map.put(101, "josh"); josh replaced with amol and put method returns amol.
```


**Collection views of Map**
```
Set keySet();
Collection values();
Set entrySet();
```

**Entry(I)**
1. Inner interface of Map.
2. Map is a group of a key-value pairs and each key-value pair is called an Entry, hence Map is considered as a Collection of a Entry objects.
3. Without existing Map object there is no chance of Entry object, hence Entry interface is defined inside Map interface.


Entry specific methods and we can only apply on Entry object.
```
interface Map{

     interface Entry{
       Object getKey();
       Object getValue();
       Object setValue(Object newValue);
    }
}
```

**HashMap(C)**

1. The underlying data structure is Hashtable.
2. Insertion is not preserved & insertion is based on hashcode of key.
3. Duplicate keys are not allowed but values can be duplicated.
4. Heterogeneous objects are allowed for both key & value.
5. Null is allowed for key(only once)
6. Null is allowed for values(any number of times)
7. HashMap implements Serializable & Cloneable interfaces but not RandomAccess.
8. HashMap is the best choice if our frequent operation is **Search**.

Constructors of HashMap;
```
HashMap map = new HashMap();
```
Creates an empty Hashmap object with default initialCapacity 16 & the default fillRatio 0.75

```
HashMap m = new HashMap(int initialCapacity);
```
Creates an empty HashMap object with specified initialCapacity & the default fillRatio 0.75.

```
HashMap m= new HashMap(int initialCapacity, float fillRatio);
```

```
HashMap m = new HashMap(Map m);
```

Demo Code with all concepts:
```

import java.util.*;

class MapEntryMethodDemo {
    
    public static void main(String[] args) {
        HashMap map = new HashMap();
        map.put("amol", 1000);
        map.put("josh",1200);
        map.put("david", 3000);
        map.put("joe", 2000);
        System.out.println(map);//{joe=2000, amol=1000, josh=1200, david=3000}

        Set set = map.keySet();
        System.out.println(set);//[joe, amol, josh, david]
        
        Collection valueCollection = map.values();
        System.out.println(valueCollection);//[2000, 1000, 1200, 3000]
        
        Set entry = map.entrySet();//return Map.Entry
        
        Iterator itr = entry.iterator();
        /*Below are the Entry specific methods example*/
        while(itr.hasNext()){
            Map.Entry en = (Map.Entry)itr.next();
            System.out.println(en.getKey()+"->"+en.getValue());
            /*
            joe->2000
            amol->1000
            josh->1200
            david->3000
            */
            if(en.getKey().equals("amol")){
                en.setValue(10000);
            }
        }
        System.out.println(map);//{joe=2000, amol=10000, josh=1200, david=3000}
        
    }
}`
```

**Difference Between HashMap & Hashtable** same difference as ArrayList & Vector

HashMap  | Hashtable
------------- | -------------
 Every method present in HashMap is not synchronized | Every method present in Hashtable is synchronized.
 At a time, multiple threads are allowed to operate on Map object, hence is not thread safe | at a time, only one thread is allowed to operate on Hashtable object & hence it is thread safe.
 Relatively performance is high because threads are not required to wait to operate on HashMap object | relatively performance is low, because threads are required to wait to operate on Hashtable object.
 null is allowed for both the key & value | null is not allowed for keys & values otherwise we will get NullPointerException.
 Introduced In 1.2v, hence it is not a legacy class | Introduced in 1.0v & it is a legacy class.


 **How to get synchronized version of HashMap object?**
 By deault Map is non synchronized but we can get synchronized version of Map using the below method of **Collections** class.
 
 ```
HashMap m = new HashMap();
Map m1 = Collections.synchronizedMap(m);
m=> non synchronized.
m1=> synchronized Map
```

**LinkedHashMap(C)**
1.It is the child class of HashMap.
2. It is exactly same as HashMap(incluiding methods and contructors) except the following differences:

HashMap | LinkedHashMap
--------|-------------
The underlying data structure is Hashtable | The underlying data structure is the combination of LinkedList & Hashtable(Hybrid dataStructue)
Insertion order is not preserved and it is based on hashcode of keys | Insertion order is preserved.
Introduced in 1.2v | Introduced in 1.4 v

In the above HashMap program, if we replace HashMap with LinkedHashMap then the output is:
```
{amol=1000, josh=1200, david=3000, joe=2000}
```
i.t insertion order is preserved.

**Note**: LinkedHashSet & LinkedHashMap are commonly used for developing *Cache Based Applications* as it doesn't allow duplicates and preserves the insertion order.


**Difference Between "==" operator and equals()** important to understand the difference between HashMap &IdentityHashMap

In general, == operator meant for reference comparison (address comparison) where as equals() meant for content comparison.
example:
```
Integer I1 = new Integer(30);
Integer I2 = new Integer(30);
sop(I1==I2)//false
sop(I1.equals(I2));//false
```

**IdentityHashMap(C)**
1. It is exactly same as HashMap(including methods & constructors except the following difference.
2. In case of Normal HashMap , jvm will use equals() method to identify duplicates key which is meant for content comparison.
3. But in the case of IdentityHashMap, jvm will use == operator to identify duplicate keys which is meant for reference comparison(address comparison).


Demo code:
 ```
import java.util.*;

class HashMapEqualsMethodUseDemo {
    
    public static void main(String[] args) {
        HashMap map = new HashMap();
        Integer i1 = new Integer(10);
        Integer i2 = new Integer(10);
        map.put(i1, "amol");
        map.put(i2, "josh"); //internally, HashMap uses equals() to compare the keys
        System.out.println(map);//{10=josh}
       
    }
}

/*IdentityHashMap demo Example

import java.util.*;

class IdentityHashMapDemo {
    
    public static void main(String[] args) {
        IdentityHashMap map = new IdentityHashMap();
        Integer i1 = new Integer(10);
        Integer i2 = new Integer(10);
        map.put(i1, "amol");
        map.put(i2, "josh");//IdentityHashMap uses == operator for key comparison
        System.out.println(map);//{10=josh, 10=amol}
       
    }
}
```


**WeakHashMap(C)**

1. It is exactly same as HashMap except, the following difference
2. In case of HashMap even though object(key) doesn't have any reference it is not eligible for gc if it is associated with HashMap that is HashMap dominates garbage collector.
3. But In case WeakHashMap, if object doesn't contain any referance then it is eligible for gc even though object associated WeakHashMap. i.e. garbage collector dominates WeakHashMap.

Domination of HashMap over garbage collector Example code:
```

import java.util.*;

class DominationOfHashmap {
    
    public static void main(String[] args) throws InterruptedException {
        HashMap map = new HashMap();
        Temp t = new Temp();
        map.put(t, "amol");
        System.out.println(map);//{temp=amol}
        t = null;
        System.gc();
        Thread.sleep(4000);
        System.out.println(map);//{temp=amol}
    }
}
class Temp{
        
        public String toString(){
            return "temp";
        }
        public void finalize(){
            System.out.println("finalize() invoked by gc");
        }
}
```

Domination of garbage collector over WeakHashMap code:
```

import java.util.*;

class DominationOfGarbageCollector {
    
    public static void main(String[] args) throws InterruptedException {
        WeakHashMap map = new WeakHashMap();
        Temp t = new Temp();
        map.put(t, "amol");
        System.out.println(map);
        t = null;
        System.gc();
        Thread.sleep(4000);
        System.out.println(map);
    }
}
class Temp{
        
        public String toString(){
            return "temp";
        }
        public void finalize(){
            System.out.println("finalize() invoked by gc");
        }
}
```
Output:
```
{temp=amol}
finalize() invoked by gc
{}
```

**SortedMap(I)**
1. it is the child interface of Map.
2. If we want to represent a group of key-value pair according to some sorting order of keys then we should go for SortedMap.
3. Sorting is based on the Key but not based on the value.
4. SortedMap defines the following specific methods:

```
Object firstKey();
Object lastKey();
SortedMap headMap(Object key); => return entries less  than specified key
SortedMap tailMap(Object key); => returns entries whose key is greater & equal to the specified key
SortedMap subMap(Object key1, Object key2); => returns the entries whose keys are greater and equal to key1 & less than key2
Comparator comparator();
```

Demo code for above methods:
```

import java.util.*;

class SortedMapMethodsDemo {
    
    public static void main(String[] args)  {
        TreeMap map = new TreeMap();
        map.put(101,"amol");
        map.put(103, "josh");
        map.put(104,"joe");
        map.put(106, "dan");
        map.put(109, "mark");
        System.out.println(map);///{101=amol, 103=josh, 104=joe, 106=dan, 109=mark}
        System.out.println(map.firstKey());//101
        System.out.println(map.lastKey());//109
        System.out.println(map.headMap(106));//{101=amol, 103=josh, 104=joe}
        System.out.println(map.tailMap(104));//{104=joe, 106=dan, 109=mark}
        System.out.println(map.subMap(103, 109));//{103=josh, 104=joe, 106=dan}
        System.out.println(map.comparator());//null => because of natural sorting order
    }
}
```

**TreeMap(C)**
1. The underlying data structure is Red-Black tree.
2. Insertion order is not preserved & it is based on some sorting order of keys.
3. Duplicate keys are not allowed but values can be duplicated.
4. If we are depending on the natural sorting order then keys should be homogeneous and Comparable, otherwise we will get RuntimeException saying ClassCastException.
5. If we are defining our own customized sorting order then the keys need not be homogeneous & Comparable, then we can take keys heterogeneous & non comparable also.
6. Whether we are depending on default natural sorting or customized sorting order there are no restriction for values, we can take heterogeneous & non comparable objects also.


1. For non empty TreeMap if we are trying to insert entry with null key then we will get RuntimeException saying NullPointer Exception.
2. For empty TreeMap, as the first entry with null key is allowed nut after inserting that entry if we are trying insert any other entry then we will get NullPointerException.

**Note**: The above null acceptance rule applicable until 1.6v only, from 1.7v onwards null is not allowed for key. for value we can use null any number of times.

**Constructors**
```
TreeMap map=  new TreeMap(); => for default natural sorting order 

TreeMap map=new TreeMap(Comparator c);=> for customized sorting order

TreeMap map=new TreeMap(Map m);=> equivalent to specified map object

TreeMap map=new TreeMap(SortedMap s);  => equivalent to specified SortedMap object, follows sorting order of s.
```

TreeMap Demo Code:
```

import java.util.*;

class TreeMapDemo {
    
    public static void main(String[] args)  {
        TreeMap map = new TreeMap();
        map.put(101,"amol");
        map.put(102,"joe");
        map.put(100,"david");
        //map.put("abc", "killer");//ClassCastException
        //map.put(null, "josh");//NullPointerException
        System.out.println(map);//{100=david, 101=amol, 102=joe}
    }
}
```

**Customized Sorting of TreeMap**

Example:
```

import java.util.*;

class CustumizedSortingTreeMapDemo implements Comparator {
    
    public int compare(Object obj1, Object obj2){
        int n1 = (int)obj1;
        int n2 = (int)obj2;
        if(n1< n2){
            return +1;
        }else if(n2 < n1){
            return -1;
        }else{
           return 0;
        }
    }
    
    public static void main(String[] args)  {
        TreeMap map = new TreeMap(new CustumizedSortingTreeMapDemo());
        map.put(101,"amol");
        map.put(102,"joe");
        map.put(100,"david");
        
        System.out.println(map);//{102=joe, 101=amol, 100=david}
    }
}
```

**Hashtable**
1. The underlying data struture for Hashtable is **Hashtable**.
2. Insertion order is not preserved & it is based on hashcode of keys.
3. Duplicate keys are not allowed & values can be duplicated.
4. Heterogeneous objects are allowed for both keys & values.
5. Null is not allowed for both key & values, otherwise we will get RuntimeException saying NullPointerException.
6. It implements Serializable, Cloneable interfaces but not RandomAccess.
7. Every method present in HashTable is synchronized, and hence Hashtable object is Thread safe.
8. Hashtable is the best choice if our frequent operation is *search* operation.

**Constructors**

```
Hashtable h= new Hashtable();
Creates an empty Hashtable object with default initial capacity 11 & default fill ratio is 0.75

Hashtable h= new Hashtable(int initialCapacity);


Hashtable h = new Hashtable(int initialCapacity, float fillRatio);

Hashtable h= new Hashtable(Map m);
```

Hashtable Demo code and its representation in bucket:
bucket idx | bucket 
-----------|-------
10 |  
9 | 9=joe
8 | 
7 | 
6 | 
5 | 
4 |
3 | 3=amol, 14=cage
2 |
1 |
0 | 11=mark, 22=karolina


**Note**: Hashtable reads data from bucket from *Top to bottom & right to left*.
```

import java.util.*;
class HashtableDemo {
    public static void main(String[] args)  {
      Hashtable h = new Hashtable();
      h.put(new Temp(3),"amol"); 3%11 = 3
      h.put(new Temp(9), "joe");
      h.put(new Temp(11), "mark");
      h.put(new Temp(14), "cage");
      h.put(new Temp(22), "karolina");
     // h.put(new Temp(18), null);NPE
        System.out.println(h);//{9=joe, 14=cage, 3=amol, 22=karolina, 11=mark}
    }
}
class Temp{
    int i;
    public Temp(int i){
        this.i = i;
    }
    
    public int hashCode(){
        return i;
    }
    
    public String toString(){
        return i +"";
    }
}
```

**Properties**
1. In our program if anything changing frequently like mailId, mobile no, password, for these values not recommonded to hardcode these values in java code.
2. Because if there is any change and to reflect that change recompilation, rebuild & redeploy application is required. Which creates a big business impact to the client.
3. We can overcome this problem by using properties file, such type variable things we have to configure in the properties file
4. From that properties file we have to read into java program and we can use those properties.
5. The main advantage of this approach is if there is a change in properties file, to reflect that change just redeployment is enough which won't create any business impact to the client.
6. We can use java Properties object to hold properties which are coming from properties file.
7. In normal Map(Like HashMap, Hashtable, TreeMap) key and value can be any type but in the case of Properties key & value should be *String*  type only.

**Constructor**
```
Properties p=new Properties();
```

**methods**
```
String getProperty(String propertyName);  //to get the value associated with propertyName
String setProperty(String propertyName, String propertyValue);//to set new property, returns old value if key is already there
Enumeration propertyNames();

void load(InputStream is);//to load properties into java program from properties  file
void Store(OutputStream, String comment); //to store properties into the properties file
```

Properties Demo code:
```
import java.util.*;
import java.io.*;
class PropertiesDemo {
    public static void main(String[] args) throws Exception{
        Properties p = new Properties();
        FileInputStream fis = new FileInputStream("abc.properties");
        p.load(fis);
        System.out.println(p);
        System.out.println(p.getProperty("username"));
        p.setProperty("password","new_pwd");
        FileOutputStream fos = new FileOutputStream("abc.properties");
        p.store(fos, "pwd updated by amol");
    }
}
```
abc.properties file after update:
```
#pwd updated by amol
#Sat Jul 27 19:20:51 IST 2024
password=new_pwd
username=amol
```


**Queue(I)**

1. It is the child interface of Collection
2. If we want to represent a group of individual objects prior to processing(email service) then we should go for Queue.
3. For example: Before sending sms message, all mobile numbers we have to store in some data structure, In which order we added mobile numbers in the same order only message should be send. for this FIFO requirement Queue is the best choice.
4. Usually, Queue follows FIFO order but based on our requirement we can implement our own priority order also(PriorityQueue).
5. from 1.5 onwards **LinkedList** class also implements Queue interface also.
6. Linkedlist based implementation always follows FIFO.


Queue specific methods:
```
boolean add (Object o); To add the object in Queue.

boolean offer(Object o); To add object in Queue.

Object peek(); To return head element of Queue. If Queue is empty then return **null**.

Object element(); To return head element of Queue.If Queue is empty then throw **NoSuchElementException**.

Object poll(); To remove & return head element of Queue. If queue is empty then return **null**.

Object remove(): To remove & return head element of Queue. If queue is empty then raise RE: **NoSuchElementException**.

```



  


