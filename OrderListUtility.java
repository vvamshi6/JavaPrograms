package com.bridgelabz;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.IOException;
class OrderListUtility 
{
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
	public void display(OrderList list){
		Utility u = new Utility();
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
		writeNodeToFile(list.start);

	}
	public void writeNodeToFile(Node<Integer> node){
		try{	
		String data = "";
		Integer ndata;
		FileWriter fw = new FileWriter("Ordered.txt");
		fw.write("");		
		while(node.link != null){
              	ndata = (Integer)node.getData();
								data +=	ndata.toString();
								data +=",";
              	node=node.link;
            	}
			ndata = (Integer)node.getData();
			data +=	ndata.toString();
			fw.append(data);
			fw.close();
		}
		catch(Exception ioe){
			System.out.println(ioe);		
		}
		System.out.println("data written to file successfully");	
	}
}
