package com.bridgelabz;
import com.bridgelabz.Utility;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class JSONWriter{
	
	public static void main(String[] args){
		//Utility class for Reading inputs
		Utility u = new Utility();
		JSONArray array = new JSONArray();
		System.out.println("Enter the Details");

		//for loop to rotate it
		for(int i=0;i<3;i++){
			JSONObject obj = 	new JSONObject();
			System.out.println("Enter Name");
			String name = u.inputString();
			System.out.println("Enter Weight");
			int num = u.inputNumber();
			System.out.println("Enter price/kgs");
			int price = u.inputNumber();
			obj.put("name",name);
			obj.put("weight(kg)",new Integer(num));
			obj.put("pricekg",new Integer(price));
			array.add(obj);
		}
		
		//writing the data to a file
		try{
			FileWriter fw = new FileWriter("test.json");
			fw.write(array.toJSONString());
			fw.flush();
			fw.close();
		}
		//handling the exception
		catch(IOException ioe){
			System.out.println(ioe);
		}
		//displaying the json data
		System.out.println(array);
	}
}
