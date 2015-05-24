package edu.huge.recruit.exceptions;

/**
 * This class represent an exception when the user enter a point out of the canvas.
 * @author Jerson Viveros Aguirre - Huge Test Recruit
 */
public class InvalidPointException extends Exception {
	
	private static final long serialVersionUID = 2L;

	public InvalidPointException(String message){
		super(message); 
	}
	
	public InvalidPointException(){
		super();
	}

}
