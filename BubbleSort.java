package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 04/07/2016
* Purpose: Reads in integers prints them in sorted order using Bubble Sort
*/
import com.bridgelabz.Utility;
public class BubbleSort{
	public static void main(String[] args){
		Utility u = new Utility();		
		BubbleSort b = new BubbleSort();
		//display prompt and take input from user
		System.out.println("Enter how many elements you want to enter");
		int arraysize = u.inputNumber();
		int[] array = u.input1DArray(arraysize);
		//printing 1d array
		u.print1DArray(array);
		//calling bubble sort method which is in utility class
		int[] intSort = u.bubbleSort(array);
		u.print1DArray(intSort);
		System.out.println("Enter how many elements for string");
		int no = u.inputNumber();
		String[] words = u.input1DStringArray(no);
		String[] sorted = u.bubbleSort(words);
		u.print1DStringArray(sorted);	
	}	
}
