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
	public void insertInOrder(int item){
		boolean check=false;
		Node<Integer> n = new Node<Integer>();
		n.setData(item);
		Node<Integer> temp,previous = start;
		Node<Integer> temp1 =start;
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
	}//end of insertInOrder()
	public void display(){
		System.out.println();
    if(size == 0){
      System.out.print("empty\n");
      return;
    }    
    Node<Integer> ptr = start;        
		while (ptr!= null){
    	System.out.print(ptr.getData()+ "->");
      ptr = ptr.getLink();

    }
					System.out.println();
   // System.out.print(ptr.getData()+ "\n");
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
	public static void main(String[] args){
		String fileData = u.readFile("numbers");
		fileData = fileData.trim();
		String[] numbers = fileData.split(",");
		int[] nums = u.convertStringtoInt(numbers);
		OrderList list = new OrderList();
		for(int i=0;i<nums.length;i++){
			list.insertInOrder(nums[i]);		
		}
		System.out.println("Choose the Option You want to perform on linked list");
		System.out.println("1.Display");
		System.out.println("2.Add");
		System.out.println("3.Delete");
		System.out.println("4.Search");
		
		int no;		
		System.out.println("Enter your option");
		int num = u.inputNumber();
		list.display();
		switch(num){
			case 1:
						System.out.println("Elements in Linked List");
							list.display();
						break;
			case 2:
						System.out.println("Enter the element u want to add");
						no = u.inputNumber();
						list.insertInOrder(no);
						list.display();
						break;
			case 3:
						System.out.println("Enter the no u want to delete");
						no = u.inputNumber();
						list.delete(no);
						list.display();
						break;
			case 4:
						System.out.println("Enter the no u want to find");
						no = u.inputNumber();
						boolean option = list.search(no);
						if(option)
							list.delete(no);
						else
							list.insertInOrder(no);
						list.display();
						break;
			default :
								System.out.println("option is 1 to 4");
								break;
		}

	}
	public void writeNodeToFile(Node<Integer> node){
		try{	
			FileWriter fw = new FileWriter("Ordered.txt");
			while(node != null){
      	Integer ndata = (Integer)node.getData();
				fw.write(ndata);
				fw.write(",");			
			}
			fw.close();
		}
		catch(Exception ioe){
			System.out.println(ioe);		
		}
		System.out.println("data written to file successfully");	
	}

}
