package service;

import module.Board;
import module.Player;

public class GameLogic {

    private static final int SIZE = 3;

    public static boolean checkWin() {

        char[][] board = Board.getBoard();
        char player = Player.getPlayer();

        // Check rows
        for (int row = 0; row < SIZE; row++) {
            if (board[row][0] == player &&
                    board[row][1] == player &&
                    board[row][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < SIZE; col++) {
            if (board[0][col] == player &&
                    board[1][col] == player &&
                    board[2][col] == player) {
                return true;
            }
        }

        // Check main diagonal
        if (board[0][0] == player &&
                board[1][1] == player &&
                board[2][2] == player) {
            return true;
        }

        // Check anti-diagonal
        if (board[0][2] == player &&
                board[1][1] == player &&
                board[2][0] == player) {
            return true;
        }

        return false;
    }

    public static boolean isBoardFull() {

        char[][] board = Board.getBoard();

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }
}
