package com.tss.day26.State.model;

public class Level3 implements LevelState {
    @Override
    public void doTask(Player player) {
        System.out.println("All Tasks done!!");
    }

    @Override
    public void showStatus() {
        System.out.println("At max level");
    }
}
