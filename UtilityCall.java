package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 13/07/2016
* Purpose:Calling methods of Utility Class
*/
import com.bridgelabz.Utility;
import com.bridgelabz.StopWatch;
public class UtilityCall{
	static Utility u = new Utility();
	public static void main(String[] args){		
		StopWatch sw = new StopWatch();
		System.out.println("Enter No Of Elements for String and Integer arrays");
		int size = u.inputNumber();

		//taking input from user for integers
		System.out.println("Enter the elements for integer array");
		int[] nums = u.input1DArray(size);
		u.print1DArray(nums);
			
		//taking input from user for String array
		System.out.println("Enter the words for String array");
		String[] words = u.input1DStringArray(size);
		u.print1DStringArray(words);
			
		//calling the methods Insertion sort
		sw.start();
		int[] sortedNums = u.insertionSort(nums);
		u.print1DArray(sortedNums);
		sw.stop();
		System.out.println("Time taken"+sw.elapsedTime()/1000+"secs");
		
		//calling insertion sort for strings
		sw.start();
		String[] sortedWords = u.insertionSort(words);
		u.print1DStringArray(sortedWords);
		sw.stop();
		System.out.println("Time taken"+sw.elapsedTime()/1000+"secs");

		//calling bubbleSort for Integers
		sw.start();
		sortedNums = u.bubbleSort(nums);
		u.print1DArray(sortedNums);
		sw.stop();
		System.out.println("Time taken"+sw.elapsedTime()/1000+"secs");

		//calling bubbleSort for Words
		sw.start();
	  sortedWords = u.bubbleSort(words);
		u.print1DStringArray(sortedWords);
		sw.stop();
		System.out.println("Time taken"+sw.elapsedTime()/1000+"secs");

		//calling binarySearch method for numbers
		sw.start();
		System.out.println("Enter the num u want to find");
		int key = u.inputNumber();
		int result = u.binarySearch(sortedNums,key);
		if(result >= 0)
			System.out.println("word is found "+result+" position");
		else
			System.out.println("WOrd is Not found");
		sw.stop();
		System.out.println("Time taken"+sw.elapsedTime()/1000+"secs");
		
		//calling binarysearch for Strings
		sw.start();
		System.out.println("Enter the word u want to find");
		String skey = u.inputString();
	  result = u.binarySearch(sortedWords,skey);
		if(result >= 0)
			System.out.println("word is found "+result+" position");
		else
			System.out.println("Word is not found");		
		sw.stop();
		System.out.println("Time taken"+sw.elapsedTime()/1000+"secs");
	}
}
