package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 01/07/2016
*
* Purpose:Taking User Input and Replace String Template “Hello <<UserName>>, How are you?” 
**/
import com.bridgelabz.Utility;
public class Hello{
	public static void main(String[] args){
		Utility u = new Utility();
		Hello h = new Hello();
		//taking input from user
		System.out.println("Enter user Name");
		String name = u.inputString();
		if(name.length()<3){
			System.out.println("user name should have min 3 chars");
			name = u.inputString();		
		}

		//calling user name method
		h.userName(name);
		
  }
		//displaying prompt
	public void userName(String name){		
		System.out.println("Hello "+name+", How are you?");
	}

}
