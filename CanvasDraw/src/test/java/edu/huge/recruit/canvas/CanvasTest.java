package edu.huge.recruit.canvas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class CanvasTest {
	
	List<String> mockCanvasEmpty;
	List<String> mockCanvasLineRectangle;
	List<String> mockCanvasLineRectangleFill;
	
	@Before
	public void init(){
		String margin = "----------------------";
		String empty = "|                    |";
		
		mockCanvasEmpty = new ArrayList<String>();
		mockCanvasEmpty.add(margin);
		mockCanvasEmpty.add(empty);
		mockCanvasEmpty.add(empty);
		mockCanvasEmpty.add(empty);
		mockCanvasEmpty.add(empty);
		mockCanvasEmpty.add(margin);
		
		
		String r1 = "|               xxxxx|";
		String r2 = "|xxxxxx         x   x|";
		String r3 = "|     x         xxxxx|";
		String r4 = "|     x              |";
		
		mockCanvasLineRectangle = new ArrayList<String>();
		mockCanvasLineRectangle.add(margin);
		mockCanvasLineRectangle.add(r1);
		mockCanvasLineRectangle.add(r2);
		mockCanvasLineRectangle.add(r3);
		mockCanvasLineRectangle.add(r4);
		mockCanvasLineRectangle.add(margin);
		
		String f1 = "|oooooooooooooooxxxxx|";
		String f2 = "|xxxxxxooooooooox   x|";
		String f3 = "|     xoooooooooxxxxx|";
		String f4 = "|     xoooooooooooooo|";
		
		mockCanvasLineRectangleFill = new ArrayList<String>();
		mockCanvasLineRectangleFill.add(margin);
		mockCanvasLineRectangleFill.add(f1);
		mockCanvasLineRectangleFill.add(f2);
		mockCanvasLineRectangleFill.add(f3);
		mockCanvasLineRectangleFill.add(f4);
		mockCanvasLineRectangleFill.add(margin);
		
		
	}

	@Test
	public void testCreate() {
		try{
			Canvas canvas = new Canvas(20, 4);
			Painter p = new Painter();
			p.paint(canvas.getPixels().keySet(), canvas.getWidth(), canvas.getHeight());
			Map<Integer, Character[]> data = p.getRows();
			Set<Integer> keys = data.keySet();
			for(Integer key: keys){
				Character[] pixelsRow = data.get(key);
				assertEquals(mockCanvasEmpty.get(key)+": Ok. ", p.printRow(pixelsRow), mockCanvasEmpty.get(key));
			}
		}catch(Exception e){
			fail("An exception occur");
		}
	}
	
	@Test
	public void testDrawElement() {
		try{
			Canvas canvas = new Canvas(20, 4);
			
			Point p1 = new Point(1, 2);
			Point p2 = new Point(6, 2);
			canvas.drawElement('L', p1, p2);
			
			Point p3 = new Point(6, 3);
			Point p4 = new Point(6, 4);
			canvas.drawElement('L', p3, p4);
			
			Point p5 = new Point(16, 1);
			Point p6 = new Point(20, 3);
			canvas.drawElement('R', p5, p6);
			

			Painter p = new Painter();
			p.paint(canvas.getPixels().keySet(), canvas.getWidth(), canvas.getHeight());
			Map<Integer, Character[]> data = p.getRows();
			Set<Integer> keys = data.keySet();
			for(Integer key: keys){
				Character[] pixelsRow = data.get(key);
				assertEquals(mockCanvasLineRectangle.get(key)+": Ok. ", p.printRow(pixelsRow), mockCanvasLineRectangle.get(key));
			}
		}catch(Exception e){
			fail("An exception occur");
		}
	}
	
	
	@Test
	public void testFill() {
		try{
			Canvas canvas = new Canvas(20, 4);
			
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
			

			Painter p = new Painter();
			p.paint(canvas.getPixels().keySet(), canvas.getWidth(), canvas.getHeight());
			Map<Integer, Character[]> data = p.getRows();
			Set<Integer> keys = data.keySet();
			for(Integer key: keys){
				Character[] pixelsRow = data.get(key);
				assertEquals(mockCanvasLineRectangleFill.get(key)+": Ok. ", p.printRow(pixelsRow), mockCanvasLineRectangleFill.get(key));
			}
		}catch(Exception e){
			fail("An exception occur");
		}
	}

}
