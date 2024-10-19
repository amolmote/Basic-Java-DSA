# String class methods #

## charAt ##
- takes index returns char from given String
```
  public char charAt(int);
```
example:
```
class StringMethods {
    public static void main(String[] args) {
        String s="abc";
        char a=s.charAt(2);
        System.out.println(a);
    }
}
```
## equals ##
```
public boolean equals(java.lang.Object);
```
example:
```
class StringMethods {
    public static void main(String[] args) {
        String s="abc";
        System.out.println(s.equals("abc"));
    }
}
```
## contentEquals ##
```
public boolean contentEquals(java.lang.StringBuffer);
```
example1:
```
class StringMethods {
    public static void main(String[] args) {
        String s="abc";
        System.out.println(s.contentEquals(new StringBuffer("abc")));//true
    }
}

```
example2:
```
class StringMethods {
    public static void main(String[] args) {
        String s="abc";
        System.out.println(s.equals(new StringBuffer("abc")));//false
    }
}
```

## equalsIgnoreCase ##
```
public boolean equalsIgnoreCase(java.lang.String);
```
example:
```
class StringMethods {
    public static void main(String[] args) {
        String s="abc";
        System.out.println(s.equalsIgnoreCase("aBc"));//true
    }
}
```
## isEmpty ##
```
public boolean isEmpty();
```
example:
```
class StringMethods {
    public static void main(String[] args) {
        String s="";
        System.out.println(s.isEmpty());//true
    }
}
``` 
## regionMatches ##
- The regionMatches method in Java is used to compare a specific region (a substring) of two strings for equality
```
 public boolean regionMatches(int, java.lang.String, int, int);

 public boolean regionMatches(int toffset, String other, int ooffset, int len);
toffset: The starting index of the substring in the current (calling) string (this string).
other: The string to compare with.
ooffset: The starting index of the substring in the other string.
len: The number of characters to compare from both strings.
```
example:
```
class StringMethods {
    public static void main(String[] args) {
        String ts="amolmote";
        String os="bamolm";
        System.out.println(ts.regionMatches(0,os,1,5));//comparing amolm from both string- true
    }
}
```
## regionMatches ##
- It is similar to above, additionally we required to pass ignoreCase true or false.
```
public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len);
```
## startsWith ##
```
  public boolean startsWith(java.lang.String, int);
```
example: 
```
class StringMethods {
    public static void main(String[] args) {
        String ts="amolmote";
        System.out.println(ts.startsWith("mol",1));//true
    }
}
```
## startsWith ##
```
public boolean startsWith(java.lang.String);
```
example:
```
class StringMethods {
    public static void main(String[] args) {
        String ts="amolmote";
        System.out.println(ts.startsWith("amo"));//true
    }
}
```
## endsWith ##
```
  public boolean endsWith(java.lang.String);
```
example: 
```
class StringMethods {
    public static void main(String[] args) {
        String ts="amolmote";
        System.out.println(ts.endsWith("te"));//true
    }
}
```

