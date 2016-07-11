package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 02/07/2016
* Purpose:Write a program to read in Stock Names, Number of Share, Share Price. Print a Stock Report with total value of each Stock and the total value of Stock.
*/
import com.bridgelabz.Utility;
public class Stock{
	public static void main(String [] args){
		Utility u = new Utility();
		System.out.println("Enter no of stocks");
		//taking input from user
		int no = u.inputNumber();
		//creating object for StockPortFolio class
		com.bridgelabz.StockPortFolio sp[]=new com.bridgelabz.StockPortFolio[no];
		//taking stock values
		for(int i = 0;i < no;i++){
			System.out.println("Enter Stock"+(i+1)+"Details");
			sp[i] = new com.bridgelabz.StockPortFolio();
		}
		//calling display stock report
		for(int i = 0;i < sp.length;i++){
			sp[i].displayStockReport();
		}
	}
}
