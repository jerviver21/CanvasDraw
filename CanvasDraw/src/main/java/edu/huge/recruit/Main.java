package edu.huge.recruit;

import org.apache.log4j.Logger;

import edu.huge.recruit.canvas.Canvas;
import edu.huge.recruit.exceptions.InvalidCommandException;
import edu.huge.recruit.exceptions.InvalidPointException;
import edu.huge.recruit.exceptions.PointsMatchForLineException;
import edu.huge.recruit.exceptions.PointsMatchForRectangleException;




/**
 * Represents the main Thread of the program.
 * @author Jerson Viveros Aguirre - Huge Test Recruit
 */
public class Main {
	private Logger logger = Logger.getLogger(Main.class);
	private  final char CREATE = 'C';
	private  final char LINE = 'L';
	private  final char RECTANGLE = 'R';
	private  final char FILL = 'B';
	private  final char QUIT = 'Q';
	
	Canvas canvas;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Main m = new Main();
		m.executeApp();
		

	}
	
	/**
	 * Main thread controller of the application, reads commands and call the objects.
	 */
	public void executeApp(){
		System.out.println("");
		System.out.println("");
		System.out.println("Welcome to the Drawer App. A product from  Huge Inc.");
		
		CommandReader  cReader = new CommandReader();
		boolean salir = false;
		while(!salir){
			try{
				Command command = cReader.readCommand();
				switch (command.getCommand()) {
					case CREATE:
						canvas = new Canvas(command.getWidth(), command.getHeight());
						break;
					case LINE:
						if(canvas != null){
							canvas.drawElement(command.getCommand(), command.getP1(), command.getP2());
						}else{
							System.out.println("You must create the canvas first, use the command C");
						}					
						break;
					case RECTANGLE:
						if(canvas != null){
							canvas.drawElement(command.getCommand(), command.getP1(), command.getP2());
						}else{
							System.out.println("You must create the canvas first, use the command C");
						}
						break;
					case FILL:
						if(canvas != null){
							canvas.fill( command.getP1(), command.getColor());
						}else{
							System.out.println("You must create the canvas first, use the command C");
						}
						break;
					case QUIT:
						salir = true;
						break;
					default:
						break;
				}
				if(canvas != null){
					canvas.paint();
				}
				
			}catch(InvalidCommandException e){
				System.out.println(e.getMessage());
			}catch(InvalidPointException e){
				System.out.println(e.getMessage());
			}catch(PointsMatchForLineException e){
				System.out.println(e.getMessage());
			}catch(PointsMatchForRectangleException e){
				System.out.println(e.getMessage());
			}catch(Exception e){
				logger.fatal("Unexpected error! ", e);
			}
		}
		System.out.println("Thanks for use this application! Huge  Inc.");
	}

}
