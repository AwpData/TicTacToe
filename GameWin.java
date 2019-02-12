public class GameWin {
  
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
		for (int i = 0; i < 7; i++) {
			if (editedboard[0].charAt(i) == 'X' && editedboard[1].charAt(i) == 'X' && editedboard[2].charAt(i) == 'X') {
				return true;
			} else if (editedboard[0].charAt(i) == 'O' && editedboard[1].charAt(i) == 'O' && editedboard[2].charAt(i) == 'O') {
				return true;
			} 
		}
		return false;
	}
	
	  public static boolean checkDiagonalForWin(String[] editedboard) {  // Checks for diagonals 
		  if (editedboard[0].charAt(1) == 'X' && editedboard[1].charAt(3) == 'X' && editedboard[2].charAt(5) == 'X') {
			  return true;
		  } else if (editedboard[0].charAt(5) == 'X' && editedboard[1].charAt(3) == 'X' && editedboard[2].charAt(1) == 'X') {
			  return true;
		  } else if (editedboard[0].charAt(1) == 'O' && editedboard[1].charAt(3) == 'O' && editedboard[2].charAt(5) == 'O') {
			  return true;
		  } else if (editedboard[0].charAt(5) == 'O' && editedboard[1].charAt(3) == 'O' && editedboard[2].charAt(1) == 'O') {
			  return true;
		  }
		  return false;
	  }
}
