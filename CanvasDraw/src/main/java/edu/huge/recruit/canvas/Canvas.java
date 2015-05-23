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
	

}
