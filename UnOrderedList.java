package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 06/07/2016
* Purpose:Read the Text from a file, split it into words and arrange it as Linked List. Take a user input to search a Word in the List. If the Word is not found then add it to the list, and if it found then remove the word from the List. In the end save the list into a file
*/

import com.bridgelabz.Utility;
public class UnOrderedList{
	//creating node type variables
	static Node start,prev,current;
	static Utility u=new Utility();
	static UnOrderedList uol=new UnOrderedList();	 
	//main method
	public static void main(String[] args){
		//READING FILE NAME FROM USER
		System.out.println("Enter file name to read text");
		String filename=u.inputString();
		//read data from file
		String  text   =u.readFile(filename);
		//Creating words by splitting based on space		
		String[] words=text.split(" ");
		//Displaying words
		uol.addWordsToLinkList(words);
		//printing the linked list
		uol.printLinkList(start);
		//finding the word
		System.out.println("Enter word u want to find");
		String word1=u.inputString();
		//calling the method		
		Boolean option=uol.findWordFromList(word1);
		System.out.println(option);
		//adding word to the list if it not found
		if(option==false){
			uol.addNode(word1);
		}
		//removing word from the node if it found
		if(option){
			uol.delete(word1);
			uol.printLinkList(start);		
		}
		//finding the size of the Node
		int len=uol.size();
		System.out.println("Length of the List is"+len);
		//writing data to file
		u.writeNodeToFile(start);
	}
	//putting words in List
	public void addWordsToLinkList(String[] words){
		//creating a node temp
		Node temp;
		Node last=new Node();
		for(int i=0;i<words.length;i++){
			//creating a temporary node and adding it to the temp
			temp=new Node(words[i]);
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
	//Print Link List
	public void printLinkList(Node last){
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
	//find word from the list (if words found then it return true else it return fasle)
	public Boolean findWordFromList(String key){
		String last;
		//if start is null then linked list is empty		
		if(start==null){
			return false;
		}
		// storing start node in prev and current
		else{		
			current=start;
			prev=start;
			//traversing through the linked list
			while(current.right!=null){
				//comparing node data with key
				if(current.getData().equals(key)){
				return true;
				}
				else{
					//changing node to next node
					prev=current;
					current=current.right;						
				}	
			}//retrieving last value in the linked list
				last=(String)current.getData();
				last=last.trim();
				if(last.equals(key)){
				return true;
				}			
			return false;	
		}
	
	}
//Adding node to the List
	public void addNode(String word){
		Node temp=new Node(word);
		//adding temp node to the start node if it is empty
		if(start==null){
			start=temp;
		}
		//storing start value
		else{
		prev=start;
		//traversing through the linked list
		while((prev.right)!=null){
			prev=prev.right;		
		}
		prev.right=temp;
		//printing linked list 
		printLinkList(start);
		}
	}
//size of the method
	public int size(){
		Node prev;int count=0;
		prev=start;
		//traversing through the linked list
		while(prev.right!=null){
		//counting the value
		count++;
		prev=prev.right;
		}
		return count;	
	}
//deleting node from the list
	public void delete(String key){
		//deleting the node if it is first
		if(start==prev)
			start=(prev.right);
		//deleting the node if it is last
		if((prev.right).right==null)
			prev.right=null;
		//deleting the other nodes
		else
			prev.right=(prev.right.right);
		}
}
