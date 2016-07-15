package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 09/07/2016
* Purpose: Read a List of Numbers from a file and arrange it ascending Order in a Linked List. Take user input for a number, if found then pop the number out of the list else insert the number in appropriate position
*/
import com.bridgelabz.Utility;
public class UnOrderedList{
	static Utility u = new Utility();
	static Node<String> start,end;
	static int size;
	public static void main(String[] args){
		//display prompt and take user input
		System.out.println("Enter the file Name to read text");
		String fileName = u.inputString();
		String fileData = u.readFile(fileName);
		fileData = fileData.trim();
		String[] words = fileData.split(" ");
		u.print1DStringArray(words);
		
		//adding words to linked list
		for(int i = 0;i < words.length;i++){
			add(words[i]);
		}
		
		//display the linked list
		display();
		
		//taking a word from user to search in the list
		System.out.println("Enter a word to search in the list");
		String word = u.inputString();
		boolean option = search(word);
		
		//if the word finds then we delete it
		if(option){
			delete(word);		
		}
		//else we add that word to the list
		else{
			add(word);		
		}		
		display();
		u.writeNodeToFile(start);
	}
	
	//add method to add linked list
	public static void add(String val){
		Node<String> nptr = new Node<String>(val,null);    
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

	//method to find out the size of the linked list		    
	public int getSize(){
  	return size;
  }

	//method to display the linked list    
	public static void display(){
		System.out.println();
  	System.out.print("Single Linked List\n");
    if(size == 0){
      System.out.print("empty\n");
      return;
    }    
    if (start.getLink() == null){
    	System.out.println(start.getData() );
      return;
    }
    Node<String> ptr = start;        
		System.out.print(start.getData()+ "->");
    ptr = start.getLink();
    while (ptr.getLink() != null){
    	System.out.print(ptr.getData()+ "->");
      ptr = ptr.getLink();
    }
    System.out.print(ptr.getData()+ "\n");
	}
	
	//method to search
	public static boolean search(String value){
    Node<String> temp=start;
    if(temp==null)
       return false;
    while(temp!=null)
    {
      if(value.equals(temp.getData()))
      {
        return true;
      }
      temp=temp.getLink();
    }
    return false;
  }

	//method to delete
	public static void delete(String data){
  	Node<String> temp = start;
  	Node<String> previous = start;
   	Node<String> head = null;
   	if(temp == null){
     System.out.println("List is empty");
   	}
   	else{
    	while(!data.equals(temp.getData())){
        previous = temp; 
        temp = temp.getLink();
     	}
     	if(temp == start){
       	start = start.getLink();
       	temp.setLink(null);
     	}
     	else{   
        previous.setLink(temp.getLink());
       	temp.setLink(null);
     	}
   	}
	}
}
