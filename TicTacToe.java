package com.capgemini.TicTacToe;

import java.util.*;

public class TicTacToe {

	// Variables
	private static char computer;
	private static char[] board;
	private static char userChoice;

	// Create Board and Assign Empty Spaces
	private static char[] createBoard() {
		char[] board = new char[10];
		for (int i = 1; i < board.length; i++)
			board[i] = ' ';
		return board;
	}

	// Selection of Letter by User
	private static char chooseUserLetter() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose Your User Letter X or O");
		char userChoice = sc.next().charAt(0);
		sc.close();
		return userChoice;
	}

	// Display the Board
	private static void showBoard(char[] board) {
		int k = 1;
		for (int i = 0; i <= 2; i++) {
			System.out.println("\n_______\n");
			System.out.print("|");
			for (int j = 0; j <= 2; j++) {
				System.out.print(board[k] + "|");
				k++;
			}
		}
		System.out.println("\n_______");
	}

	public static void main(String[] args) {
		board = createBoard();
		userChoice = chooseUserLetter();

		// Assigning Letter to Computer
		if (userChoice == 'X')
			computer = 'O';
		else
			computer = 'X';
		showBoard(board);
	}
}