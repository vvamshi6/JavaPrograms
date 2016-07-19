package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 01/07/2016
* Purpose: Simulates a gambler who start with $stake and place fair $1 bets until he/she goes broke (i.e. has no money) or reach $goal. Keeps track of the number of times he/she wins and the number of bets he/she makes
**/
import com.bridgelabz.Utility;
public class Gambler{
	public static void main(String [] args){
		Utility u = new Utility();
		Gambler g = new Gambler();

		//display prompt and take input from user
		System.out.println("Enter your Stake");
		int stake = u.inputNumber();
		System.out.println("Enter your Goal");
		int goal = u.inputNumber();
		System.out.println("Enter How many times you want to play");
		double noOfTimes = u.inputDouble();

		//Calling method findGambler
		g.findGambler(stake,goal,noOfTimes);
	}
	//method to keeps track of number of times played and no of wins and losses
	public void findGambler(int stake,int goal,double noOfTimes){
		double noOfBets = 0,wins = 0,loss = 0;
		//finding no of time he/she plays the game
		for(int i = 1;i <= noOfTimes;i++){	
			int cash = stake;	
			//checking cash and goal
			while(cash < goal && cash > 0){		
				noOfBets++;
				double random = Math.random();
				//increasing cash when it is more
				if(random > 0.5){
				cash = cash + 1;		
				}
				//decreasing cash when random greater than 0.5
				else{
				cash = cash-1;		
				}
				//counting no of wins
				if(cash == goal){
				wins++;
				}		
			}
		}
		loss = noOfTimes - wins;
		System.out.println("No Of Wins:-"+wins);
		System.out.println("No Of loss:-"+loss);
		System.out.println("Percentage of wins:"+wins/noOfTimes*100);
		System.out.println("Percentage of loss"+loss/noOfTimes*100);
	}
}
