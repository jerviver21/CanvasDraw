package edu.huge.recruit.exceptions;

/**
 * 
 * Is thrown when two points don't match to draw a line
 * @author Jerson Viveros Aguirre - Huge Test Recruit
 *
 */
public class PointsMatchForLineException extends Exception {
	
	private static final long serialVersionUID = 3L;

	public PointsMatchForLineException(String message){
		super(message); 
	}
	
	public PointsMatchForLineException(){
		super();
	}

}
