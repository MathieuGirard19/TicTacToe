package TicTacToe;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		boolean play;
		Scanner playerVar = new Scanner(System.in);
		Scanner playerMove = new Scanner(System.in);
		do {
			System.out.println("Welcome to TicTacToe Java Edition");
			System.out.print("Player 1 choose either x or o: ");
			String playerOne = playerVar.nextLine();
			String playerTwo;
			if(playerOne.contentEquals("x")) {
				playerTwo = "o";
			}
			else {
				playerTwo = "x";
			}
			System.out.println("Player One is: "+playerOne);
			System.out.println("Player Two is: "+playerTwo);
			Board game = new Board();
			boolean playerOneTurn = true;
			while(!game.checkFinish() && !game.checkWin(playerOne) && !game.checkWin(playerTwo)) {
				if (playerOneTurn) {
					System.out.println("Player One's Turn");
					game.makeMove(playerOne);
					playerOneTurn = !playerOneTurn;
				}
				else {
					System.out.println("Player Two's Turn");
					game.makeMove(playerTwo);
					playerOneTurn = !playerOneTurn;
				}		
			}
			game.printBoard();
			if (game.checkWin(playerOne)) {
				System.out.println("Game Over! Player One ("+playerOne+") wins");
			}
			else if (game.checkWin(playerOne)) {
				System.out.println("Game Over! Player Two ("+playerTwo+") wins");
			}
			else if(game.checkFinish()) {
				System.out.println("Game Over! Board Full");
			}
			
			play = game.playAgain();
		} while(play);
		System.out.println("GoodBye");
	}
}
