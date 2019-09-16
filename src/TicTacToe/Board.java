package TicTacToe;

import java.util.Scanner;

public class Board {
	String[][] moves;
	
	public Board() {
		String[][] played = new String[][] {{" ", " ", " "},{" ", " ", " "},{" ", " ", " "}};
		moves = played;
	}
	
	//remove 0 indexing
	public void makeMove(String p) {
		Scanner playerInput = new Scanner(System.in);
		boolean moveComplete = false;
		do {
			printBoard();
			System.out.print("select row: ");
			int inputRow = playerInput.nextInt();
			System.out.print("select col: ");
			int inputCol = playerInput.nextInt();
			if(moves[inputRow-1][inputCol-1].contentEquals(" ") && (inputRow >= 0 && inputCol >= 0) && (inputRow <=3 && inputCol <=3)){
				moves[inputRow-1][inputCol-1] = p;
				moveComplete = true;
			}
			else {
				System.out.println("Invalid Move, Try Again");
			}
		} while(!moveComplete);
	}
	
	public boolean playAgain() {
		Scanner inputPlayAgain = new Scanner(System.in);
		do {
			System.out.println("Play Again? y or n");
			String playAgain = inputPlayAgain.nextLine();
			if(playAgain.contentEquals("y") || playAgain.contentEquals("Y")) {
				return true;
			}
			else if(playAgain.contentEquals("n") || playAgain.contentEquals("y")) {
				return false;
			}
			else {
				System.out.println("Invalid Input, Try Again");
			}
		} while(true);
	}
	
	public boolean checkWin(String p) {
		//across
		for(int i=0; i<moves.length; i++) {
			if (moves[i][0].contentEquals(p) && moves[i][1].contentEquals(p) && moves[i][2].contentEquals(p)) {
				return true;
			}
		}
		
		//down
		for(int i=0; i<moves.length; i++) {
			if(moves[0][i].contentEquals(p) && moves[1][i].contentEquals(p) && moves[2][i].contentEquals(p)) {
				return true;
			}
		}
		
		//diagonal
		if (moves[0][0].contentEquals(p) && moves[1][1].contentEquals(p) && moves[2][2].contentEquals(p)) {
			return true;
		}
		
		if (moves[2][0].contentEquals(p) && moves[1][1].contentEquals(p) && moves[0][2].contentEquals(p)) {
			return true;
		}
		
		return false;
	}
	
	
	public boolean checkFinish() {
		for(int i=0; i < moves.length; i++) {
			for(int j=0; j<moves.length; j++) {
				if(moves[i][j] == " ") {
					return false;
				}
			}
		}
		
		return true;
	}
	
	
	public void printBoard() {
		for(int i=0; i < moves.length; i++) {
			for(int j=0; j<moves.length; j++) {
				System.out.print(moves[i][j]);
				if (j==2) {
					System.out.println();
					if(i!=2) {
						System.out.println("-----");
					}
				}
				else {
					System.out.print("|");
				}
			}
		}
	}
}
