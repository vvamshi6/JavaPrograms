package com.bridgelabz;
/*
* created by: Bridge Labz
* Date: 14/07/2016
* Purpose:Linked List class having add and display methods
*/
import com.bridgelabz.Utility;
public class OrderList{
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
	}// end of add
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
}
