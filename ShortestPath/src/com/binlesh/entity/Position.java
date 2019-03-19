package com.binlesh.entity;

public class Position {
	
	
	 public int row, column;
	
	
	public Position(int row, int column) {
		
		
		this.row = row;
		this.column = column;
		
		
	}


	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}

	//gets the column point of the position
	public int getColumn() {
		return column;
	}


	public void setColumn(int column) {
		this.column = column;
	}
	
}
