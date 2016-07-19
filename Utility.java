package com.bridgelabz;
import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.io.FileInputStream;
import java.util.Random;

public class Utility{
	BufferedReader br,brfile;	
	
	//constructor for intializing utility class object
	public Utility(){
	br = new BufferedReader(new InputStreamReader(System.in));
	}

	//reading String value
	public String inputString(){
		try{
			return br.readLine();	
		}
		catch(Exception e){
			System.out.println(e);		
		}	
		return "  ";
   }
	
	//reading number value	
	public int inputNumber(){
		try{
			return Integer.parseInt(br.readLine());	
		}
		catch(Exception e){
			System.out.println(e);
		}
		return 0;
	}
	
	//reading long value
	public long inputLong(){
		try{
			return Long.parseLong(br.readLine());		
		}
		catch(Exception e){	
			System.out.println(e);
		}
		return 0L;
	}
	//reading double value
	public double inputDouble(){
		try{
			return Double.parseDouble(br.readLine());	
		}
		catch(Exception e){
			System.out.println(e);	
		}
		return 0.0;	
	}

	//reading boolean value
	public boolean inputBoolean(){
		try{
			return Boolean.parseBoolean(br.readLine());	
		}
		catch(Exception e){
			System.out.println(e);
		}
		return false;
	}

	//creating arrey by reading values
	public int[] input1DArray(int arraysize){
		int[] array=new int[arraysize];
		for(int i = 0;i<arraysize;i++){
			array[i] = inputNumber();
		}	
		return array;
	}

	//printing 1-D array
	public void print1DArray(int[] array){
		System.out.print("[");
		for(int i = 0;i<array.length;i++){
			if(i == array.length-1)
				System.out.print(array[i]);
			else
				System.out.print(array[i]+", ");		
		}
		System.out.print("]");
	}

	//creating String array by reading values
	public String[] input1DStringArray(int arraysize){
		String[] words = new String[arraysize];	
		for(int i = 0;i<words.length;i++){
			System.out.print("Enter word"+(i+1));
			words[i] = inputString();
		}
	return words;
	}

	//printing 1-D String array
	public void print1DStringArray(String[] words){
		System.out.print("[");
		for(int i = 0;i<words.length;i++){
			if(i == words.length-1)
			System.out.print(words[i]);
			else
			System.out.print(words[i]+", ");		
		}
		System.out.print("]");	
	}	
	
	//reading file data and making it as a String
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

	//reading file data and making it as a string
	public String getFileText(String fileName){
		try{
			brfile = new BufferedReader(new FileReader(fileName));
			StringBuilder sb=new StringBuilder();
			String line = brfile.readLine();
			while(line!=null){
				sb.append(line);
				sb.append(System.lineSeparator());
				line = brfile.readLine();		
			}
			return sb.toString();
		 }
		catch(Exception exception){
			return null;
		}
	}	

	public int[] insertionSort(int[] list) {
  	for (int i = 1; i < list.length; i++) {
     	int next = list[i];
   		// find the insertion location while moving all larger element up
      int j = i;
      while (j > 0 && list[j - 1] > next) {
  	    list[j] = list[j - 1];
  	    j--;
      }
      // insert the element
      list[j] = next;
    }
        return list;
  }
/*
		//Insertion Sort for Numbers
		public int[] insertionSort(int[] array){
			//declaring a key variable
			int key;
			for(int i = 1;i < array.length;i++){
				//assign 1st position value to key
				key = array[i];
				//taking another variable for for loop
				int j = 0;
				for(j = i;j > 0;j--)
					if(array[j-1] < array[i])
						array[j] = array[j-1];
					else
						break;					
					array[j] = key;				
			}
			return array;
		}
*/
		//Insertion Sort for Strings
     public String[] insertionSort(String[] array)
     {
					//declaring a temporary variable as key
          String temp;
					// ar[i] is element to insert
          for(int i = 1; i < array.length; i++) 
          {
								//assignig array[i] value to temp
               temp = array[i];
							//declaring j value
               int j = 0;
               for(j = i; j > 0; j--)
										//comparing temp value with previous value
                    if(temp.compareTo(array[j - 1]) < 0)
												//if it is negative swapping
                         array[j] = array[j - 1];
                    else
                        break;
               array[j] = temp;
          }
				//returning array to the method
				return array;
     }

	//binary search for integers
	public int binarySearch(int[] numbers,int key){
		int start = 0;
		int end   = numbers.length-1;
		while(start <= end){
			int mid = (start+end)/2;
			if(key == numbers[mid]){
				return mid;			
			}
			else if(key < numbers[mid]){
				end = mid-1;			
			}
			else{
				start = mid+1;			
			}		
		}
		return -1;
	}

	//binary search for strings	
	public int binarySearch(String[] words,String key){
		int first = 0,last = words.length;
		while(first < last){
		int mid = (first+last)/2;
		if(key.compareTo(words[mid]) < 0){
			last = mid;
		}
		else if(key.compareTo(words[mid]) > 0){
			first = mid+1;
		}
		else{
		return mid;
		}
		}	
	return -1;
	}

	//bubbleSort for integers
	public int[] bubbleSort(int[] array){
		for(int i = 0;i < array.length;i++){
			for(int j = 0;j < array.length-i-1;j++){
				if(array[j] > array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;	
				}
			}

			//System.out.println();
			//print1DArray(array);		
		}	
		System.out.println();
		return array;
	}
	
	//bubblesort for strings
	public String[] bubbleSort(String[] words){
		for(int i = 0;i < words.length;i++){
			for(int j = 0;j < words.length-i-1;j++){
				if(words[j].compareTo(words[j+1])>0){
					String temp = words[j];
					words[j] = words[j+1];
					words[j+1] = temp; 				
				}			
			}		
		}	
		return words;
	}

	//writing node data to the file
	public  void writeNodeToFile(Node node){
		try{	
		String ndata = "";
		FileWriter fw = new FileWriter("UnOrdered.txt");
		while(node != null){
              	ndata += (String)node.getData();
		ndata +=" ";
              	node=node.link;
            	}
			fw.write(ndata);
			fw.close();
		}
		catch(Exception ioe){
			System.out.println(ioe);		
		}
		System.out.println("data written to file successfully");	
	}

	//converting string values into integer and then storing in array
	public int[] convertStringtoInt(String[] nStrings){
		int len = nStrings.length;
		int [] nums = new int[len];
		for(int i = 0;i < len;i++){
			nums[i] = Integer.parseInt(nStrings[i]);
			}
		return nums;
	}
}

