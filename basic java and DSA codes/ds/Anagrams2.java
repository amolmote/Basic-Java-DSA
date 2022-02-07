package ds;

import java.util.Arrays;
import java.util.Scanner;

public class Anagrams2 
{

	
	public void isAnagram(String str1, String str2)
	{
		if(str1.compareTo(str2)==0)
		{
			System.out.println("The given strings are Anagrams");
		}
		else
		{
			char[] ch1=str1.toLowerCase().toCharArray();
			char[] ch2=str2.toLowerCase().toCharArray();
			Arrays.sort(ch1);
			Arrays.sort(ch2);
			
			boolean status=Arrays.equals(ch1,ch2);
			
			if(status==true)
			{
				System.out.println("the given strings are anagram");
			}
			else
			{
				System.out.println("the given string is not anagram");
			}
		}
	}
	public static void main(String[] args) 
	{
			Scanner sc=new Scanner(System.in);
			String str1,str2;
			System.out.println("enter String 1");
			str1=sc.next();
			System.out.println("enter String 2");
			str2=sc.next();
			Anagrams2 ans=new Anagrams2();
			ans.isAnagram(str1, str2);
		

	}

}
/*-- -------------------------
 * enter String 1
amol
enter String 2
loma
the given strings are anagram
-- -----------------------------
enter String 1
akshay
enter String 2
kaysha
the given strings are anagram
-- ---------------------------
enter String 1
Kjaal
enter String 2
kajal
the given strings are anagram
-- ----------------------------
enter String 1
ABCX
enter String 2
ABBC
the given string is not anagram
-- ------------------------------*/
