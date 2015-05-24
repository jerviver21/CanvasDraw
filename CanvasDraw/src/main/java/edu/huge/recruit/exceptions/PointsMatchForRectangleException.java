package edu.huge.recruit.exceptions;

public class PointsMatchForRectangleException extends Exception {
	
	private static final long serialVersionUID = 4L;

	public PointsMatchForRectangleException(String message){
		super(message); 
	}
	
	public PointsMatchForRectangleException(){
		super();
	}

}
