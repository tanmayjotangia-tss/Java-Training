package com.tss.day26.State.model;

public class Level1 implements LevelState{
    private int tasksDone=0;
    @Override
    public void doTask(Player player) {
        tasksDone++;
        System.out.println("Level 1: Task done! Total tasks: " + tasksDone);
        if (tasksDone >= 3) {
            System.out.println("Leveling up to Level 2!");
            player.setState(new Level2());
        }
    }

    @Override
    public void showStatus() {
        System.out.println("You are at Level 1. Keep going!");
    }
}
