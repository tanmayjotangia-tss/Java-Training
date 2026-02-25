package com.tss.day26.Command.model;

public class LightOnCommand implements Command{
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnoff();
    }

    @Override
    public void redo() {
        light.turnOn();
    }
}
