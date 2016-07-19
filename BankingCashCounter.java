package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 08/07/2016
* Purpose:Program which creates Banking Cash Counter where people come in to deposit Cash and withdraw Cash. Have an input panel to add people to Queue to either deposit or withdraw money and dequeue the people. Maintain the Cash Balance.
*/
import com.bridgelabz.Utility;
public class BankingCashCounter{
	static Utility u = new Utility();	
	//instance variables
	int[] queue;
	int front,rear,size,len;
	//constructor to initialize variables
	public BankingCashCounter(int n){
		size = n;
		len = 0;
		queue = new int[size];
		front = -1;
		rear = -1;	
	}
	//checking queue is empty or not
	public boolean isEmpty(){
		return front == -1;	
	}
	//checking whether queue is full or not
	public boolean isFull(){
		return front == 0 && rear == size-1;
	}
	//getting the size of the queue
	public int getSize(){
		return len;	
	}
	//displaying front element of the queue
	public int peek(){
		if(isEmpty()){
			System.out.println("Queue is Empty");
		}
		return queue[front];
	}
	//inserting elements into the queue
	public void insert(int i){
		if(rear == -1){
			front = 0;
			rear = 0;
			queue[rear] = i;		
		}
		else if(rear + 1 >= size){
			System.out.println("Queue is full u cannot enter into queue");
		}
		else if(rear + 1 < size){
			queue[rear++] = 0;
			len++;
		}
	}
	//removing element from the queue
	public int remove(){
		int ele=0;
		if(isEmpty()){
			System.out.println("Queue is Empty");			
		}
		else{
			len--;
			ele = queue[front];
			if(front == rear){
				front = -1;
				rear	= -1;			
			}		
			else{
				front++;
			}
		}
		return ele;
	}
	//displaying the queue
	public void display(){
		if(len == 0){
			System.out.println("Queue is Empty");		
		}
		else{
			for(int i = front;i <= rear;i++){
				System.out.println(queue[i]);
			}
		}	
	}
	public static void main(String[] args){
		System.out.println("Enter no of persons you want in the queue");
		int no = u.inputNumber();
		BankingCashCounter bcc = new BankingCashCounter(no);
		for(int i = 0;i < no;i++){
			bcc.insert(i);		
		}
		int bankCash = 10000;int deposit = 0;int withdraw=0; 
		do{
					System.out.println("1.Deposit Cash");
					System.out.println("2.WithDraw Cash");
					System.out.println("3.Display Queue");
					int a = u.inputNumber();
					switch(a){
					case 1:
						System.out.println("Enter how much money u want to deposit");
						deposit = u.inputNumber();
						bankCash = bankCash+deposit;
						System.out.println("Bank Amount"+bankCash);
						bcc.remove(); 
						break;
					case 2:
						System.out.println("Enter how much money u want to withdraw");
						withdraw = u.inputNumber();
						bankCash = bankCash-withdraw;
						System.out.println("Bank Amount"+bankCash);
						bcc.remove();
						break;
					case 3:
						bcc.display();
						break;
					}
		}while(bcc.front >= 0);
	}
}
