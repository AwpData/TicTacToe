import java.util.*;

public class TicTacToe extends TicTacToe_Variables {
	public static void main(String[] args) {
		boolean player1turn = true; // test
		boolean player2turn = false; // test
		boolean win = false; // test
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
			String coordinates = input.nextLine();
			Scanner nums = new Scanner(coordinates).useDelimiter(",");
			int x = nums.nextInt();
			int y = nums.nextInt();
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
}
