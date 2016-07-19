package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 04/07/2016
* Purpose:takes a command-line argument N, asks you to think of a number between 0 and N-1, where N = 2^n, and always guesses the answer with n questions.
*/
import com.bridgelabz.Utility;
public class FindNumber{
	static int lower,upper,middle,range;
	static String option;
	public static void main(String [] args){
		Utility u = new Utility();
		FindNumber f = new FindNumber();
		System.out.println("Enter any number");
		int number = u.inputNumber();
		range = (int)Math.pow(2,number)-1;

		//asking user to assume any number within the range
		System.out.println("assume any number between 0 and"+range);
		int count = 0;lower = 0;upper = range;middle = (lower+upper)/2;
		option = null;

		//calling binary search method
		binarySearch(lower,upper,middle,count,option,number);
	}
	//method to find the number
	public static void binarySearch(int lower,int upper,int middle,int count,String option,int number){
		count = 0;
		Utility u = new Utility();
		//checking the number which is assumed is middle no or not
		System.out.println("Your Number is "+middle);
		System.out.println("If this is your number press yes else enter range high or low");		
		//asking the user given number is low or high
		option = u.inputString();
		do{
			//changing middle to low if it is high
			if(option.equals("high")){
				lower = middle++;			
				count = count+1;
			}
			//changig middle to upper it is low
			else if(option.equals("low")){
				upper = middle--;
				count = count+1;			
			}
			//displaying the no if it found and count
			else if(option.equals("yes")){
				System.out.println("Your Number is "+middle);
				System.out.println("No of times taken is"+(count+1));
				break;			
			}
			//checking number
			if(count < number){
				middle = (lower+upper)/2;
				System.out.println("Is this your Number"+middle);
				System.out.println("Enter yes if it is your number else enter range");
				option = u.inputString();	
			}
		}//if no not found
		while(lower <= upper);
			if(count > number){
				System.out.println("Number is not found");
			}
	}
}
