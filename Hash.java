package com.bridgelabz;
import com.bridgelabz.Utility;
import java.util.Arrays;
public class Hash{
	LinkedList[] order = new LinkedList[11];
	public  Hash(){
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
      	order[rem] = new LinkedList();
        order[rem].add(nums[i]);
      }
      else
      	order [rem].add(nums[i]);
    }        
		//System.out.println(Arrays.toString(order[rem]));
		for(int i=0;i<11;i++){
			System.out.println("========================");
    	System.out.println(i+" ");
      if(order[i] !=null){
      	order[i].display();
      }
   	}
	}
	
	public static void main(String[] args){
		Hash h = new Hash();
	}
}	


