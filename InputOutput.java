package tictac;

import java.util.Scanner;

public class InputOutput {

	public static void main(String[] args) {
		
		//get input
		Boolean Compat;
		Scanner input = new Scanner(System.in);
		String full = input.nextLine()  + ";";
		
		String xStr = full.substring(0, full.indexOf(",")); //split user input line into 2 variables (var 1 str)
		String yStr = full.substring(full.indexOf(",") + 1, full.indexOf(";")); //split user input line into 2 variables (var 2 str)
		
		int X = Integer.parseInt(xStr); //parse var 1
		int Y = Integer.parseInt(yStr);	//parse var 2 (finds what row)
		
		//check for error
		if(board[X][Y].containes("O") || board[X][Y].containes("X")) {
			Compat = false;
		} else {
			Compat = true;
		}
		
		
	}

}

