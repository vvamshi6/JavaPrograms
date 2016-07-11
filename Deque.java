package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 10/07/2016
*
* Purpose: A palindrome is a string that reads the same forward and backward, for example, radar, toot, and madam. We would like to construct an algorithm to input a string of characters and check whether it is a palindrome.
**/
import com.bridgelabz.Utility;
public class Deque{
	//Utility class Object
	static Utility u = new Utility();
	//Node type variable
	Node front,rear;
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
	public void insertAtFront(char val){
		Node nptr = new Node(val, null);
		size++;
		if(front == null){
			front = nptr;
			rear  = front;
		}	
		else{
			nptr.setLink(front);
			front = nptr;		
		}
	}
	//inserting the elements from rear end
	public void insertAtRear(char val){
		Node nptr = new Node(val,null);
		size++;
		if(rear == null){
			rear = nptr;
			front = rear;
		}
		else{
			rear.setLink(nptr);
			rear = nptr;
		}
	}
	//removing the elements from fron end
  public char removeAtFront(){
		if (isEmpty() )
	    System.out.println("Queue is empty");
      Node ptr = front;
      front = ptr.getLink();
      if (front == null)
      	rear = null;
			  size-- ;
		  return (char)ptr.getData();
	}
	//remove the elements from rear end	
  public char removeAtRear(){
		if (isEmpty())
			System.out.println("Queue is Empty");
			char ele = (char)rear.getData();
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
	//main method to call functions
	public static void main(String[] args){
		Deque d = new Deque();
		System.out.println("Enter String to check Palindrome");
		String str = u.inputString();
		for(int i = 0;i < str.length();i++){
			d.insertAtRear(str.charAt(i));		
		}
		System.out.println("Elements in DQueue left to right");
		d.display();
		String str2 = "";
		System.out.println("Removing elements from same end");
		for(int i = d.size;i > 0;i--){
			str2 += d.removeAtRear();
		}	
			System.out.println(str2);
		if(str.equals(str2)){
		System.out.println("String is Palindrome");
		}
		else{
		System.out.println("String is Not Palindrome");
		}
	}
	
}		
