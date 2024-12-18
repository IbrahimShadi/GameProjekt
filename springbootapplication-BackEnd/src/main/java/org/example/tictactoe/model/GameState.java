package org.example.tictactoe.model;

import java.util.Arrays;

public class GameState {
    private static final byte EMPTY = 0; // Leeres Feld
    private byte[][] board = new byte[3][3]; // 3x3 Spielfeld
    private byte currentPlayer = 1; // Startspieler: 1

    public byte[][] getBoard() {
        return board;
    }

    public byte getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean makeMove(int x, int y) {
        System.out.println("Received move: x=" + x + ", y=" + y);
        if (x < 0 || x >= 3 || y < 0 || y >= 3) {
            System.out.println("Invalid move: Coordinates out of bounds.");
            return false;
        }
        if (board[x][y] != EMPTY) {
            System.out.println("Invalid move: Field already occupied.");
            return false;
        }
        board[x][y] = currentPlayer;
        System.out.println("Updated Board: " + Arrays.deepToString(board)); // Debug-Ausgabe
        switchPlayer();
        return true;
    }


    private void switchPlayer() {
        currentPlayer = (byte) (currentPlayer == 1 ? 2 : 1);
    }

    public void resetGame() {
        board = new byte[3][3]; // Spielfeld zurücksetzen
        currentPlayer = 1;      // Startspieler zurücksetzen
    }
}
