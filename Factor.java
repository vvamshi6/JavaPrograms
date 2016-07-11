package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 01/07/2016
* Purpose:Take input a number from user
*					and print prime factors	
**/
import com.bridgelabz.Utility;
public class Factor{
	public static void main(String [] args){
		Utility u = new Utility();
		Factor f = new Factor();
		//displaying prompt and taking input
		System.out.println("Enter a number to find factors");
		int number = u.inputNumber();
		//calling find factor method
		f.findfactor(number);
	}
	//method to find factor of a number using brute force
	public void findfactor(int number){
		//logic to find factor of a number
		for(int i = 2;i*i <= number;i++){
			while(number%i == 0){
				System.out.println(i);
				number = number/i;
			}	
   	}
		//displaying the number if it is greater than 1
		if(number > 1){
			System.out.println(number);		
		}
	}	
}
