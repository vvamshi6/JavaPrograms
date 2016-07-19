package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 02/07/2016
* Purpose:A program with cubic running time. Read in N integers and counts the   number of triples that sum to exactly 0
*/
import com.bridgelabz.Utility;
public class SumofTriplets{
	public static void main(String[] args){
		Utility u = new Utility();
		SumofTriplets s = new SumofTriplets();

		//display prompt and take input from user
		System.out.println("Enter how many number of elements to store array");
		int number = u.inputNumber();

		//taking array values as input
		System.out.println("Enter elements into array");
		int[] array = u.input1DArray(number);

		//displaying array values
		u.print1DArray(array);
		System.out.println();

		//counting no of triplets
		int count = s.findTriplets(array);
		System.out.println(count+"Triplets are found");
	}
	//method to find the triplets
	public int findTriplets(int[] array){
		int count = 0,sum = 0;
		//checking three consecutive number
		System.out.println("Consecutive numbers");
		for(int i = 0;i < array.length;i++){
			for(int j = i+1;j < array.length;j++){
				for(int k = j+1;k < array.length;k++){
					//printing the consecutive numbers which sums to zero
					if(array[i] + array[j] + array[k] == 0){
					System.out.println(array[i]+" "+array[j]+" "+array[k]);
					count++;			
					}
				}
			}
		}
		//returning the count no of consecutives
		return count;
	}
}
