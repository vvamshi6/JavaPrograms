package com.bridgelabz;
import com.bridgelabz.Utility;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
class NodeUtility
{
	public void display(){
		UnOrderedList ul = new UnOrderedList();
		Utility u = new Utility();
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
				ul.display();
				break;
			case 2:
				System.out.println("Enter element to add to list");
				word1 = u.inputString();
				ul.add(word1);
				ul.display();
				break;
			case 3:
				ul.display();
				System.out.println("Enter the element u want to delete from list");
				word1 = u.inputString();
				option = ul.search(word1);
				if(option){
					ul.delete(word1);
					ul.display();
					System.out.println("Word is Deleted");
					
				}
				else{
					ul.display();
					System.out.println("word is not in the list");				
				}
				
				break;
			case 4:
				System.out.println("Enter a word to search in the list");
				String word = u.inputString();
				ul.display();
				option = ul.search(word);
				if(option){
					System.out.println("Word is found in the list and deleted");
					ul.delete(word);		
				}
				//else we add that word to the list
				else{
					System.out.println("Word is not found and added to the list");
					ul.add(word);		
				}		
				ul.display();
		
				break;
				default:
				System.out.println("Number should be 1 to 4");			
		}
	}
	//reading file data and making it as a String
 	public String readFile(String fileName){
		try{
			FileInputStream fis = new FileInputStream(fileName);
           		char ch;
           		String word="";
           		while (fis.available() > 0){
             		ch = (char) fis.read();
             		word = word+ch;
           		}
        	return word;
		}
		catch(IOException ioe){
			System.out.println(ioe);
		}
		return null;
	}
	public  void writeNodeToFile(Node node){
		try{	
		String ndata = "";
		FileWriter fw = new FileWriter("UnOrdered.txt");
		while(node != null){
              	ndata += (String)node.getData();
		ndata +=" ";
              	node=node.link;
            	}
			fw.write(ndata);
			fw.close();
		}
		catch(Exception ioe){
			System.out.println(ioe);		
		}
		System.out.println("data written to file successfully");	
	}
}