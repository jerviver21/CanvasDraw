package edu.huge.recruit.exceptions;

/**
 * 
 * Is thrown when two points don't match to draw a Rectangle.
 * @author Jerson Viveros Aguirre - Huge Test Recruit
 *
 */
public class PointsMatchForRectangleException extends Exception {
	
	private static final long serialVersionUID = 4L;

	public PointsMatchForRectangleException(String message){
		super(message); 
	}
	
	public PointsMatchForRectangleException(){
		super();
	}

}
