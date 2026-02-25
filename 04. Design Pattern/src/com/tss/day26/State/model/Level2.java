package com.tss.day26.State.model;

public class Level2 implements LevelState {
    private int tasksDone = 0;

    @Override
    public void doTask(Player player) {
        tasksDone++;
        System.out.println("Level 2: Task done! Total tasks: " + tasksDone);
        if (tasksDone >= 5) {
            System.out.println("Leveling up to Level 3!");
            player.setState(new Level3());
        }
    }
    @Override
    public void showStatus () {
        System.out.println("You are at Level 2. Stronger now!");
    }
}
