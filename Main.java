package SnakeLadder;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the board size you want in game: ");
		int boardSize = scn.nextInt();
		System.out.println("Enter the number of ladder you want in game: ");
		int numberOfLadders = scn.nextInt();
		System.out.println("Enter the number of ladder you want in game: ");
		int numberOfSnakes = scn.nextInt();
		System.out.println("Enter the number of players you want in game: ");
		int numberOfPlayers = scn.nextInt();
		Game obj = new Game(boardSize, numberOfLadders, numberOfSnakes, numberOfPlayers);
        obj.startGame();
	}

}
