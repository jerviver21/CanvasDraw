package edu.huge.recruit.canvas;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.log4j.Logger;

/**
 * This class paints the canvas
 * @author Jerson Viveros Aguirre - Huge Test Recruit
 */
public class Painter {
	private Logger logger = Logger.getLogger(Painter.class);
	
	private Map<Integer, Character[]> rows;
	
	
	/**
	 * To paint the canvas it create array of characters that later will be Strings to print
	 * @param pixels
	 * @param width
	 * @param height
	 */
	private void generateRows(Set<Point> pixels, int width, int height){
		
		for(Point p:pixels){
			Integer y = p.getY();
			Character[] row=getRows().get(y); 
			if(row==null){
				row=new Character[width+2];
				getRows().put(y, row);
				row[0] = '|';
				row[width+1] = '|';
			}
			row[p.getX()] = p.getColor();
		}
	}
	
	/**
	 * Order the margins of the canvas
	 * @param width
	 * @param height
	 */
	private void init(int width, int height){
		setRows(new TreeMap<Integer, Character[]>());
		for(int i= 1; i <= height ; i++){
			Character[]  row=new Character[width+2];
			getRows().put(i, row);
			row[0] = '|';
			row[width+1] = '|';
			for(int j=1;j<=width;j++ ){
				row[j] = ' ';
			}
		}
		getRows().put(0, generateMargin(width, height));
		getRows().put(height+1, generateMargin(width, height));
	}
	
	
	/**
	 * Generate the margins
	 * @param width
	 * @param height
	 * @return
	 */
	private Character[] generateMargin(int width, int height){
		Character [] margin = new Character[width+2];
		for(int i=0; i<(width+2);i++){
			margin[i] = '-';
		}
		return margin;
	}
	
	/**
	 * Convert Character array in String to print
	 * @param row
	 * @return
	 */
	public String printRow(Character[] row){
		StringBuilder sb=new StringBuilder();
		for(Character c:row){
			sb.append(c);
		}
		return sb.toString();
	}
	
	/**
	 * Paint the canvas in the output.
	 * @param pixels
	 * @param w
	 * @param h
	 */
	public void paint (Set<Point> pixels, int w, int h){

		init(w, h);
		generateRows(pixels, w, h);
		
		Set<Integer> lrows = getRows().keySet();
		for(Integer kr : lrows){
			System.out.println(printRow(getRows().get(kr)));
		}
		
		
	}

	public Map<Integer, Character[]> getRows() {
		return rows;
	}

	public void setRows(Map<Integer, Character[]> rows) {
		this.rows = rows;
	}

	
}
