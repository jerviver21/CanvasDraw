package edu.huge.recruit.exceptions;

public class PointsMatchForLineException extends Exception {
	
	private static final long serialVersionUID = 3L;

	public PointsMatchForLineException(String message){
		super(message); 
	}
	
	public PointsMatchForLineException(){
		super();
	}

}
