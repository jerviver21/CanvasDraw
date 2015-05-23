package edu.huge.recruit.exceptions;

/**
 * This class represent an exception when the user enter a point out of the canvas.
 * @author Jerson Viveros Aguirre - Huge Test Recruit
 */
public class PointOutOfCanvasException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public PointOutOfCanvasException(String message){
		super(message); 
	}
	
	public PointOutOfCanvasException(){
		super();
	}

}
