package com.tss.day26.Command.model;

public interface Command {
    void execute();
    void undo();
    void redo();
}
