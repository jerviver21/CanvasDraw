package edu.huge.recruit.canvas;

import java.util.HashMap;
import java.util.Map;

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
	private Map<Point, Character> pixels;
	
	public Canvas(int w, int h){
		this.width=w;
		this.height=h;
		pixels = new HashMap<Point, Character>();
	}
	
	/**
	 * This method paint the canvas in the console.
	 */
	public void paint(){
		
		Painter painter = new Painter();
		painter.paint(pixels.keySet(), width, height);
		
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
		int xIncrement = 0;
		if(end.getX() != start.getX()){
			xIncrement = (end.getX() - start.getX())/Math.abs(end.getX() - start.getX());
		}
		int yIncrement = 0;
		if(end.getY() != start.getY()){
			yIncrement = (end.getY() - start.getY())/Math.abs(end.getY() - start.getY());
		}
		
		start.setColor('x');
		end.setColor('x');
		
		pixels.put(start, 'x');
		pixels.put(end, 'x');
		
		int coordX = start.getX();
		while(coordX != end.getX()){
			coordX += xIncrement;
			Point p = new Point(coordX, start.getY());
			p.setColor('x');
			pixels.put(p, 'x');
		}
		
		int coordY = start.getY();
		while(coordY != end.getY()){
			coordY += yIncrement;
			Point p = new Point(end.getX(), coordY);
			p.setColor('x');
			pixels.put(p, 'x');
		}
	}
	
	public void drawRectangle(Point start, Point end){
		int xIncrement = 0;
		if(end.getX() != start.getX()){
			xIncrement = (end.getX() - start.getX())/Math.abs(end.getX() - start.getX());
		}
		int yIncrement = 0;
		if(end.getY() != start.getY()){
			yIncrement = (end.getY() - start.getY())/Math.abs(end.getY() - start.getY());
		}
		
		start.setColor('x');
		end.setColor('x');
		
		pixels.put(start, 'x');
		pixels.put(end, 'x');
		
		int coordX = start.getX();
		while(coordX != end.getX()){
			coordX += xIncrement;
			Point p1 = new Point(coordX, start.getY());
			p1.setColor('x');
			pixels.put(p1, 'x');
			Point p2 = new Point(coordX, end.getY());
			p2.setColor('x');
			pixels.put(p2, 'x');
		}
		
		int coordY = start.getY();
		while(coordY != end.getY()){
			coordY += yIncrement;
			Point p1 = new Point(start.getX(), coordY);
			p1.setColor('x');
			pixels.put(p1, 'x');
			Point p2 = new Point(end.getX(), coordY);
			p2.setColor('x');
			pixels.put(p2, 'x');
		}
	}
	
	
	public void fill(Point p, Character color){
		Character oldColor = pixels.get(p);
		p.setColor(color);
		pixels.put(p, color);
		fillColor(oldColor, color, p);
	}
	
	public void fillColor(Character oldColor, Character newColor, Point p){
		Point pright = new Point(p.getX()+1, p.getY());
		Point pleft = new Point(p.getX()-1, p.getY());
		Point pup = new Point(p.getX(), p.getY()+1);
		Point pdown = new Point(p.getX(), p.getY()-1);
		
		if(pright.getX() <= width && pixels.get(pright) == oldColor){
			pright.setColor(newColor);
			pixels.put(pright, newColor);
			fillColor(oldColor, newColor, pright);
		}
		
		if(pleft.getX() > 0 && pixels.get(pleft) == oldColor){
			pleft.setColor(newColor);
			pixels.put(pleft, newColor);
			fillColor(oldColor, newColor, pleft);
		}
		
		if(pup.getY() <= height && pixels.get(pup) == oldColor){
			pup.setColor(newColor);
			pixels.put(pup, newColor);
			fillColor(oldColor, newColor, pup);
		}
		
		if(pdown.getY() > 0 && pixels.get(pdown) == oldColor){
			pdown.setColor(newColor);
			pixels.put(pdown, newColor);
			fillColor(oldColor, newColor, pdown);
		}
		
		
	}

}
