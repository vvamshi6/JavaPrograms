package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 01/07/2016
* Purpose:Take input from user and print nth Harmonic value 
**/
import com.bridgelabz.Utility;
public class Harmonic{
	public static void main(String[] args){
		Utility u = new Utility();
		Harmonic h = new Harmonic();
		//displaying and taking input from user
		System.out.println("Enter number to print Harmonic number");
		int number = u.inputNumber();
		//calling harmonic number method
		h.harmonicNumber(number);
	}
	//method to find harmonic number
	public void harmonicNumber(int number){
		double harmonic = 0;
		for(double i = 1;i <= number;i++){
			harmonic = harmonic+(1/i);
		}
		//displaying the harmonic number
		System.out.println(number+"th Harmonic Number is "+harmonic);
	}
}
