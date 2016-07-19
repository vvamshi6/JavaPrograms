package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 12/07/2016
* Purpose: A palindrome is a string that reads the same forward and backward, for example, radar, toot, and madam. We would like to construct an algorithm to input a string of characters and check whether it is a palindrome.
**/
import com.bridgelabz.Utility;
public class Deque{
	//Utility class Object
	static Utility u = new Utility();
	//Node type variable
	Node<String> front,rear;
	int size;
	//intializing node variable
	public Deque(){
		front = null;
		rear  = null;
		size  = 0;
	}
	//checking the queue is empty or not
	public boolean isEmpty(){
		return front == null;
	}
	//getting the size of the queue
	public int getSize(){
		return size;
	}
	//inserting elements from front
	public void insertAtFront(String val){
		Node<String> node = new Node<String>(val, null);
		size++;
		if(front == null){
			front = node;
			rear  = front;
		}	
		else{
			node.setLink(front);
			front = node;		
		}
	}
	//inserting the elements from rear end
	public void insertAtRear(String val){
		Node<String> node = new Node<String>(val,null);
		size++;
		if(rear == null){
			rear = node;
			front = rear;
		}
		else{
			rear.setLink(node);
			rear = node;
		}
	}
	//removing the elements from fron end
  public String removeAtFront(){
		if (isEmpty() )
	    System.out.println("Queue is empty");
      Node<String> rnode = front;
      front = rnode.getLink();
      if (front == null)
      	rear = null;
			  size-- ;
		  return rnode.getData();
	}
	//remove the elements from rear end	
  public String removeAtRear(){
		if (isEmpty())
			System.out.println("Queue is Empty");
			String ele = rear.getData();
		  Node s = front;
	    Node t = front;
      while (s != rear){
        t = s;
        s = s.getLink();
      }
      rear = t;
      rear.setLink(null);
      size --;
      return ele;
  }
	//display the elements in the deque        
	public void display(){
  	System.out.print("\nDequeue = ");
      if (size == 0){
      	System.out.print("Empty\n");
				return ;
      }
		  Node ptr = front;
      while (ptr != rear.getLink()){
				System.out.print(ptr.getData()+" ");
        ptr = ptr.getLink();
        }
      System.out.println();        
  }

	public boolean isPalindrome(String str){
		Deque d = new Deque(); 
		for(int i = 0;i < str.length();i++){
			if(Character.isLetter(str.charAt(i))){
				d.insertAtRear(Character.toString(str.charAt(i)));
				size++;			
			}
		}
		//Deque d = new Deque();
		boolean check = true;
		int len = str.length();
		System.out.println("len"+len);
		//String frontChar = " ";String backChar = " ";
		
		if(len % 2 == 0){
			while(!d.isEmpty() && check){
				if(d.removeAtFront() != null && d.removeAtRear() != null){
					String frontChar = d.removeAtFront();
					String backChar = d.removeAtRear();
					if(!frontChar.equals(backChar)){
						return check = false;			
					}
				}	
				return check = true;		
			}
		}
		else{
			int index = 0;
			while((index < ((len - 1)/2)) && (check)){
				String frontChar = d.removeAtFront();
				String backChar = d.removeAtRear();
				if(!frontChar.equals(backChar)){
					return check = false;				
				}
				index++;			
			}				
		}	
		return check; 
	}	
	//main method to call functions
	public static void main(String[] args){
		Deque d1 = new Deque();
		String str2 = "";
		System.out.println("Removing elements from same end");
		//taking input from user and inserting them from rearEnd
		System.out.println("Enter String to check Palindrome");
		//String key = 
		String str = u.inputString();
	//	System.out.println("Elements in DQueue left to right");
		//d1.display();
		boolean option = d1.isPalindrome(str);
		if(option){
			System.out.println("String is Palindrome");		
		}
		else{
			System.out.println("String is not Palindrome");		
		}
	}
	
}		
