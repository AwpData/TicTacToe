import java.util.*;

//Don't choose an occupied space or you miss your turn 
public class TicTacToe {
	public static void main(String[] args) {
		boolean player1turn = true; // if player 1 can go
		boolean player2turn = false; // if player 2 can go
		boolean win = false; //determines if someone won
		boolean tryagain = false;
		Scanner input = new Scanner(System.in);
		int boardsize = 3; //default boardsize (cannot change as it is not supported)
		int num = 0;
		String[] board = new String[boardsize * 2]; //create new board
		String[] editedboard = board; //create a copy of the board to store values & to check for wins
		String symbol = ""; //symbol X or O depending on player
		String currentplayer = ""; //who the current player is 
		for (int i = 0; i <= boardsize * 2 - 1; i += 2) { // base board
			board[i] = "+-+-+-+";
			board[i + 1] = "| | | |";
		}
		for(int i = 0; i <= boardsize * 2 - 1; i++) {
			System.out.println(board[i]);
		}
		System.out.println("+-+-+-+");
		for (int i = 1; i < editedboard.length; i += 2) { // board without the borders (For filling in)
			editedboard[i - 1] = board[i];
		}
		while (!win) { // start of user input
			System.out.println();
			if (player1turn) { // test section
				System.out.println("Player 1 your move: ");
				symbol = "X";
				currentplayer = "Player 1";
			} else if (player2turn) {
				System.out.println("Player 2 your move: ");
				symbol = "O"; // test section end
				currentplayer = "Player 2";
			}
			String coordinates = input.nextLine();
			String xStr = coordinates.substring(0, coordinates.indexOf(",")); // gets x input
			String yStr = coordinates.substring(coordinates.indexOf(",") + 1); // gets y input
			int x = Integer.parseInt(xStr); // parse var 1 (finds what row)
			int y = Integer.parseInt(yStr); // parse var 2 (finds what column)
			tryagain = placingAssignment(x, y, editedboard, symbol); //places X and Y on coordinates
			
			for (int i = 0; i < editedboard.length - 3; i++) { // Prints out board each turn
				System.out.println("+-+-+-+");
				System.out.println(editedboard[i].toString());
			}
			System.out.println("+-+-+-+");
			if (tryagain) { //Player retries 
				continue;
			}
			num++;
			if (num == 9) { //9 = All spaces filled 
				System.out.println("Tie game!");
				break;
			}
			if (checkForWin(editedboard)) { //Checks win methods
				System.out.println(currentplayer + " wins!");
				break;
			} 
			if (!player1turn && !tryagain) { //Changes player to 1
				player1turn = true;
				player2turn = false;
				tryagain = false;
			} else if (!player2turn && !tryagain) { // Changes player to 2
				player2turn = true;
				player1turn = false;
				tryagain = false;
			}
		}
	}
	
	public static boolean checkForWin(String[] editedboard) { //Simplifies what it checks for (easy reading) 
		return (checkRowForWin(editedboard) || checkColumnForWin(editedboard) || checkDiagonalForWin(editedboard));
	}
	
	public static boolean checkRowForWin(String[] editedboard) { // goes through each row to see if it is three in a row
		for (int i = 0; i < 3; i++) {
			if (editedboard[i].contains("X|X|X") || editedboard[i].contains("O|O|O")) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkColumnForWin(String[] editedboard) { // checks each column for matching pairs of X's or O's
		for (int i = 1; i < 7; i += 2) {
			if (editedboard[0].indexOf("X") == i && editedboard[1].indexOf("X") == i && editedboard[2].indexOf("X") == i) {
				return true;
			} else if (editedboard[0].indexOf("O") == i && editedboard[1].indexOf("O") == i && editedboard[2].indexOf("O") == i) {
				return true;
			} 
		}
		return false;
	}
	
	  public static boolean checkDiagonalForWin(String[] editedboard) {  // Checks for diagonals 
		  if (editedboard[0].indexOf("X") == 1 && editedboard[1].indexOf("X") == 3 && editedboard[2].indexOf("X") == 5) {
			  return true;
		  } else if (editedboard[0].indexOf("X") == 5 && editedboard[1].indexOf("X") == 3 && editedboard[2].indexOf("X") == 1) {
			  return true;
		  } else if (editedboard[0].indexOf("O") == 1 && editedboard[1].indexOf("O") == 3 && editedboard[2].indexOf("O") == 5) {
			  return true;
		  } else if (editedboard[0].indexOf("O") == 5 && editedboard[1].indexOf("O") == 3 && editedboard[2].indexOf("O") == 1) {
			  return true;
		  }
		  return false;
	  }
	  
	public static boolean placingAssignment(int x, int y, String[] editedboard, String symbol) { // Places X and O
		String updater = editedboard[x - 1]; //This temporarily keeps the ROW so it will not reset to default 
		for (int i = 0; i < 4; i++) {
			if (i == y) {
				if (y == 1) { // Column
					String check = updater.substring(1, 2);
					if (check.equals("X") || check.equals("O")) { //Checks for occupied spaces 
						System.out.println("Space already occupied!");
						System.out.println("Try again");
						return true;
					} else {
						updater = updater.substring(0, 1) + symbol + updater.substring(2); //sets updater to current string
						editedboard[x - 1] = updater; //updates the board with updater
						return false;
					}
				}
				if (y == 2) {
					String check = updater.substring(3, 4);
					if (check.equals("X") || check.equals("O")) {
						System.out.println("Space already occupied!");
						System.out.println("Try again");
						return true;
					} else {
						updater = updater.substring(0, 3) + symbol + updater.substring(4);
						editedboard[x - 1] = updater;
						return false;					}
				}
				if (y == 3) {
					String check = updater.substring(5, 6);
					if (check.equals("X") || check.equals("O")) {
						System.out.println("Space already occupied!");
						System.out.println("Try again");
						return true;
					} else {
						updater = updater.substring(0, 5) + symbol + updater.substring(6);
						editedboard[x - 1] = updater;
						return false;
					}
				}
			}
		}
		return true;
	}

}
