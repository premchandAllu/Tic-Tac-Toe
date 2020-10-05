package com.capgemini.TicTacToe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

	// Constants
	private final static int TAIL = 0;
	private final static int HEAD = 1;

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

	// Selection of location by Player
	private static int selectLocation(char[] board) {
		Scanner sc = new Scanner(System.in);
		boolean available = false;
		int position = 0;
		Integer[] validCells = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		do {
			System.out.println("Choose a Desired Location on Board from 1 to 9 :");
			position = sc.nextInt();
			if (isSpaceFree(board, position) && Arrays.asList(validCells).contains(position))
				available = true;
			else
				System.out.println("Invalid Location. Choose from 1 to 9");
		} while (available == false);
		return position;

	}

	public static boolean isSpaceFree(char[] board, int position) {
		return board[position] == ' ';
	}

	// Make Move on Board
	private static void makeMove(char[] board, char Choice) {
		boolean empty = false;
		if (Choice == userChoice) {
			int position = selectLocation(board);
			board[position] = Choice;
		} else {
			do {
				int position = (int) (Math.floor((Math.random() * 10) % 9) + 1);
				empty = isSpaceFree(board, position);
				if (empty)
					board[position] = Choice;
			} while (empty == false);
		}
		showBoard(board);
	}

	// Toss of Head & Tail. Head - User, Tail - Computer
	private static int tossToWhoPlayFirst() {
		int gameToss = (int) (Math.floor(Math.random() * 10) % 2);
		return gameToss;
	}

	// Choose The First Player
	private static void chooseFirstPlayer(int gameToss,char[] board,char userChoice,char computer) {
		if (gameToss == HEAD) {
			System.out.println("User Plays First");
			makeMove(board, userChoice);
		}
		if (gameToss == TAIL) {
			System.out.println("Computer Plays First");
			makeMove(board, computer);
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Tic-Tac-Toe Game");
		board = createBoard();
		userChoice = chooseUserLetter();

		// Assigning Letter to Computer
		if (userChoice == 'X')
			computer = 'O';
		else
			computer = 'X';
		int toss=tossToWhoPlayFirst();
		chooseFirstPlayer(toss,board,userChoice,computer);
	}
}