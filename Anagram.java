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
	//method to tell whether it is anagram or not
	public void isAnagram(String str1,String str2){
		//removing all spaces in the strings
		String phrase1 = str1.replaceAll("\\s","");
		String phrase2 = str2.replaceAll("\\s","");
		//converting string values to char array	
		char[] word1 = phrase1.toCharArray();
		char[] word2 = phrase2.toCharArray();	
		int count1 = 0,count2 = 0;	
		//checking both lengths are equal or not if not they are not anagrams
		if(phrase1.length() != phrase2.length()){
			System.out.println("Two words are not anagrams");	
		}
		//counting their sum based on ascii values
		else{
			for(int i = 0;i < word1.length;i++){
				count1 = count1 + word1[i];
				count2 = count2 + word2[i];
			}
			//if their count is equal they are anagrams
			if(count1 == count2){
				System.out.println("Two words are anagrams");
			}
			else{
				System.out.println("Two words are not anagrams");	
			}
		}
	}
}
