
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
			if (checkForWin(editedboard)) { //Checks win methods
				System.out.println(currentplayer + " wins!");
				break;
			} 
			num++; //Adds +1 for each space filled (for ties) 
			if (num == 9) { //9 = All spaces filled 
				System.out.println("Tie game!");
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
