package edu.huge.recruit;

import edu.huge.recruit.canvas.Canvas;
import edu.huge.recruit.canvas.Point;




/**
 * Represents the main Thread of the program.
 * @author Jerson Viveros Aguirre - Huge Test Recruit
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Canvas canvas = new Canvas(20, 4);
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
		
		

	}

}
