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
	public static Position endPosition;
	
	public  String mapPath[][];
	

	
	public ShortestPath() throws IOException {
		
		FileManipulation fileMan = new FileManipulation();
		
		String mapPath[][]= fileMan.readFromFileInto2DArray();
		
	}
	
	
	
	
	
	
	
	public static void main(String [] args) throws IOException {
		FileManipulation fileMan = new FileManipulation();
		ShortestPath p =new ShortestPath();
		p.mapPath = fileMan.readFromFileInto2DArray();
		
		
		
		Map <Integer, Integer> startindex = getIndexForStart(p.getMap());
		
		//System.out.println(Arrays.asList(startindex));
		
		//displayContents(filecontents);
		
		computeTheShortestPath(p.getMap());

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
	
	
	public static void computeTheShortestPath(String [][] filecontents) {
	
		System.out.println();
		System.out.println("Determining the shotest path");
		System.out.println();

		System.out.println("Start position-(S): "+ getIndexForStart(filecontents));
		System.out.println("End position-(E): "+ getIndexForEnd(filecontents));
		
		
		for(int row= startPosition.getRow(); row<filecontents.length; row++) {
			
			for(int column=startPosition.getColumn();column<filecontents[row].length; column++ ) {
				
				System.out.println(filecontents[row][column]);
				
				if(filecontents[row][column].equals(WALL)) { // testing if the position is a wall 
					
					//filecontents[row][column] = String.valueOf(visited);
					
				}else if(filecontents[row][column].equals(CLEAR_PATH)) {
					
					filecontents[row][column] =  String.valueOf(visited);
					//displayContents(filecontents);
					
					//return;
				}
				
				
				
				
			}
			
			System.out.println();
		}
		
		//Edge e ;
		
		displayContents(filecontents);
		
		
		
	}
	
	/*
	 * Method - marks the position as visited
	 * @param - row and column values
	 * 
	 */
	
	public void setAsVisited(int row, int column) {
		mapPath[row][column] = String.valueOf(VISITED);
	}
	
	
	
	/*
	 * Method - checks if the certain position is a WALL
	 * @param - row and column values
	 * 
	 */
	public boolean isAWall(int row, int column) {
		return mapPath[row][column].equals(WALL);
		
	}
	
	
	/*
	 * Method - checks if the certain position has been visited
	 * @param - row and column values
	 * 
	 */
	public boolean isVisited(int row, int column) {
		
		return mapPath[row][column].equals(String.valueOf(VISITED));
		
	}
	
	
	/*
	 * Method - gets the position of "E" in the map
	 * @param -
	 * 
	 */
	public  static Map<Integer, Integer>   getIndexForEnd(String [][] filecontents) {
		Map <Integer, Integer> startIndex = new HashMap<Integer,Integer>();
		
		for(int row=0; row<filecontents.length;row++) {
			
			for(int column =0; column <filecontents[row].length; column++) {
				
				if(filecontents[row][column].equals(END)) {
					
					endPosition = new Position(row, column);
					startIndex.put(row, column);
				}
				
			}
		}
		
		return startIndex;
		
}
	
	
	
	
	public static void displayContents(String [][] filecontents) {
		for(int i=0; i<filecontents.length;i++) {
			for(int j=0; j<filecontents[i].length; j++) {
				System.out.print(filecontents[i][j]);
			}
			System.out.println();
		}
	}
	
	public String[][] getMap(){
		
		return mapPath;
	}
	
	
	
	public void initiazeTheMap() throws IOException {
		FileManipulation fileMan = new FileManipulation();
		String mapPath[][]= fileMan.readFromFileInto2DArray();
	}
	
	
	
}
