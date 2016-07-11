package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 01/07/2016
* Purpose:Taking a number from user and displaying power of 2 upto that number
**/
import com.bridgelabz.Utility;
public class PowerOf2{
	public static void main(String[] args){
		Utility u = new Utility();
		PowerOf2 p = new PowerOf2();
		//displaying and taking input from user
		System.out.println("Enter a number to print Power of 2's upto that number");
		int number = u.inputNumber();
		//calling power of 2 method
		p.powerof2(number);
	}
	public void powerof2(int number){
		//displaying power of 2 upto that number
		for(int i = 0;i <= number;i++){
			System.out.println(Math.pow(2,i));
		}
	}
}
