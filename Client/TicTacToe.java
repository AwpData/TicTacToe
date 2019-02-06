import java.util.*;

public class TicTacToe extends TicTacToe_Variables {
	public static void main(String[] args) {
		boolean player1turn = true;
		boolean player2turn = false;
		Scanner input = new Scanner(System.in);
		int boardsize = 3;
		String[] board = new String[boardsize * 2];
		String[] editedboard = board;
		for (int i = 0; i <= boardsize * 2 - 1; i += 2) {
			board[i] = "+-+-+-+";
			board[i + 1] = "| | | |";
		}
		for (int i = 0; i <= boardsize * 2 - 1; i++) {
			System.out.println(board[i].toString());
		}
		System.out.println("+-+-+-+");
		if (player1turn) {
			System.out.println("Player 1 your move: ");
		} else if (player2turn) {
			System.out.println("Player 2 your move: ");
		}
		String coordinates = input.nextLine();
		Scanner nums = new Scanner(coordinates).useDelimiter(",");
		int x = nums.nextInt();
		int y = nums.nextInt();
		System.out.println(x);
		System.out.println(y);
		for (int i = 1; i < editedboard.length; i += 2) {
			editedboard[i - 1] = board[i];
		}
		placingAssignment(x, y, editedboard);
	}

	public static void placingAssignment(int x, int y, String[] editedboard) {
		String find = editedboard[x - 1];
		for (int i = 0; i < find.length(); i++) {
			if (i == y) {
				if (y == 1) {
					editedboard[x - 1] = "|x| | |";
				}
				if (y == 2) {
					editedboard[x - 1] = "| |x| |";
				}
				if (y == 3) {
					editedboard[x - 1] = "| | |x|";
				}
			}
		}
		// insert for-loop to print editedboard.
	}
}