## matches ##
- The matches(String regex) method in Java is used to check whether the entire string matches a given regular expression (regex).
```
public boolean matches(String regex)

```
example:
```
class StringMethods {
    public static void main(String[] args) {
        String ts="abc123";
        System.out.println(ts.matches("[a-z]+[0-9]+"));//true
    }
}
```
example2: matching digits only
```
class StringMethods {
    public static void main(String[] args) {
        String ts="1234";
        System.out.println(ts.matches("[0-9]+"));//true
    }
}
```
## contains ##
- The contains(CharSequence s) method in Java is used to check whether a specific sequence of characters (a substring) is present in a given string.
example:
```

class StringMethods {
    public static void main(String[] args) {
        String ts="amol mote";
        System.out.println(ts.contains("amol"));//true
    }
}
```
## indexOf ##
-The indexOf(int ch) method in Java is used to find the index (position) of the first occurrence of a specified character (given by its Unicode code point) within a string.
```
public int indexOf(int ch)
```
example
```
class StringMethods {
    public static void main(String[] args) {
        String ts="amolmote";
        System.out.println(ts.indexOf('m'));//1
        System.out.println(ts.indexOf(109));//1 means 'm'
    }
}
```
## indexOf ##
- The indexOf(int ch, int fromIndex) method in Java is used to find the index of the first occurrence of a specified character (given by its Unicode code point) in a string, starting the search from a specified index
```
public int indexOf(int ch, int fromIndex)
```
example:
```
class StringMethods {
    public static void main(String[] args) {
        String ts="amolmote";
        System.out.println(ts.indexOf('m', 3));//4
        System.out.println(ts.indexOf(97,2));//-1 97 means 'a'
    }
}
```
## similar to above ##
```
  public int lastIndexOf(int);
  public int lastIndexOf(int, int);
  public int indexOf(java.lang.String);
  public int indexOf(java.lang.String, int);
  public int lastIndexOf(java.lang.String);
  public int lastIndexOf(java.lang.String, int);
```
example:
```
class StringMethods {
    public static void main(String[] args) {
        String ts="amolmote";
        System.out.println(ts.indexOf("mote"));//4
        
    }
}
```

## substring ##
- The substring(int beginIndex) method in Java is used to extract a portion of a string starting from a specified index to the end of the string.
```
  public java.lang.String substring(int);
  public String substring(int beginIndex)
```
example:
```
class StringMethods {
    public static void main(String[] args) {
        String ts="amolmote";
        System.out.println(ts.substring(4));//mote
    }
}
```
## overloaded substring ##
- The substring(int beginIndex, int endIndex) method in Java is used to extract a portion of a string between two specified indices.
```
 public java.lang.String substring(int, int);
public String substring(int beginIndex, int endIndex)
startIndex is inclusive, endIndex is exclusive
```
example:
```
class StringMethods {
    public static void main(String[] args) {
        String ts="amolmote";
        System.out.println(ts.substring(2,4));//ol
    }
}
```
## subSequence ##
- The subSequence(int start, int end) method in Java is used to obtain a character sequence (which can be thought of as a substring) from a string between two specified indices. This method is part of the CharSequence interface, which is implemented by the String class.
- this function can be used with StringBuffer also as this class implements CharSequence interface.
- this is similar to subString method
```
public java.lang.CharSequence subSequence(int, int);
public CharSequence subSequence(int start, int end)

```
example:
```
class StringMethods {
    public static void main(String[] args) {
        String ts="amolmote";
        System.out.println(ts.subSequence(2,4));//ol
    }
}
```
## concat ##
```
  public java.lang.String concat(java.lang.String);
```
example:
```

class StringMethods {
    public static void main(String[] args) {
        String ts="amol";
        System.out.println(ts.concat("mote"));//amolmote
    }
}
```
## replace ##
```
public java.lang.String replace(char, char);
```
example:
```
class StringMethods {
    public static void main(String[] args) {
        String ts="amol";
        System.out.println(ts.replace('l','o'));//amoo
    }
}
```
##  replaceFirst
```
public java.lang.String replaceFirst(java.lang.String, java.lang.String);
```
example:  
```
class StringMethods {
    public static void main(String[] args) {
        String ts="amol amol";
        System.out.println(ts.replaceFirst("amol","mote"));//mote amol
    }
}
```
## replaceAll ##
```
public java.lang.String replaceAll(java.lang.String, java.lang.String);
```
example:
```
class StringMethods {
    public static void main(String[] args) {
        String ts="a,m,o,l,m,o,t,e";
        System.out.println(ts.replaceAll(",",""));//amolmote
    }
}
```

## split ##
```
  public java.lang.String[] split(java.lang.String, int);
  public java.lang.String[] split(java.lang.String);
```
example:
```
import java.util.*;

class StringMethods {
    public static void main(String[] args) {
        String s="amol mote";
        String[] ar= s.split(" ");
         System.out.println(Arrays.toString(ar));//[amol, mote]
    }
}
```









