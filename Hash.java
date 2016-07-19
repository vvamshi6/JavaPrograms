package com.bridgelabz;
import com.bridgelabz.Utility;
import java.io.*;
public class Hash{
	static OrderList[] order = new OrderList[11];
	public Hash(){
		//Utility class Object
		Utility u = new Utility();

		//display prompt and taking input from user	
		System.out.println("Enter file Name to read text");
		String fileName = u.inputString();
		String fileData = u.readFile(fileName);
		fileData = fileData.trim();
		String[] numbers = fileData.split(",");

		//converting Strings to numbers
  	int[] nums = u.convertStringtoInt(numbers);
    for(int i=0; i<nums.length; i++){
    	int rem = nums[i]%11;
      if(order[rem]== null){
      	order[rem] = new OrderList();
        order[rem].insertInOrder(nums[i]);
      }
      else
      	order[rem].insertInOrder(nums[i]);
    }        
		
		for(int i=0;i<11;i++){
			System.out.println("========================");
    	System.out.println(i+" ");
      if(order[i] !=null){
      	order[i].display();
      }
   	}
	}
		
	public static void main(String[] args){
		Utility u = new Utility();		
		Hash h = new Hash();
		System.out.println("Enter a number to search");
		int num = u.inputNumber();
		int rem = num % 11;
		boolean option = false;
		if(order[rem] != null){
			OrderList temp = order[rem];
			option = temp.search(num);			
		}
		System.out.println(option);
		if(option){
			order[rem].delete(num);		
		}
		else{
			if(order[rem] == null){
				order[rem] = new OrderList();
				order[rem].insertInOrder(num);			
			}
			else{
				order[rem].insertInOrder(num);			
			}		
		}
		for(int i=0;i<11;i++){
			System.out.println("========================");
    	System.out.println(i+" ");
			if(order[rem] == null){
			order[rem] = null;
			}		
    	if(order[i] !=null){
				if(order[rem]!=null)
    	  	order[i].display();
					System.out.println();
    	}		
		}
		
	}
		
}	


