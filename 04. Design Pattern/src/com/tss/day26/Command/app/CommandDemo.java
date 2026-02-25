package com.tss.day26.Command.app;

import com.tss.day26.Command.model.*;

public class CommandDemo {
    static void main() {
        Light light = new Light();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.pressUndo();
        remote.pressRedo();
        remote.setCommand(lightOn);
        remote.pressButton();
        remote.pressUndo();
        remote.pressRedo();

        remote.pressRedo();
        remote.setCommand(lightOff);
        remote.pressButton();
        remote.pressUndo();
        remote.pressRedo();
    }
}
