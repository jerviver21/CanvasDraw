package edu.huge.recruit.canvas;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.log4j.Logger;

/**
 * 
 * @author Jerson Viveros Aguirre - Huge Test Recruit
 */
public class Painter {
	private Logger logger = Logger.getLogger(Painter.class);
	
	Map<Integer, Character[]> rows;
	
	private void generateRows(Set<Point> pixels, int width, int height){
		
		for(Point p:pixels){
			Integer y = p.getY();
			Character[] row=rows.get(y); 
			if(row==null){
				row=new Character[width+2];
				rows.put(y, row);
				row[0] = '|';
				row[width+1] = '|';
			}
			row[p.getX()] = p.getColor();
		}
	}
	
	
	private void init(int width, int height){
		rows = new TreeMap<Integer, Character[]>();
		for(int i= 1; i <= height ; i++){
			Character[]  row=new Character[width+2];
			rows.put(i, row);
			row[0] = '|';
			row[width+1] = '|';
			for(int j=1;j<=width;j++ ){
				row[j] = ' ';
			}
		}
		rows.put(0, generateMargin(width, height));
		rows.put(height+1, generateMargin(width, height));
	}
	
	private Character[] generateMargin(int width, int height){
		Character [] margin = new Character[width+2];
		for(int i=0; i<(width+2);i++){
			margin[i] = '-';
		}
		return margin;
	}
	
	private String printRow(Character[] row){
		StringBuilder sb=new StringBuilder();
		for(Character c:row){
			sb.append(c);
		}
		return sb.toString();
	}
	
	public void paint (Set<Point> pixels, int w, int h){

		init(w, h);
		generateRows(pixels, w, h);
		
		Set<Integer> lrows = rows.keySet();
		for(Integer kr : lrows){
			System.out.println(printRow(rows.get(kr)));
		}
		
		
	}

	
}
