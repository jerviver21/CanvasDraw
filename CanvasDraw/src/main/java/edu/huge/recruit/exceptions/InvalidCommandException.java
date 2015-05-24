package edu.huge.recruit.exceptions;

public class InvalidCommandException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidCommandException(String message){
		super(message); 
	}
	
	public InvalidCommandException(){
		super();
	}

}
