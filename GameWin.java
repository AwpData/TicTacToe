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
		for (int i = 1; i < 6; i += 2) {
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
}
