##
### Array & Collections
##
####  Intro ####
  - Homogeneous Data Struction.
  - No underliying data structure is used to implement the array.
  - Index based
  - Fixed in size
  - single variable can hold multiple values

  #### Limitations ####
  - fixed in size, once we create an array, there is no chance of increasing or decreasing the size based on our requirement. due to this, to use arrays concept compulsory
   we should know the size in advance, which may not possible always.
  - array can hold only homogeneous datatype elements, example: Student[] new = Student[20];, this issue can be be resolved by creating Object[]
  - There is no underlying data structure used, hence no existing methods available, hence for every operation we need to write the code explicitly, which increase complexity of code. 
  - To overcome above problems, we should go for collections.

#### Befinits with using collection ####
- collections are growable in nature, i.t. based on our requirement we can increase or descrease the size.
- Collections can hold both homogeneous and heterogeneous objects
- Every collection class is implemented based on some standard data structure, hence for every requirement readymade method support is available.
- Being a programmer, we are responsible to use those methods and we are not responsible to implement those methods.


Arrays  | Collections
------------- | -------------
Fixed in size  | growable
With respect to memory arrays are not recommonded  | recommonded
wrt to performance arrays are recommonded to use | not recommonded
Arrays can hold only homogeneous datatype elements | Collections can hold both homogeneous and heterogeneous elements
No underlying data structure for arrays, hence no readymade method support available | Every collection class is implemented based on some standard data structure, hence method support is available
Can store primitive datatype & object  | only object


#### What is Collection? ####
If we want to represent a group of individual objects as a single entity then we should go for collection.

*Collection Framework*: It contains several classes and interfaces which can be used to represent a group of individual objects as a single entity.

