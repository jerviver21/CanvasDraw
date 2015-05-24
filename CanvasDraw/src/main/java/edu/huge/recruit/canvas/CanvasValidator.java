package edu.huge.recruit.canvas;

import edu.huge.recruit.exceptions.InvalidPointException;
import edu.huge.recruit.exceptions.PointsMatchForLineException;
import edu.huge.recruit.exceptions.PointsMatchForRectangleException;

public class CanvasValidator {
	Canvas canvas;
	
	public CanvasValidator(Canvas canvas){
		this.canvas = canvas;
	}
	

	public boolean validatePoint(Point point)throws InvalidPointException{
		if(point.getX() < 1 || point.getX() > canvas.getWidth() || point.getY() < 0 || point.getY() > canvas.getHeight()){
			throw new InvalidPointException("The point is out of the canvas");
		}
		return true;
	}
	
	public boolean validatePointsForLine(Point p1, Point p2)throws PointsMatchForLineException, InvalidPointException{
		validatePoint(p1);
		validatePoint(p2);
		if(p1.getX() != p2.getX() && p1.getY() != p2.getY()){
			throw new PointsMatchForLineException("The app only permits horizontal or vertical lines");
		}
		return true;
	}
	
	public boolean validatePointsForRectangle(Point p1, Point p2)throws PointsMatchForRectangleException, InvalidPointException{
		validatePoint(p1);
		validatePoint(p2);
		if(p1.getX() >= p2.getX() || p1.getY() >= p2.getY()){
			throw new PointsMatchForRectangleException("x1 y1 must indicate the upper left corner and x2 y2 must indicate the lower right corner");
		}
		return true;
	}
	
}
