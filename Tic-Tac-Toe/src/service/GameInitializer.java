package service;

import module.Board;
import module.Player;

public class GameInitializer {
    public static void initializeGame() {

        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        new Board(board);
        new Player('X'); // X always starts
    }
}
