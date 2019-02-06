package tictac;

import java.util.Scanner;

public class InputOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//get input
		Scanner input = new Scanner(System.in);
		String full = input.nextLine()  + ";";
		String xStr = full.substring(0, full.indexOf(",")); //split user input line into 2 variables (var 1 str)
		String yStr = full.substring(full.indexOf(","), full.indexOf(";")); //split user input line into 2 variables (var 2 str)
		int X = Integer.parseInt(xStr); //parse var 1
		int Y = Integer.parseInt(yStr);	//parse var 2
		
		
		
	}

}

