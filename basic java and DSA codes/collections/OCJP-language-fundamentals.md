
# Language Fundamentals #
1. identifiers
2. Reserved keywords
3. Data types
4. Literals
5. Arrays
6. Types of variables
7. var-args methods
8. main method
9. command line argument
10. java coding standards

## Identifier ##
- A name in java program is called identifier, which can be used for identification purpose. It can be method name or variable name, class name or lable name.


![image](https://github.com/user-attachments/assets/b8e04ea7-a7b5-4988-bd66-bc8fa6c63d30)


- the above highlighted words are called as Identifiers in java.

### Rules for defining java identifiers ###
- The only allowed characters in java indentifiers are 
a to z
A to Z
0 to 9
$
_
- If we use any other from above then we will get compile time error.
example: total_sum => valid
         name# => invalid

- Identifiers can't starts with the digit 
example: total123 => valid
          123total => invalid

- java identifiers are case-sensitive off course java language itself is a treated as case sensitive programming language
  example: 
```
class Test{

  int num=10;
  int Num=10;
  int NUM=10;
// we can differentiate by case
}
```

- There is no length limit for java indentifiers but it is not recommonded to take too lengthy indetifiers. 

- we can't use reserved words as indentifiers.
example:
int x=10 => valid
int if=20 => inavlid

- All predefined java class names and interface names we can use as identifiers. Even though it is valid but it is not a good programming practice because it reduced readability and creates confusion.
 and it is not recommonded.
```
class IdentifierDemo {
    public static void main(String[] args) {
        int String=20;
        System.out.println(String);
    }
}
```

### WHich  of the following are valid java identifiers? ###

![image](https://github.com/user-attachments/assets/8fe4b33d-83ca-4f85-946c-8b5a88d0bbed)



## Reserved Words ##
- In java some words are reserved to represent some meaning or functionality such type of words are called Reserved words.


![image](https://github.com/user-attachments/assets/c76cb21c-d917-4b64-95f4-3d7610ab6e6e)

datatypes(8) | flow control(11) | modifiers(11) | Exception handling(6) | class related(6) | object(4) | return type(1) | unused keywords(2) | reserved literals(3) | enum(1)
----------|---------------------|---------------|-----------------------|------------------ | --------|---------------|-----------------| ------------------------|--------
byte | if  | public  | try | class  |   new | void | goto  | true | enum(1.5v)
short | else  | private | catch | interface |  instanceof |  | const | false | 
long | switch | protected | finally | extends | super |   |   |   null   |
int | case  | static | assert(1.4v) | implments | this |    |   |    |
float | default  | final | throw | import  |    |   |    |    |
double | while | abstract | throws | package  | |   |    |    |
boolean | do | synchronized |  |    |   |   |    |    |
char | for | native |     |     |   |   |    |    |
  | break | strictfp(1.2v)|   |   |     |    |    |    |
   | continue | transient |  |   |   |   |    |    |
  | return  | volatile |   |     |   |   |    |    |

- void: In java return type is mandatory, if method won't return anything then we have to declare method with void.
- Usage of goto created sevaral problems in old languages and hence sun people banned this keyword in java.
- const: use final instead of const.
- goto and const are unused keyword and if we are trying to use we will get compile time error.
- we can use enum to define a group of named constants 



**Conclusions:**


- All 53 resevred words in java contains only lower case alphabates.
- In java we have only new keyword and there is no delete keyword because destruction of useless objects is a resposibility of garbage collector.
- The following are new keywords in java: strictfp(1.2v), assert(1.4v), enum(1.5v)

 ## Data types ##
 - In java every variable and every expression has some type.
 - Each and every datatype is clearly defined
 - Every assignment should be checked by compiler for type compatibility.
 - Because of above reasons we can conclude java language is strongly typed programming language.


- Java is not considered as pure object oriented programming language because sevaral OOP feature are not supported by java like operator overloading,multiple inheritance etc.
- Moreover we are depeding on premitive datatypes which are non objects.


![image](https://github.com/user-attachments/assets/9b4713af-d42f-4633-9cb4-358865b1644f)


- Except boolean and char remaining datatype considered as signed datatype because we can represent both positive and negative numbers.

### byte ###
- size 1 byte(8 bits)
- max_value +127
- min_value -128
- range -128 to +127



![image](https://github.com/user-attachments/assets/57fb0dd3-2c8a-4371-adcf-71c0ceca499a)

- The most significant bit acts as sign bit.
- 0 means positive, 1 means negative.
- positive numbers will be represented directly in memory whereas negative numbers will be represented in two's complements form.

**Identify valid or invalid**

```
byte b=10;  valid
byte b= 127; valid
byte b=128; invalid
error: incompatible types: possible lossy conversion from int to byte
              byte b=128;

byte b= 12.8;
incompatible types: possible lossy conversion from double to byte
              byte b=12.8;

byte b= true;
error: incompatible types: boolean cannot be converted to byte
              byte b= true;

byte b= "amol"
error: incompatible types: String cannot be converted to byte
              byte b= "amol";
```


- byte is the best choice if we want to handle data interms of streams either from the file or from the network. (file supported form or network supported form is byte).

### short ###
- this is the most rarely used datatype in java 
- size 2 byte(16 bits)
- range -32768 to 32767 (-2^15 to 2^15-1)

```
short s= 32767; valid
short s= 32768; invalid
error: incompatible types: possible lossy conversion from int to short
              short s= 32768;
short s= 10.8; invalid
error: incompatible types: possible lossy conversion from double to short
              short s= 10.8;

short s= true;
 error: incompatible types: boolean cannot be converted to short

```

- short datatype is best suitable for 16 bit processors like 8085, but these processors are completely outdated and hence corresponding short datatype is also outdated datatype.

### int ###
- The most commonly used datatype in java is **int**.
- size 4 bytes (32bits)
- range -2^31 to 2^31-1
- -2147483648 to 2147483647

```
int a = 2147483647; valid
int a = 2747364748; invalid
error: integer number too large
              int a= 2147483648;

int a=2747364748l;
error: incompatible types: possible lossy conversion from long to int
              int a= 2147483648l;


error: incompatible types: boolean cannot be converted to int
              int a= true;
```


### long ###
- sometimes int may not enough to hold big values then we should go for long.
- example: the amount of distance traved by light in 1000 days, to hold this value int may not enough then we should go for long datatype
```
long l= 126000* 60 * 60 * 1000;
```
- example2: the number of characters present in big file may exceed int range, hence the return type of length() is long but not int.
```
long l= f.length();
```

- size 8bytes (64bits)
- range -2^63 to 2^63-1

**Note**
- All the above datatypes(byte, short, int, long) meant for representing integral values if we want to represent floating point values then we should go for floating point datatypes.



## Floating Point Datatypes ##

float | double
-------|-------
If we want 5 to 6 decimal places of  accuracy then we should go for float | If we want 14 to 15 decimal places of accuracy then we should go for double.
float follows single precision | double follows double precision
size: 4  bytes | size: 8 bytes
range: -3.4e38 to 3.4e38 | range: -1.7e308 to 1.7e308 



### boolean ###
- size: not applicable(virtual machine dependent)
- range: not applicable(but allowed values are true/false)

```
boolean b=true; valid

boolean b=0;  invalid
 error: incompatible types: int cannot be converted to boolean
              boolean b=0;

boolean b=True; invalid
Test.java:8: error: cannot find symbol
              boolean b=True;
                        ^
  symbol:   variable True
  location: class Test

boolean b= "true"; invalid
javac Test.java
Test.java:8: error: incompatible types: String cannot be converted to boolean
              boolean b= "true";


                    int x=0;
		  if(x){ //invalid
			  System.out.println("hello");
		  }else{
			  System.out.println("hiii");
		  }

error: incompatible types: int cannot be converted to boolean
                  if(x){


 while(1){//invalid
    System.out.println("hello");
 }
error: incompatible types: int cannot be converted to boolean
                  while(1){
```

### char ###
- old languages like C or C++(ASCII code based) and the number of  allowed different ASCII code characters and <=256.
- To represent these 256 characters 8 bits are enough hence the size of char in old languages is 1 byte.
- But java is UNICODE based and the number of different UNICODE characters are greater than 256 <= 65536.
- To represent these many characters 8 bits may not enough, compulsory we should go for 16 bits.
- hence the size of char in java is 2 bytes.
- range: 0 to 65535(total 65536 including 0)


### Summary ###
Data type | size | range | wrapper class | default value
----------|-------|------|---------------|--------------
byte  | 1 byte | -2^7 to 2^7-1(-128 to 127) | Byte | 0
short | 2 byte | -2^15 to s^15(-32768 to 32767) | Short |  0
int |  4 byte | -2^31 to 2^31-1( -2747483648 to 2747483647) | Integer | 0
long | 8 byte | -2^63 to 2^63-1 | Long | 0
float | 4 byte | -3.4e38 to 3.4e38 | Float | 0.0
double | 8 byte | -1.7e308 to 1.7e308 | Double | 0.0
boolean | NA | NA  |  Boolean |  false
char | 2 byte | 0 to 65535 | Character | 0(represents space character)

- null is default value for object reference and we can't apply for premitive, if we are trying to use for premitive then we will get compile time error.
example:
```
char ch=null
incompatible type found null required char
```


## Literal ##

- any constant value which can be assigned to variable is called Literal.
- example:
```
int x= 10;
int is datatype
x is a indentifier
10 is a literal/constant value
```

### Integral Literals ###
for Integral datatypes(byte, short, int, long) we can specify literal value in the following ways


### Decimal form ###
-  base 10
-  allowed digits are 0 to 9
-  example int x=10;

### Octal form ###
- base 8
- allowed digits are 0 to 7
- literal value should be prefixed with 0.
- example: int x=010;

### Hexadecimal form ###
- base 16
- allowed digits are 0 to 9, a to f( we can use both lower case and upper case characters for extra digit this is one of the very few areas where java is not
case sensitive)
- The literal value should be prefixed with 0x or 0X.
- example: int x=0X10;

These are only possible ways of specify literal for integral data types.

### Valid or Invalid Literal ###
```
int x=10;  //valid
int x=0786;  //invalid(8)-CE:Integer number too large
int x=0777; //valid
int x=0XFace; // valid
int x=0XBeef; //valid
int x=0XBeer; //invalid due to r, 
```


