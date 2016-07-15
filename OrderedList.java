package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 11/07/2016
* Purpose:There is 1, 2, 5, 10, 50, 100, 500 and 1000 Rs Notes which can be returned by Vending Machine. Write a Program to calculate the minimum number of Notes as well as the Notes to be returned by the Vending Machine as a Change
*/
import com.bridgelabz.Utility;
public class OrderedList{
	static Utility u = new Utility();
	static Node<Integer> start,end;
	static int size;
	public static void main(String[] args){
		//display prompt and take input from user
		System.out.println("Enter the file name to read Numbers");
		String fileName = u.inputString();
		//reading the file data
		String fileData = u.readFile(fileName);
		//removing start and end spaces in the file data
		fileData = fileData.trim();
		//splitting the strings based on , and storing them in a array
		String[] snums = fileData.split(",");

		//converting string type to integer type
		int[] nums = u.convertStringtoInt(snums);
		//display the array
		u.print1DArray(nums);
		System.out.println();
	
		OrderedList ol = new OrderedList();
		for(int i=0;i<nums.length;i++){
			//adding elements to the linked list
			ol.add(nums[i]);
		}
    ol.display();
	}
	//display method to display elements
	public static void display(){		
      //storing the start value in temp  
		Node temp =start;
		//iterating the loop
    while( temp != null){
			//displaying  the  data in temp
    	System.out.print(temp.data+" -- ");
			//moving temp to next node
      temp=temp.link;
    }
    System.out.println(" ");    
	}
	//add method to add elements in ascending order
	public void add(int item){
		boolean check=false;
		Node<Integer> n = new Node<Integer>();
		n.setData(item);
		Node<Integer> temp,previous = start;
		temp = start;
		if (temp == null){
			size++;
			start = n;
		} 
		else{
			if(item < start.getData()){
				n.setLink(start);
				start = n;
			} 
			else{
				while (temp.getLink() != null){
					size++;
					if (item <= temp.getData() && item>=previous.getData()){
						//temp.setLink(n);
						//n.setLink(previous);
						n.setLink(previous.getLink());
						previous.setLink(n);
						check=true;
						break;
					}
					else{
					//temp=previous;
					//previous=previous.getLink();
					previous=temp;
				  temp=temp.getLink();
					}
				}
				if(check==false)
				//if(temp.getLink()==null)
				temp.setLink(n);
			}
		}
	}// end of add
}
