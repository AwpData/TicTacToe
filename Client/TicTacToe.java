import java.util.*;
public class TicTacToe extends TicTacToe_Variables{
	public static void main(String[] args) {
		boolean player1turn = true;
		boolean player2turn = false;
		Scanner input = new Scanner(System.in);
		String[]board = new String[3];
		int boardsize = 3;
		for(int i = 0; i < boardsize; i++) {
			board[i] = "+-+-+-+";
			board[i+1] = "| | | |";
		}
		System.out.println(board);
		if (player1turn) {
			System.out.println("Player 1 your move: ");
		}
		else if (player2turn) {
			System.out.println("Player 2 your move: ");
		}

		String coordinates = input.nextLine();
		Scanner nums = new Scanner(coordinates).useDelimiter(",");
		int x = nums.nextInt();
		int y = nums.nextInt();
		System.out.println(x);
		System.out.println(y);
	}
	
	public static void placingAssignment(int x, int y) {
		for(int i = 0; i < x; i++) {
			
		}
	}
}

