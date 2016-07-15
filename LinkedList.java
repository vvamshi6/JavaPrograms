package com.bridgelabz;
/*
* created by: Bridge Labz
* Date: 14/07/2016
* Purpose:Linked List class having add and display methods
*/
import com.bridgelabz.Utility;
public class LinkedList{
	Utility u = new Utility();
	Node<Integer> start,end;
	int size;
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
	public void display(){
		System.out.println();
    if(size == 0){
      System.out.print("empty\n");
      return;
    }    
    if (start.getLink() == null){
    	System.out.println(start.getData() );
      return;
    }
    Node<Integer> ptr = start;        
		System.out.print(start.getData()+ "->");
    ptr = start.getLink();
    while (ptr.getLink() != null){
    	System.out.print(ptr.getData()+ "->");
      ptr = ptr.getLink();
    }
    System.out.print(ptr.getData()+ "\n");
	}
	
}
