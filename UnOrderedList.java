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
		
		String fileData = u.readFile("vmk");
		fileData = fileData.trim();
		String[] words = fileData.split(" ");
		u.print1DStringArray(words);
		
		//adding words to linked list
		for(int i = 0;i < words.length;i++){
			add(words[i]);
		}
		
		boolean option;
		String word1;
			System.out.println();		
			System.out.println("1.Display");
			System.out.println("2.Add To LinkedList");
			System.out.println("3.Delete From LinkedList");
			System.out.println("4.Search From Linked List");
		System.out.println("Enter your option");
		int no = u.inputNumber();		
		switch(no){
			case 1:
				display();
				break;
			case 2:
				System.out.println("Enter element to add to list");
				word1 = u.inputString();
				add(word1);
				display();
				break;
			case 3:
				System.out.println("Enter the element u want to delete from list");
				word1 = u.inputString();
				option = search(word1);
				if(option){
					delete(word1);
					System.out.println("Word is Deleted");		
				}
				else{
					System.out.println("word is not in the list");				
				}
				
				break;
			case 4:
				System.out.println("Enter a word to search in the list");
				String word = u.inputString();
				option = search(word);
				if(option){
					delete(word);		
				}
				//else we add that word to the list
				else{
					add(word);		
				}		
				display();
		
				break;
				default:
				System.out.println("Number should be 1 to 4");			
		}

		u.writeNodeToFile(start);
	}
	
	//add method to add linked list
	public static void add(String val){
		Node<String> node = new Node<String>(val,null);    
    size++ ;    
    if(start == null){
    	start = node;
      end = start;
    }
    else{
 	  	end.setLink(node);
     	end = node;
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
	
	//search method
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

	//delete method
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
