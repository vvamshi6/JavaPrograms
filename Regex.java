package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 16/07/2016
* Purpose: Read in the following message: Hello <<name>>, We have your full name as <<full name>> in our system. your contact number is 91-xxxxxxxxxx. Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016. 
*/
import com.bridgelabz.Utility;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
public class Regex{
	public static void main(String[] args){

		Utility u = new Utility();
		//taking user details
		System.out.println("Enter your SurName");
		String surName = u.inputString();

		System.out.println("Enter Full Name");
		String fullName = u.inputString(); 

		System.out.println("Enter your Mobile Number");
		long mobile = u.inputLong();
		
		String mobileNo = String.valueOf(mobile);

		//getting regular data  from file
		String message = u.readFile("Details.txt");
		
		//assigning based on regular expression		
		Pattern pattern = Pattern.compile("<<[a-z]{4}>>");
		Matcher matcher = pattern.matcher(message);
		message = matcher.replaceAll(surName);
		
		Pattern pattern2 = Pattern.compile("<<[a-z]{4}[ ][a-z]{4}>>");
		matcher = pattern2.matcher(message);
		message = matcher.replaceAll(fullName);
		
		Pattern p3 = Pattern.compile("[x]{10}");
		matcher = p3.matcher(message);
		message = matcher.replaceAll(mobileNo);
		
		//date class conversion to simple date format
		Date d  = new Date();
		//System.out.println(d);
		java.text.SimpleDateFormat date = new java.text.SimpleDateFormat("dd/MM/YYYY");
		String strDate = date.format(d);
		System.out.println(strDate);		
		boolean found = false;
		
		//adding date to the matcher
		Pattern p4 = Pattern.compile("\\d{2}\\/\\d{2}\\/\\d{4}");
		matcher = p4.matcher(message);
		message = matcher.replaceAll(strDate);
		
		//displaying the message to the user
		System.out.println(message);
	}	
}
