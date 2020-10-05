package com.capgemini.TicTacToe;
import java.util.*;

public class TicTacToe {

	// Create board with Empty Spaces
	private char[] createBoard() {
		char[] board = new char[10];
		for (int i = 1; i < 10; i++) {
			board[i] = ' ';
		}
		return board;
	}

	public static void main(String[] args) {

		// Welcome message
		System.out.println("Welcome to TicTacToe program");

		TicTacToe cb = new TicTacToe();
		cb.createBoard();
	}

}
