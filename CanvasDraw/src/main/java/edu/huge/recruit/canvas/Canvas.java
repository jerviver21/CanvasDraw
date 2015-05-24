package edu.huge.recruit.canvas;

import java.util.HashMap;
import java.util.Map;

import edu.huge.recruit.exceptions.InvalidPointException;
import edu.huge.recruit.exceptions.PointsMatchForLineException;
import edu.huge.recruit.exceptions.PointsMatchForRectangleException;

/**
 * This class represent the canvas itself
 * @author Jerson Viveros Aguirre - Huge Test Recruit
 */
public class Canvas {
	
	private int width;
	private int height;
	/**
	 * Each point in the canvas has its position and its own color
	 */
	private Map<Point, Character> pixels;
	
	
	public Canvas(int w, int h){
		this.setWidth(w);
		this.setHeight(h);
		setPixels(new HashMap<Point, Character>());
	}
	
	/**
	 * This method paint the canvas in the console.
	 */
	public void paint(){
		
		Painter painter = new Painter();
		painter.paint(getPixels().keySet(), getWidth(), getHeight());
		
	}
	
	/**
	 * Draws an element(line or rectangle) in the canvas
	 * @param type
	 * @param start
	 * @param end
	 * @throws PointsMatchForLineException
	 * @throws PointsMatchForRectangleException
	 * @throws InvalidPointException
	 */
	public void drawElement(char type, Point start, Point end)throws PointsMatchForLineException, PointsMatchForRectangleException, InvalidPointException{
		CanvasValidator validator = new CanvasValidator(this);
		switch (type) {
			case 'L':
				validator.validatePointsForLine(start, end);
				drawLine(start, end);
				break;
			case 'R':
				validator.validatePointsForRectangle(start, end);
				drawRectangle(start, end);
				break;	
			default:
				break;
		}
	
	}
	
	/**
	 * Draws a line in the canvas
	 * @param start
	 * @param end
	 * @throws PointsMatchForLineException
	 * @throws InvalidPointException
	 */
	private void drawLine(Point start, Point end)throws PointsMatchForLineException, InvalidPointException{
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
		
		getPixels().put(start, 'x');
		getPixels().put(end, 'x');
		
		int coordX = start.getX();
		while(coordX != end.getX()){
			coordX += xIncrement;
			Point p = new Point(coordX, start.getY());
			p.setColor('x');
			getPixels().put(p, 'x');
		}
		
		int coordY = start.getY();
		while(coordY != end.getY()){
			coordY += yIncrement;
			Point p = new Point(end.getX(), coordY);
			p.setColor('x');
			getPixels().put(p, 'x');
		}
	}
	
	/**
	 * Draws a rectangle in the canvas
	 * @param start
	 * @param end
	 * @throws PointsMatchForRectangleException
	 * @throws InvalidPointException
	 */
	private void drawRectangle(Point start, Point end)throws PointsMatchForRectangleException, InvalidPointException{
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
		
		getPixels().put(start, 'x');
		getPixels().put(end, 'x');
		
		int coordX = start.getX();
		while(coordX != end.getX()){
			coordX += xIncrement;
			Point p1 = new Point(coordX, start.getY());
			p1.setColor('x');
			getPixels().put(p1, 'x');
			Point p2 = new Point(coordX, end.getY());
			p2.setColor('x');
			getPixels().put(p2, 'x');
		}
		
		int coordY = start.getY();
		while(coordY != end.getY()){
			coordY += yIncrement;
			Point p1 = new Point(start.getX(), coordY);
			p1.setColor('x');
			getPixels().put(p1, 'x');
			Point p2 = new Point(end.getX(), coordY);
			p2.setColor('x');
			getPixels().put(p2, 'x');
		}
	}
	
	/**
	 * Execute the bucket fill action in the canvas
	 * @param p
	 * @param color
	 * @throws InvalidPointException
	 */
	public void fill(Point p, Character color)throws InvalidPointException{
		CanvasValidator validator = new CanvasValidator(this);
		validator.validatePoint(p);
		
		Character oldColor = getPixels().get(p);
		if(oldColor != null){
			getPixels().remove(p);
		}
		p.setColor(color);
		getPixels().put(p, color);
		fillColor(oldColor, color, p);
	}
	
	/**
	 * To execute the bucket fill action in the canvas, is needed a recursive method, this method 
	 * call itself to check which positions must be painted with the new color.
	 * @param oldColor
	 * @param newColor
	 * @param p
	 */
	private void fillColor(Character oldColor, Character newColor, Point p){
		Point pright = new Point(p.getX()+1, p.getY());
		Point pleft = new Point(p.getX()-1, p.getY());
		Point pup = new Point(p.getX(), p.getY()+1);
		Point pdown = new Point(p.getX(), p.getY()-1);
		
		if(pright.getX() <= getWidth() && getPixels().get(pright) == oldColor){
			pright.setColor(newColor);
			getPixels().remove(pright);
			getPixels().put(pright, newColor);
			fillColor(oldColor, newColor, pright);
		}
		
		if(pleft.getX() > 0 && getPixels().get(pleft) == oldColor){
			pleft.setColor(newColor);
			getPixels().remove(pleft);
			getPixels().put(pleft, newColor);
			fillColor(oldColor, newColor, pleft);
		}
		
		if(pup.getY() <= getHeight() && getPixels().get(pup) == oldColor){
			pup.setColor(newColor);
			getPixels().remove(pup);
			getPixels().put(pup, newColor);
			fillColor(oldColor, newColor, pup);
		}
		
		if(pdown.getY() > 0 && getPixels().get(pdown) == oldColor){
			pdown.setColor(newColor);
			getPixels().remove(pdown);
			getPixels().put(pdown, newColor);
			fillColor(oldColor, newColor, pdown);
		}
		
		
	}

	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Map<Point, Character> getPixels() {
		return pixels;
	}

	public void setPixels(Map<Point, Character> pixels) {
		this.pixels = pixels;
	}


}
