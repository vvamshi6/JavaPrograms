package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 04/07/2016
* Purpose:Write a Stopwatch Program for measuring the time that elapses between the start and end clicks
*/
import com.bridgelabz.Utility;
public class StopWatch{
	long starttime = 0,endtime = 0,elapsed;
	//starting stop watch
	public void start(){
		starttime = System.currentTimeMillis();		
	}	
	//stopping stop watch
	public void stop(){
		endtime = System.currentTimeMillis();
	}
	//calculating elapsed time
	public long elapsedTime(){
		elapsed = endtime-starttime;	
		return elapsed;
	}
	public static void main(String [] args){
		Utility u = new Utility();
		StopWatch s = new StopWatch();
		//starting stopwatch when enter 1
		System.out.println("Press 1 to start stopwatch");
		int number = u.inputNumber();
		while(number != 1){
			System.out.println("Enter 1 to start");
			number = u.inputNumber();	
		}
		s.start();
		System.out.println("Press 2 to stop stopwatch");
		//ending stopwatch when press 2
		int number2 = u.inputNumber();
		while(number2 != 2){	
			System.out.println("Enter 2 to stop");
			number2 = u.inputNumber();	
		}
		s.stop();	
		//elapsed time
		long elapsed = s.elapsedTime();
		System.out.println((s.elapsed/1000)+"secs");
	}
}
