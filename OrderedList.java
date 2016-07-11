package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 04/07/2016
* Purpose:Read a List of Numbers from a file and arrange it ascending Order in a Linked List. Take user input for a number, if found then pop the number out of the list else insert the number in appropriate position
*/
import com.bridgelabz.Utility;
public class OrderedList{
	static Utility u=new Utility();
	static Node start,next;
	public static void main(String[] args){
		//display prompt and take input from user
		System.out.println("Enter file name to read text");
		String fName=u.inputString();
		//reading file data
		String fData=u.readFile(fName);
		//splitting the file data based on comma(,)
	 	fData=fData.trim();
		String[] words=fData.split(",");
		//calling method to convert strings to numbers
		int[] nums=u.convertStringtoInt(words);
		//display int array
		u.print1DArray(nums);
		//sorting numbers using sorting technique
		int[] sorted=u.bubbleSort(nums);
		//adding numbers to the linked list
		addNumbersToLinkedList(sorted);
		//printing linked list
		printLinkedList(start);
	}
	public static void addNumbersToLinkedList(int[] nums){
		Node temp;
		Node last=new Node();
		for(int i=0;i<nums.length;i++){
			//creating a temporary node and adding it to the temp
			temp=new Node(nums[i]);
			//adding the node to start if it is empty
			if(start==null){
				start=temp;
				last=start;
			}
			//adding temp node to last and moving last 
			else{
				last.right=temp;
				last=last.right;
			}
		}
	}
	public static void printLinkedList(Node last){
	//display message when link list is empty
		if(start==null)
			System.out.println("Link list is empty.");
		else{
	//travesing through the list and printing data
			last=start;
			while(last.right!=null){
				System.out.print(last.getData()+" ");
				last=last.right;
			}
			System.out.print(last.getData());
			System.out.println();
		}
	}
	
}
