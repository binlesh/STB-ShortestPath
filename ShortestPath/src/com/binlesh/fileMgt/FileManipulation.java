package com.binlesh.fileMgt;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/*The class that work with Map manipulations- reading & writing
 * @author -Lesego Mosweu
 * 
 * 
 */
public class FileManipulation {
	
	//path to the file
	private String filePath = "";
	
	public FileManipulation() {
		//initialize the variables - file source
		filePath = "map (2).txt"; 
	}
	
	
	
	
	/*
	 * Building maze/graph using 2 dimensional array
	 * 
	 * 
	 * 
	 */
	public String[][] readFromFileInto2DArray() throws IOException {
		
		int columns = getNumberOfColumns();
		int rows = getNumberOfRows();
		
		String [][] filecontents = new String[rows][columns];
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(new BufferedReader(new FileReader(filePath)));
		
		String [] strLine; 
		
		while(scanner.hasNextLine()) {
			
			for(int i=0; i<filecontents.length;i++) {
				
				 strLine = scanner.nextLine().trim().split("");
				 
				 for(int j=0; j<strLine.length; j++) {
					 
					 filecontents[i][j] = strLine[j];
					 
				 }
				
			}
			
		}
		
		
		 return filecontents;
	}
	
	
	/* 
	 * 
	 * 
	 * 
	 */
	public int getNumberOfColumns() throws IOException {
		
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		char[] characters = null;
		String strLine="";
		
		if(reader.readLine() !=null) {
			strLine = reader.readLine();
			strLine = strLine.trim();
		    characters = strLine.toCharArray();
		    
		}
		
		reader.close();
	
		return characters.length ;
	}
	
	public int getNumberOfRows() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		int lines =0;
		while(reader.readLine()!= null) {
				 lines ++;
		}
		 
		reader.close();
		 
		 return lines;
	}
	
}
