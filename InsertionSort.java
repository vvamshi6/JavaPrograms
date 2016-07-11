package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 02/07/2016
* Purpose:Reads in strings from standard input and prints them in sorted order. Uses insertion sort.
*/
import com.bridgelabz.Utility;
public class InsertionSort{
	public static void main(String [] args){
		//creating utility class object
		Utility u=new Utility();
		InsertionSort is=new InsertionSort();
		//display prompt and take input from user
		System.out.println("Enter how many strings you want");
		int arraysize=u.inputNumber();
		//taking inputs from user to array
		String[] words=u.input1DStringArray(arraysize);
		//calling the method using insertion sort	
		String[] sorted=u.insertionSort(words);
		u.print1DStringArray(sorted);
		System.out.println("Enter the no of elements u want");
		int no = u.inputNumber();
		int[] numbers = u.input1DArray(no);
		u.print1DArray(numbers);
		int[] numsort = u.insertionSort(numbers);
		u.print1DArray(numsort);
	}
}
