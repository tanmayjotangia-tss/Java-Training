package com.tss.day23.DIP.model;

import java.util.ArrayList;
import java.util.List;

public class DBLogger implements Logger {
    private List<String> dbLog = new ArrayList<>();

    @Override
    public void registerLog(String message) {
        dbLog.add(message);
    }

    @Override
    public void getLog() {
        dbLog.forEach(System.out::println);
    }
}
