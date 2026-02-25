package com.tss.day26.State.app;

import com.tss.day26.State.model.Player;

public class StateDemo {
    static void main() {
        Player player = new Player();
        player.showStatus();
        player.doTask();
        player.doTask();
        player.doTask();

        player.showStatus();
        player.doTask();
        player.doTask();
        player.doTask();
        player.doTask();
        player.doTask();

        player.showStatus();
        player.doTask();
    }
}
