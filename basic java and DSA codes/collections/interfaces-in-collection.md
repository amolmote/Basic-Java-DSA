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


**Queue(I)**
- Queue is the child interface of Collection.
- 
