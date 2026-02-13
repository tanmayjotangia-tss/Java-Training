package com.tss.day23.DIP.model;

import java.util.ArrayList;
import java.util.List;

public class FileLogger implements Logger{
    List<String> fileLog = new ArrayList<>();
    @Override
    public void registerLog(String message) {
        fileLog.add(message);
    }

    @Override
    public void getLog() {
        fileLog.forEach(System.out::println);
    }
}
