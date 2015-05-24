package edu.huge.recruit;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import edu.huge.recruit.canvas.Point;
import edu.huge.recruit.exceptions.InvalidCommandException;

public class CommandReader {

	public Command readCommand()throws InvalidCommandException, Exception{
		Command command=new Command();
		
		System.out.println("Enter command:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = br.readLine();
		System.out.println(text);

		
		String[] commandData = text.split("\\s+");
		
		command.validateCommand(commandData);
		
		if(commandData[0].equals("Q")){
			command.setCommand('Q');
		}else if(commandData[0].equals("C")){
			command.setCommand('C');
			command.setWidth(Integer.parseInt(commandData[1]));
			command.setHeight(Integer.parseInt(commandData[2]));
		}else if(commandData[0].equals("L")){
			command.setCommand('L');
			command.setP1(new Point(Integer.parseInt(commandData[1]), Integer.parseInt(commandData[2])));
			command.setP2(new Point(Integer.parseInt(commandData[3]), Integer.parseInt(commandData[4])));
		}else if(commandData[0].equals("R")){
			command.setCommand('R');
			command.setP1(new Point(Integer.parseInt(commandData[1]), Integer.parseInt(commandData[2])));
			command.setP2(new Point(Integer.parseInt(commandData[3]), Integer.parseInt(commandData[4])));
		}else if(commandData[0].equals("B")){
			command.setCommand('B');
			command.setP1(new Point(Integer.parseInt(commandData[1]), Integer.parseInt(commandData[2])));
			command.setColor(commandData[3].charAt(0));
		}
		
		return command;
	}
}
