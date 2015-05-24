package edu.huge.recruit;

import edu.huge.recruit.canvas.Point;
import edu.huge.recruit.exceptions.InvalidCommandException;

/**
 * This class represents a command
 * @author Jerson Viveros Aguirre - Huge Test Recruit
 *
 */
public class Command {
	/**
	 * All attributes represent the differents inputs that the user can enter in the application
	 */
	private Character command;
	private int width;
	private int height;
	private Point p1;
	private Point p2;
	private Character color;
	
	public Character getCommand() {
		return command;
	}
	public void setCommand(Character command) {
		this.command = command;
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
	public Point getP1() {
		return p1;
	}
	public void setP1(Point p1) {
		this.p1 = p1;
	}
	public Point getP2() {
		return p2;
	}
	public void setP2(Point p2) {
		this.p2 = p2;
	}
	public Character getColor() {
		return color;
	}
	public void setColor(Character color) {
		this.color = color;
	}

	/**
	 * Validate that a command is valid and in accordance with the specification
	 * @param commandData
	 * @return
	 * @throws InvalidCommandException
	 */
	public boolean validateCommand(String[] commandData)throws InvalidCommandException{
		if(commandData.length < 1  || !commandData[0].matches("[CLRBQ]")){
			throw new InvalidCommandException("Invalid Command, Enter C to create, L to draw a line, R to draw a Rectangule, B to paint an area or Q to Quit the application");
		}
		
		if(commandData[0].equals("C")){
			if(commandData.length != 3 || !commandData[1].matches("\\d+") || !commandData[2].matches("\\d+")){
				throw new InvalidCommandException("Invalid Command, C - Create, must have width(Integer) and height(Integer), example C 15 3");
			}
		}else if(commandData[0].equals("L")){
			if(commandData.length != 5 || !commandData[1].matches("\\d+") || !commandData[2].matches("\\d+") 
					|| !commandData[3].matches("\\d+") || !commandData[4].matches("\\d+")){
				throw new InvalidCommandException("Invalid Command, L - Line, must have x1(Integer), y1(Integer), x2(Integer) and y2(Integer), example L 1 2 7 2");
			}
		}else if(commandData[0].equals("R")){
			if(commandData.length != 5 || !commandData[1].matches("\\d+") || !commandData[2].matches("\\d+") 
					|| !commandData[3].matches("\\d+") || !commandData[4].matches("\\d+")){
				throw new InvalidCommandException("Invalid Command, R - Rectangle, must have x1(Integer), y1(Integer), x2(Integer) and y2(Integer), example R 1 2 7 3");
			}
		}else if(commandData[0].equals("B")){
			if(commandData.length != 4 || !commandData[1].matches("\\d+") || !commandData[2].matches("\\d+")){
				throw new InvalidCommandException("Invalid Command, B - Fill, must have x1(Integer),  y1(Integer) and color(Character), example B 5 3 p");
			}
		}
		return true;
	}
}
