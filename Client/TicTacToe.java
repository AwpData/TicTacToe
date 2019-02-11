import java.util.*;

public class TicTacToe {
	public static void main(String[] args) {
		boolean player1turn = true; // test
		boolean player2turn = false; // test
		boolean win = false; // test
		boolean tryagain = false;
		Scanner input = new Scanner(System.in);
		int boardsize = 3; // Can change if you want but not supported
		String[] board = new String[boardsize * 2];
		String[] editedboard = board;
		String symbol = "";
		for (int i = 0; i <= boardsize * 2 - 1; i += 2) { // base board
			board[i] = "+-+-+-+";
			board[i + 1] = "| | | |";
		}
		for (int i = 1; i < editedboard.length; i += 2) { // board without the borders
			editedboard[i - 1] = board[i];
		}
		while (!win) { // start of user input
			if (player1turn) { // test section
				System.out.println("Player 1 your move: ");
				symbol = "X";
			} else if (player2turn) {
				System.out.println("Player 2 your move: ");
				symbol = "O"; // test section end
			}
			String coordinates = input.nextLine()  + ";";
			String xStr = coordinates.substring(0, coordinates.indexOf(",")); //split user input line into 2 variables (var 1 str)
			String yStr = coordinates.substring(coordinates.indexOf(",") + 1, coordinates.indexOf(";")); //split user input line into 2 variables (var 2 str)
			int x = Integer.parseInt(xStr); //parse var 1
			int y = Integer.parseInt(yStr);	//parse var 2 (finds what row)
			placingAssignment(x, y, editedboard, symbol);
			if (!player1turn) {
				player1turn = true;
				player2turn = false;
			} else if (!player2turn) {
				player2turn = true;
				player1turn = false;
			}
		}
	}

	public static void placingAssignment(int x, int y, String[] editedboard, String symbol) { // Places X and O
		String updater = editedboard[x - 1];
		for (int i = 0; i < 4; i++) {
			if (i == y) {
				if (y == 1) {
					String check = updater.substring(1, 2);
					if (check.equals("X") || check.equals("O")) {
						System.out.println("Space already occupied!");
					} else {
						updater = updater.substring(0, 1) + symbol + updater.substring(2);
						editedboard[x - 1] = updater;
					}
				}
				if (y == 2) {
					String check = updater.substring(3, 4);
					if (check.equals("X") || check.equals("O")) {
						System.out.println("Space already occupied!");
					} else {
						updater = updater.substring(0, 3) + symbol + updater.substring(4);
						editedboard[x - 1] = updater;
					}
				}
				if (y == 3) {
					String check = updater.substring(5, 6);
					if (check.equals("X") || check.equals("O")) {
						System.out.println("Space already occupied!");
					} else {
						updater = updater.substring(0, 5) + symbol + updater.substring(6);
						editedboard[x - 1] = updater;
					}
				}
			}
		}
		for (int i = 0; i < editedboard.length - 3; i++) { // Prints out board each turn
			System.out.println("+-+-+-+");
			System.out.println(editedboard[i].toString());
		}
		System.out.println("+-+-+-+");
	}
	public static boolean checkForWin() { // if any of the three other methods are true, then a player has won
		return(checkRowForWin || checkColumnsForWin|| checkDiagonalsForWin ); 
		
	}
	
	public static boolean checkRowForWin() { // uses a for loop to go through the three rows to see if all the values match 
		for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true) {
                return true;
            }
        }
        return false;
	}

	public static boolean checkColumnsForWin() { // uses a for loop to go through the columns to see if all the values match
		 for (int i = 0; i < 3; i++) {
	            if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true) {
	                return true;
	            }
	        }
	        return false;
	}
	
	public static boolean checkDiagonalsForWin() { // checks diagonals to see if they match 
		 return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
	}
	
	public static boolean checkRowCol(char c1, char c2, char c3) {// receives three values from the other methods to see if they all equal each other
		return ((c1!='-')&& (c1==c2)&&(c2==c3));
		// c1!='-'checks if the first character is empty or not (i dont know what an empty spot looks like so might need changing)
	}
}
