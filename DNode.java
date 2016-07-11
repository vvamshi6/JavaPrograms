package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 06/07/2016
* Purpose:Node class
*/
import com.bridgelabz.Utility;

public class Node<E>{
	//node variables
	private E data;
	public Node<E> right;
	public Node<E> left;
	//constructor for initializing node with its data
	public Node(E data){
		this.data=data;
		right=null;
		left=null;
	}
	//constructor for creating node object with out data
	public Node(){}
	//setter and getter methods for node data
	public void setData(E data){
		this.data=data;
	}
	public E getData(){
		return data;
	}
}

