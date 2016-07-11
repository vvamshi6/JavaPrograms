package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 04/07/2016
* Purpose: Read in a list of words as input. Then prompt the user to enter a word to search the list. The program reports if the search word is found in the list.
*/
import com.bridgelabz.Utility;
public class BinarySearch{
	//creating utility object
	static Utility u = new Utility();
	public static void main(String [] args){
		BinarySearch bs = new BinarySearch();
		//number of words into the array
		System.out.println("Enter how many words you want to store");
		int number = u.inputNumber();
		String[] words1 = u.input1DStringArray(number);
		String[] words = u.insertionSort(words1);
		//displaying array
		u.print1DStringArray(words);
		//searching for the element we want	
		System.out.println("Enter the element you want to find");
		String key = u.inputString();		
		//searching the element by using binary search
		int value = u.binarySearch(words,key);
		System.out.println("Value is"+value);
		//if the value is found
		if(value >= 0){
			System.out.println("String is found at "+value+" position "+words[value]);
		}
		//if the value is not found
		else{
			System.out.println("String is not found");
		}
		System.out.println("Do you want to find Binary Search For Numbers also press yes or no");
		String option = u.inputString();
		if(option.equals("yes")){
			bs.binarySearchNumbers();		
		}
	}
	//binary search method for numbers
	public void binarySearchNumbers(){
		System.out.println("Enter how many elements u want for int array");
		int size = u.inputNumber();
		int[] nums = u.input1DArray(size);
		System.out.println("Enter the element you want to find");
		u.print1DArray(nums);
		int no = u.inputNumber();
		int position = u.binarySearch(nums,no);
		System.out.println("Position is "+position);
	}
}
