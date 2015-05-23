package edu.huge.recruit.canvas;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * This class represent the canvas itself
 * @author Jerson Viveros Aguirre - Huge Test Recruit
 */
public class Canvas {
	private Logger logger = Logger.getLogger(Canvas.class);
	private int width;
	private int height;
	/**
	 * Each point in the canvas has its position and its own color
	 */
	private Set<Point> pixels;
	
	public Canvas(int w, int h){
		this.width=w;
		this.height=h;
		pixels = new HashSet<Point>();
	}
	
	/**
	 * This method paint the canvas in the console.
	 */
	public void paint(){
		
		Painter painter = new Painter();
		painter.paint(pixels, width, height);
		
	}
	
	
	public void drawElement(char type, Point start, Point end){
		switch (type) {
			case 'L':
				drawLine(start, end);
				break;
			case 'R':
				drawRectangle(start, end);
				break;	
			default:
				break;
		}
	
	}
	
	public void drawLine(Point start, Point end){
		int xIncrement = (end.getX() - start.getX())/Math.abs(end.getX() - start.getX());
		int yIncrement = (end.getY() - start.getY())/Math.abs(end.getY() - start.getY());
		
		start.setColor('x');
		end.setColor('x');
		
		pixels.add(start);
		pixels.add(end);
		
		int coordX = start.getX();
		while(coordX != end.getX()){
			coordX += xIncrement;
			Point p = new Point(coordX, start.getY());
			p.setColor('x');
			pixels.add(p);
		}
		
		int coordY = start.getY();
		while(coordY != end.getY()){
			coordY += yIncrement;
			Point p = new Point(coordY, start.getX());
			p.setColor('x');
			pixels.add(p);
		}
	}
	
	public void drawRectangle(Point start, Point end){
		int xIncrement = (end.getX() - start.getX())/Math.abs(end.getX() - start.getX());
		int yIncrement = (end.getY() - start.getY())/Math.abs(end.getY() - start.getY());
		
		start.setColor('x');
		end.setColor('x');
		
		pixels.add(start);
		pixels.add(end);
		
		int coordX = start.getX();
		while(coordX != end.getX()){
			coordX += xIncrement;
			Point p1 = new Point(coordX, start.getY());
			p1.setColor('x');
			pixels.add(p1);
			Point p2 = new Point(coordX, end.getY());
			p2.setColor('x');
			pixels.add(p2);
		}
		
		int coordY = start.getY();
		while(coordY != end.getY()){
			coordY += yIncrement;
			Point p1 = new Point(coordY, start.getX());
			p1.setColor('x');
			pixels.add(p1);
			Point p2 = new Point(coordY, end.getX());
			p2.setColor('x');
			pixels.add(p2);
		}
	}
	

}
