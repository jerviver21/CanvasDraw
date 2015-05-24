package edu.huge.recruit.canvas;

import edu.huge.recruit.exceptions.InvalidPointException;
import edu.huge.recruit.exceptions.PointsMatchForLineException;
import edu.huge.recruit.exceptions.PointsMatchForRectangleException;

/**
 * 
 * This class validates that the information is in accordance with the specification
 * @author Jerson Viveros Aguirre - Huge Test Recruit
 *
 */
public class CanvasValidator {
	Canvas canvas;
	
	public CanvasValidator(Canvas canvas){
		this.canvas = canvas;
	}
	
	/**
	 * Validate if a point is valid, an inside the canvas
	 * @param point
	 * @return
	 * @throws InvalidPointException
	 */
	public boolean validatePoint(Point point)throws InvalidPointException{
		if(point.getX() < 1 || point.getX() > canvas.getWidth() || point.getY() < 0 || point.getY() > canvas.getHeight()){
			throw new InvalidPointException("The point is out of the canvas");
		}
		return true;
	}
	
	/**
	 * Although the application can draw lines between any two valid points, the specification says that 
	 * only is posible to draw horizontal or vertical lines.
	 * @param p1
	 * @param p2
	 * @return
	 * @throws PointsMatchForLineException
	 * @throws InvalidPointException
	 */
	public boolean validatePointsForLine(Point p1, Point p2)throws PointsMatchForLineException, InvalidPointException{
		validatePoint(p1);
		validatePoint(p2);
		if(p1.getX() != p2.getX() && p1.getY() != p2.getY()){
			throw new PointsMatchForLineException("The app only permits horizontal or vertical lines");
		}
		return true;
	}
	
	
	/**
	 * Although the application can draw rectangles between any two valid points, the specification says that 
	 * the first point must be the upper left corner and the second point must be the lower right corner
	 * @param p1
	 * @param p2
	 * @return
	 * @throws PointsMatchForRectangleException
	 * @throws InvalidPointException
	 */
	public boolean validatePointsForRectangle(Point p1, Point p2)throws PointsMatchForRectangleException, InvalidPointException{
		validatePoint(p1);
		validatePoint(p2);
		if(p1.getX() >= p2.getX() || p1.getY() >= p2.getY()){
			throw new PointsMatchForRectangleException("x1 y1 must indicate the upper left corner and x2 y2 must indicate the lower right corner");
		}
		return true;
	}
	
}
