package service;

import module.Board;
import module.Player;

public class MoveService {

    private static final int SIZE = 3;

    public static boolean makeMove(int row, int col) {

        char[][] board = Board.getBoard();
        char player = Player.getPlayer();

        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            System.out.println("Invalid position!");
            return false;
        }

        if (board[row][col] != ' ') {
            System.out.println("Cell already occupied!");
            return false;
        }

        board[row][col] = player;
        return true;
    }
}
