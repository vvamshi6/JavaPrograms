package com.bridgelabz;
/*
* created by: Bridge Labz
* Date 02/07/2016
* Purpose:A library for reading in 2D arrays of integers, doubles, or booleans from standard input and printing them out to standard output.
*/
import com.bridgelabz.Utility;
public class TwoDArray{
	static Utility u = new Utility();
	public static void main(String[] args){
		Utility u = new Utility();
		TwoDArray t = new TwoDArray();
		t.twoDArray();
	}
	//method to create twoDimensional array
	public void twoDArray(){
		//displaying prompt and taking input from user
		System.out.println("Enter input type you want");
		System.out.println("Enter 1 for Integer");
		System.out.println("Enter 2 for Double");
		System.out.println("Enter 3 for Boolean");
		//taking input for switch and case
		int number = u.inputNumber();
		switch(number){			
			//if user press 1 then take input for int array
			case 1:
				System.out.println("Enter no of rows you want");
				int p = u.inputNumber();
				System.out.println("Enter no of cols you want");
				int q = u.inputNumber();
				int[][] intarray=new int[p][q];
				System.out.println("Enter Numbers into Array");
				//logic to take input for 2d array		
				for(int i = 0;i < p;i++){
					for(int j = 0;j < q;j++){
						intarray[i][j] = u.inputNumber();
					}		
				}
				System.out.println("2-D Array is");
				//displaying 2d array
				for(int i = 0;i < p;i++){
					for(int j = 0;j < q;j++){
						if(j < p || j < q)
						System.out.print(intarray[i][j]+" ");						
					}
					System.out.println();		
				}
			break;
			//for double array
			case 2:
				System.out.println("Enter no of rows you want");
				p = u.inputNumber();
				System.out.println("Enter no of cols you want");
				q = u.inputNumber();
				double[][] doublearray = new double[p][q];
				System.out.println("Enter Numbers into Array");
				//logic to take inputs into 2d double array	
				for(int i = 0;i < p;i++){
					for(int j = 0;j < q;j++){
						doublearray[i][j] = u.inputDouble();
					}
				}
				System.out.println("2D DOuble Array is");
				//displaying 2d double array
				for(int i = 0;i < p;i++){
					for(int j = 0;j < q;j++){
						if(j < p || j < q)
						System.out.print(doublearray[i][j]+" ");
					}		
					System.out.println();
				}
			break;
			//for boolean array
			case 3:
				System.out.println("Enter no of rows you want");
				p = u.inputNumber();
				System.out.println("Enter no of cols you want");
				q = u.inputNumber();
				boolean[][] booleanarray = new boolean[p][q];
				System.out.println("Enter Boolean values into Array");
				//logic to take inputs to boolean 2d array	
				for(int i = 0;i < p;i++){
					for(int j = 0;j < q;j++){
						booleanarray[i][j] = u.inputBoolean();
					}
				}
				System.out.println("2D Boolean Array is");
			//logic to display boolean array
			for(int i = 0;i < p;i++){
				for(int j = 0;j < q;j++){
					if(j < p || j < q)
					System.out.print(booleanarray[i][j]+" ");
				}		
				System.out.println();
			}
			break;
			default:
			System.out.println("Enter no 1 to 3");
		}

	}
}
