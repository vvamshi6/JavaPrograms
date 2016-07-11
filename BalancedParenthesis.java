package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 02/07/2016
* Purpose:/*
* created by: Bridge Labz
* Date 08/07/2016
* Purpose:Stack Class to push open parenthesis “(“ and pop closed parenthesis “)”. At the End of the Expression if the Stack is Empty then the Arithmetic Expression is Balanced. Stack Class Methods are Stack(), push(), pop(), peak(), isEmpty(), size()
*/
import com.bridgelabz.Utility;
//stack class
public class BalancedParenthesis{
	static Utility u = new Utility();
	private int maxSize;
	char[] stack;
	int top;
	//constructor to initialize stack with given size
	public BalancedParenthesis(int size){
		maxSize = size;
		stack = new char[size];
		top   = -1; 
	}
	//pushing elements into stack
	public void push(char item){
		stack[++top] = item;
	}
	//pop element from stack
	public char pop(){
		char x = stack[top];
		top--;
		return x;	
	}
	//returning top element from the stack
	public char peek(){
		return stack[top];
	}
	//returning whether stack is empty or not
	public boolean isEmpty(){
		return (top == -1);
	}
	//returnig whether the stack is full or not
	public boolean isFull(){
		return (top == maxSize-1);
	}
	//main method
	public static void main(String[] args){
		boolean flag=checkParenthesis();
		if(flag){
			System.out.println("Expression is Balanced");		
		}
		else{
			System.out.println("Expression is not Balanced");		
		}
	}
	public static boolean checkParenthesis(){
		//displaying prompt and taking input from user
		System.out.println("Enter your expression");
		String expression = u.inputString();
		//creating stack of size expression
		int number = expression.length();
		//creating stack object
		BalancedParenthesis ms = new BalancedParenthesis(number);
		//checking condition and displaying stack values
		for(int i=0;i<expression.length();i++){
			char ch =expression.charAt(i);
			if(ch == '(' || ch == '[' || ch == '{'){
				ms.push(ch);
			}
			else if(ch == ')' ){
				if(ms.isEmpty())
					return false;
				if(ms.pop() != '(')
					return false;
			}
			else if(ch == ']' ){
				if(ms.isEmpty())
					return false;
				if(ms.pop() != '[')
					return false;
			}
			else if(ch == '}' ){
				if(ms.isEmpty())
					return false;
				if(ms.pop() != '{')
					return false;			
			}
		}
		return ms.isEmpty();
	}
}
