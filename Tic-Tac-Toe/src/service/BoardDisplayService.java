package service;

import module.Board;

public class BoardDisplayService {
    public static void printBoard() {

        char[][] board = Board.getBoard();

        for (int i = 0; i < 3; i++) {
            System.out.println(
                    board[i][0] + " | " +
                            board[i][1] + " | " +
                            board[i][2]
            );

            if (i < 2) {
                System.out.println("--+---+--");
            }
        }
    }
}
