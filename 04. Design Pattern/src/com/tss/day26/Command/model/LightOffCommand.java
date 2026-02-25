package com.tss.day26.Command.model;

public class LightOffCommand implements Command{
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnoff();
    }

    public void undo(){
        light.turnOn();
    }

    public void redo(){
        light.turnoff();
    }
}
