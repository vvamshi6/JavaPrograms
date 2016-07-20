package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 01/07/2016
* Purpose:Given N distinct Coupon Numbers, how many random numbers do you need to generate distinct coupon number? This program simulates this random process.
*/
import com.bridgelabz.Utility;
import java.util.Random;
import java.util.ArrayList;
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
		ArrayList<Integer> al = new ArrayList<Integer>();
		//for loop for generating random numbers within range
		int count = 0;
		for(int i = 0;i <= n;++i){
			ran = r.nextInt(50);
			if(al.isEmpty()){
				al.add(ran);
				count++;			
			}
			else{
				if(al.contains(ran)){
					count++;				
				}
				else
					al.add(ran);
					count++;			
			}
		}
		System.out.println(al);
		System.out.println(count);
	}
}
