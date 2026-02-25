package com.tss.day26.Command.model;

import java.sql.SQLOutput;

public class RemoteControl {
    private Command command;
    private Command lastCommand;

    public void setCommand(Command command){
        this.command = command;
    }

    public void pressButton(){
        command.execute();
        lastCommand = command;
    }

    public void pressUndo(){
        if(lastCommand != null){
            lastCommand.undo();
        }else{
            System.out.println("No command to undo");
        }
    }

    public void pressRedo(){
        if(lastCommand != null){
            lastCommand.redo();
        }else{
            System.out.println("No command to redo");
        }
    }
}
