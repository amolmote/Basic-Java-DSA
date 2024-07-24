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

*Note: there is no concret class which implemenents Collection interface directly.*

**List(I)**
- List is a child interface of Collection.
- if we want to represent a group of individual objects as a single entity where duplicates are allowed and insertion order must be preserved, then we should go for List.
- we can preserve insertion order via index and we can differentiate duplicate objects by using index. Hence index will play very important role in List.
- method which are present in List interface:
void add(int  index, Object o): add element at specified index, if that index already contain any element then it will shift to the next vacant space, and element will get added to the specified index.
example below:
```
     l.add(1,10)
```
output: 
```
[1, 2, 3]
[1, 10, 2, 3
```

- want to add group of object starting from the specified index:
boolean addAll( int index, Collection c)


Object remove(int index)
Object get(int index)
Object set(int index, Object o)
int indexOf(Object o): return the first occurance index.
int lastIndexOf(Object o): return the last occurance index.
ListIterator listIterator()

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

- 








   

  

