package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 01/07/2016
* Purpose:Taking user input and displaying it a leap year or not?
**/
import com.bridgelabz.Utility;
class LeapYear{
	public static void main(String [] args){
		Utility u = new Utility();
		LeapYear l = new LeapYear();	
		System.out.println("Input Year No");
		int year = u.inputNumber();
		//calling leap year method
		l.leapYear(year);
	}
	//leap year method
	public void leapYear(int year){
		int count = 0,no = year;
		//logic to count no of digits
		while(no > 0){
			no = no / 10;
			count++;
		}
		//checking number contains 4 digits or not?
		if(count < 4 || count > 4){
			System.out.println("year should be 4 digits only");
		}
		//printing leapyer or not
		else{
			if(year % 4 == 0 || year % 400 == 0 && year % 100 != 0)
			System.out.println("Leap Year");
			else
			System.out.println("Not a Leap Year");
		}
	}	

}
