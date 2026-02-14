package controller;

import module.Player;
import service.*;

import java.util.Scanner;

public class GameController {

    private static final Scanner scanner = new Scanner(System.in);

    public static void startGame() {

        GameInitializer.initializeGame();

        while (true) {

            BoardDisplayService.printBoard();

            System.out.println("Player " + Player.getPlayer() +
                    " enter row (0-2) and column (0-2): ");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Try making move
            if (!MoveService.makeMove(row, col)) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            // Check Win
            if (GameLogic.checkWin()) {
                BoardDisplayService.printBoard();
                System.out.println("🎉 Player " + Player.getPlayer() + " wins!");
                break;
            }

            // Check Draw
            if (GameLogic.isBoardFull()) {
                BoardDisplayService.printBoard();
                System.out.println("Game is a Draw!");
                break;
            }

            // Switch Player
            PlayerService.switchPlayer();
        }

        scanner.close();
    }
}
