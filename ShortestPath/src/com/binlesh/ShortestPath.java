package com.binlesh;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.binlesh.entity.Position;
import com.binlesh.fileMgt.FileManipulation;

public class ShortestPath {
	
	//constants 
	private final static String  WALL= "W";
	private final static String  CLEAR_PATH= ".";
	private final static String  START= "S";
	private final static String  END= "E";
	private final static char  PATH_TAKEN= '*';
	private final static char  VISITED= '"';
	
	private final static char visited='"';
	
	public static Position startPosition;
	
	
	
	
	public static void main(String [] args) throws IOException {
		
		
		
		FileManipulation fileMan = new FileManipulation();
		String [][] filecontents = fileMan.readFromFileInto2DArray();
		
		Map <Integer, Integer> startindex = getIndexForStart(filecontents);
		
		//System.out.println(Arrays.asList(startindex));
		
		//displayContents(filecontents);
		
		computeTheShortestPath(startindex,filecontents);

	} 
		
	
	
	public static  Map<Integer, Integer>   getIndexForStart(String [][] filecontents) {
		Map <Integer, Integer> startIndex = new HashMap<Integer,Integer>();
		
	
		
		for(int row=0; row<filecontents.length;row++) {
			
			for(int column =0; column <filecontents[row].length; column++) {
				
				if(filecontents[row][column].equals(START)) {
					
					startPosition = new Position(row, column);
					startIndex.put(row, column);
				}
				
			}
		}
		
		return startIndex;
		
}
	
	
	public static void computeTheShortestPath(Map<Integer, Integer>   start,String [][] filecontents) {
	
		System.out.println();
		System.out.println("Determining the shotest path");
		System.out.println();
		
		//System.out.println(start.size());
		
		for(int row= startPosition.getX(); row<filecontents.length; row++) {
			
			for(int column=startPosition.getY()+1;column<filecontents[row].length; column++ ) {
				
				
				if(filecontents[row][column].equals(CLEAR_PATH)) {
					
					//System.out.print("match found");
					
					filecontents[row][column] = String.valueOf(visited);
					
				}else if(filecontents[row][column].equals(WALL)) {
					
					System.out.print("Hit the wall"); 
					displayContents(filecontents);
					
					return;
				}
				
				
				
				
			}
			
			System.out.println();
		}
		
		//Edge e ;
		
		displayContents(filecontents);
		
		
		
	}
	
	public static void displayContents(String [][] filecontents) {
		System.out.println();
		System.out.println("Displaying th current contents in the 2D Array");
		System.out.println();
		
		for(int i=0; i<filecontents.length;i++) {
			for(int j=0; j<filecontents[i].length; j++) {
				System.out.print(filecontents[i][j]);
			}
			System.out.println();
		}
	}
}
