package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 02/07/2016
* Purpose:One string is an anagram of another if the second is simply a rearrangement of the first. For example, 'heart' and 'earth' are anagrams...
*/
import com.bridgelabz.Utility;
public class Anagram{
	public static void main(String [] args){
		Utility u = new Utility();
		Anagram a = new Anagram();

		//display prompt and take input from user
		System.out.println("Enter a String");
		String str1 = u.inputString();

		//take input from user and compare with previous string
		System.out.println("Enter another String to compare with another one");
		String str2 = u.inputString();

		//calling anagram method
		a.isAnagram(str1,str2);
		
	}

	public void isAnagram(String str1,String str2){
		str1 = str1.trim();
		str2 = str2.trim();		
		String word1 = str1.replaceAll("\\s","");
		String word2 = str2.replaceAll("\\s","");
		
		boolean status = true;
		StringBuilder sb1 = new StringBuilder(word2);
		if(str1.length() != str2.length()){
			status = false;		
		}
		else{
			char[] str1Array = word1.toCharArray();
			sb1 = new StringBuilder(word2);
			for(char c : str1Array){
				int index = sb1.indexOf(""+c);
				if(index !=-1){
					sb1 = sb1.deleteCharAt(index);				
				}
				else{
					status = false;
					break;
				}			
			}		
		}
		if(status == false){
			System.out.println("Both are not anagrams");
		}
		else{
			System.out.println("Both are Anagrams");		
		}
	}
}
