package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 01/07/2016
* Purpose:Given N distinct Coupon Numbers, how many random numbers do you need to generate distinct coupon number? This program simulates this random process.
*/
import com.bridgelabz.Utility;
import java.util.Random;
public class CouponNumber{
	static Utility u = new Utility();
	public static void main(String [] args){
		//calling randomNumber Method
		randomNumber();
	}	
	//random Number method to generate coupon Numbers
	public static void randomNumber(){
		//display prompt and take input from user
		System.out.println("Enter a number for N Distinct Coupon Numbers");
		int n = u.inputNumber();
		//random class to generate random numbers
		Random r = new Random();
		int ran = 0;
		//for loop for generating random numbers within range
		for(int i = 1;i <= n;++i){
		ran = r.nextInt(100);
		System.out.println("coupans are: "+ran);
		}
	}
}
