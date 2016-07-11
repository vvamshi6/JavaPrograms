package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 01/07/2016
* Purpose:Flip Coin and print percentage of Heads and Tails
**/
import com.bridgelabz.Utility;
class FlipCoin{
	public static void main(String[] args){
		Utility u = new Utility();
		FlipCoin f = new FlipCoin();
		//taking input from user
		System.out.println("Enter no of times to flipCoin");		
		int number = u.inputNumber();
		//calling flip coin method to display percentage
		f.flipCoin(number);	
	}
	//flip coin method for counting tails and heads
	public void flipCoin(int number){
		double noOfHeads = 0,noOfTails=0,noOfTosses=number;
		for(int i = 1;i< = number;i++){	
			double random = Math.random();
			//if it is less than 0.5 then tails
			if(random<0.5)
			noOfTails++;
			else
			noOfHeads++;
		}
		//displaying result to user
		System.out.println("Tails"+noOfTails+"   Heads"+noOfHeads);
		System.out.println("Percentage Of Tails"+(noOfTails/noOfTosses)*100);
		System.out.println("Percentage Of Heads"+(noOfHeads/noOfTosses)*100);
	}

}
