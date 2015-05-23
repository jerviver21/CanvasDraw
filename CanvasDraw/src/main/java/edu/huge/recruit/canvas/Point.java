package edu.huge.recruit.canvas;

/**
 * This class represents a point into the canvas with its own color (a character)
 * @author Jerson Viveros Aguirre - Huge Test Recruit
 */
public class Point {
	private int x;
	private int y;
	private char color;
	
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public char getColor() {
		return color;
	}
	public void setColor(char color) {
		this.color = color;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	@Override
	public boolean equals(Object o){
		Point p = null;
		if(o instanceof Point){
			p = (Point) o;
		}else{
			return false;
		}
		
		if(this.x == p.getX() && this.y==p.getY()){
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return (x+"_"+y).hashCode();
		
	}

}
