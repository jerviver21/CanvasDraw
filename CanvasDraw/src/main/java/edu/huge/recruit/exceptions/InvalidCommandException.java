package edu.huge.recruit.exceptions;

/**
 * 
 * Is thrown when an invalid command in entered.
 * @author Jerson Viveros Aguirre - Huge Test Recruit
 *
 */
public class InvalidCommandException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidCommandException(String message){
		super(message); 
	}
	
	public InvalidCommandException(){
		super();
	}

}
