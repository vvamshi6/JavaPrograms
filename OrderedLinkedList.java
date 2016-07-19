package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 11/07/2016
* Purpose:Read a List of Numbers from a file and arrange it ascending Order in a Linked List. Take user input for a number, if found then pop the number out of the list else insert the number in appropriate position
*/
import com.bridgelabz.Utility;
public class OrderedLinkedList{
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
	public void add(int val){
		Node<Integer> nptr = new Node<Integer>(val,null);    
    size++ ;    
    if(start == null){
    	start = nptr;
      end = start;
    }
    else{
 	  	end.setLink(nptr);
     	end = nptr;
    }
  }	
	
	//add method to add elements in ascending order
	public void insertInOrder(int item){
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
	}
	
}
