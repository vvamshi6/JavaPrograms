package com.bridgelabz;
import com.bridgelabz.Utility;
public class Node<T>{
	T data;
	Node link;
	public Node(){
		link=null;	
	}
	public Node(T data,Node link){
		this.data = data;
		this.link = link;
	}
	public void setLink(Node link){
		this.link = link;
	}
	public void setData(T data){
		this.data = data;
	}
	public Node getLink(){
		return link;	
	}
	public T getData(){
		return data;	
	}
}
