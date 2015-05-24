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
		

		
		
		/*Canvas canvas = new Canvas(20, 4);
		canvas.paint();
		
		Point p1 = new Point(1, 2);
		Point p2 = new Point(6, 2);
		canvas.drawElement('L', p1, p2);
		
		Point p3 = new Point(6, 3);
		Point p4 = new Point(6, 4);
		canvas.drawElement('L', p3, p4);
		
		Point p5 = new Point(16, 1);
		Point p6 = new Point(20, 3);
		canvas.drawElement('R', p5, p6);
		
		Point p7 = new Point(10, 3);
		canvas.fill(p7, 'o');
		
		System.out.println(" *********************** ");
		canvas.paint();
		
		System.out.println(" *********************** ");
		
		Point p8 = new Point(16, 1);
		canvas.fill(p8, 'm');
		canvas.paint();
		
		System.out.println(" *********************** ");
		
		Point p9 = new Point(1, 3);
		canvas.fill(p9, 'z');
		canvas.paint();
		
		System.out.println(" *********************** ");
		
		Point p10 = new Point(1, 2);
		canvas.fill(p10, 'u');
		canvas.paint();*/
		
		

	}
	
	/**
	 * Main thread controller of the application, reads commands and call the objects.
	 */
	public void executeApp(){
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
