package com.bridgelabz;
/*
* created by: Bridge Labz
* Date: 14/07/2016
* Purpose:Linked List class having add and display methods
*/
import java.io.*;
import com.bridgelabz.Utility;
public class OrderList{
	static Utility u = new Utility();
	Node<Integer> start,end;
	int size;
	//add method
	public void add(int val){
		Node<Integer> node = new Node<Integer>(val,null);    
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
	//method to insert elements in order
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
						n.setLink(previous.getLink());
						previous.setLink(n);
						check=true;
						break;
					}
					else{
						previous=temp;
				  	temp=temp.getLink();
					}
					if (item <= temp.getData() && item>=previous.getData()){
						n.setLink(previous.getLink());
						previous.setLink(n);
						check=true;
						break;
					}
				}
				if(check==false)
					temp.setLink(n);
				
			}
		}				
	}
	//display method for Order List
	public void display(){
		System.out.println();
    if(size == 0){
      System.out.print("empty\n");
      return;
    }    
    Node<Integer> node = start;        
		while (node.getLink()!= null){
    	System.out.print(node.getData()+ "->");
      node = node.getLink();
    }
		System.out.println(node.getData());
	}
	//Search method for ordered List
	public  boolean search(int srch){    
		Node<Integer> temp=start;
    if(temp==null)
       return false;
    while(temp!=null)
    {
      if(srch == (temp.getData()))
      {
        return true;
      }
      temp=temp.getLink();
    }
    return false;
  }
	
	public void delete(int data){
  	Node<Integer> temp=start;
  	Node<Integer> previous=start;
   	Node<Integer> head=null;
   	if(temp==null){
     System.out.println("data is not in list  so you can't remove it");
   	}
   	else{
    	while(data != (temp.getData())){
        previous=temp;
        temp=temp.getLink();
     	}
     	if(temp==start){
       	start=start.getLink();
       	temp.setLink(null);
     	}
     	else{   
        previous.setLink(temp.getLink());
       	temp.setLink(null);
     	}
   	}
	}
	public static void main(String[] args){
		OrderListUtility olu = new OrderListUtility();
		String fileData = olu.readFile("numbers.txt");
		fileData = fileData.trim();
		System.out.println(fileData);
		String[] numbers = fileData.split(",");
		int[] nums = u.convertStringtoInt(numbers);
		OrderList list = new OrderList();
		for(int i=0;i<nums.length;i++){
			list.insertInOrder(nums[i]);		
		}
		olu.display(list);
	}
}