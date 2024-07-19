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

  Collection   | Collections
------------- | -------------
  Collection is a interface, if we want to represent a group of individual objects a single entity then we should go for **Collection** | Collections is an utility class present in java.util package to define sevaral utility methods for collection objects.like sorting, searching etc.


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


