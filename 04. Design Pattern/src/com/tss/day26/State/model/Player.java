package com.tss.day26.State.model;

public class Player {
    private LevelState state;

    public Player() {
        state = new Level1();
    }

    public void setState(LevelState state) {
        this.state = state;
    }

    public void doTask() {
        state.doTask(this);
    }

    public void showStatus() {
        state.showStatus();
    }
}
