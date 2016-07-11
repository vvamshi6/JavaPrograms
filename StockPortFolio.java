package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 02/07/2016
* Purpose:Stock port folio class
*/
import com.bridgelabz.Utility;
public class StockPortFolio{
	Utility u = new Utility();
	String shareName;int noOfShares;double sharePrice,totalValue;
	
	//stock portfolio object holding stock info
	public StockPortFolio(){
		System.out.println("Enter stock name");
		shareName = u.inputString();
		System.out.println("Enter NoOf Shares");
		noOfShares = u.inputNumber();
		System.out.println("Enter Share price");
		sharePrice = u.inputDouble();
		totalValue = noOfShares*sharePrice;
	}
	//displaying stock report
	public void displayStockReport(){
		System.out.println("----------------------------------------------------");
		System.out.println("ShareName|   noOfShares | sharePrice | totalValue|  ");
		System.out.println(shareName+"    |"+noOfShares+"              |"+sharePrice+"         |"+totalValue);	
		System.out.println("----------------------------------------------------");
	}
	//reading data from a file
	public void stocks(){
		System.out.println("Enter file name");
		String file = u.inputString();
		String stoc = u.getFileText(file);
		System.out.println(stoc);	
	}
}


