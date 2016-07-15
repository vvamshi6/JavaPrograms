package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 15/07/2016
* Purpose: JSON file having Inventory Details for Rice, Pulses and Wheats with properties name, weight, price per kg. 
*/
import com.bridgelabz.Utility;
import java.util.Scanner;
import org.json.simple.parser.JSONParser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
public class JSONReader{
	public static void main(String[] args)throws Exception{
		
		//creating JSonParser Object
		JSONParser parser = new JSONParser();
		
		try{     
			//Parse method will read data from the file and return the object
			JSONArray array = (JSONArray)parser.parse(new FileReader("DataManagement.json"));
			
			//calling iterator method on jsonArray object
			Iterator<JSONObject> iterator = array.iterator();

			//displaying the details of the inventory
			System.out.println("Name  wt(kg)  price/kg  Total");			
			while(iterator.hasNext()){
				JSONObject jsonObject = (JSONObject)iterator.next();						
				String name = (String) jsonObject.get("name");
  	  	System.out.print(name+"    ");

				//retriving weight value
				int weight = Integer.parseInt((String)jsonObject.get("weight(kg)"));
				System.out.print(weight+"      ");
				
				//retriving price values
				int priceperkg = Integer.parseInt((String)jsonObject.get("priceperkg"));
				System.out.print(priceperkg+ "        ");
				
				//printing total value				
				System.out.println(priceperkg*weight); 			
			}
    } 
		catch(FileNotFoundException e){
    	e.printStackTrace();
    } 
		catch(IOException e){
      e.printStackTrace();
    }
	}
}
