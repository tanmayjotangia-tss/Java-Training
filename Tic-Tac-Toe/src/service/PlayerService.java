package service;

import module.Player;

public class PlayerService {

    public static void switchPlayer() {

        char current = Player.getPlayer();

        if (current == 'X') {
            new Player('O');
        } else {
            new Player('X');
        }
    }
}
