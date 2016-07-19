package com.bridgelabz;
import com.bridgelabz.Utility;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
public class InventoryManager{
	public static void main(String[] args)throws ParseException{
		JSONParser parser = new JSONParser();
		try{
			JSONArray array = (JSONArray)parser.parse(new FileReader("test.json"));
			Iterator<JSONObject> iterator = array.iterator();
			Iterator<JSONObject> iterator1 = array.iterator();
			//displaying the details of the inventory

			System.out.println("Inventory details on all products");
			System.out.println("Name  wt(kg)  price/kg  Total");			
			while(iterator.hasNext()){
				JSONObject jsonObject = (JSONObject)iterator.next();

				String name = (String) jsonObject.get("name");
  	  	System.out.print(name+"    ");

				//retriving weight value
				Long weight = (Long)(jsonObject.get("weight(kg)"));
				System.out.print(weight+"      ");
				
				//retriving price values
				Long priceperkg = (Long)jsonObject.get("pricekg");
				System.out.print(priceperkg+ "        ");
				
				//printing total value				
				System.out.println(priceperkg*weight); 			
			}
			
			System.out.println("Json Objects");
			while(iterator1.hasNext()){
				JSONObject jsonObject = (JSONObject)iterator1.next();
				System.out.println(jsonObject.toString());			
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
