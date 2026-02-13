package com.tss.day23.DIP.test;

import com.tss.day23.DIP.model.DBLogger;
import com.tss.day23.DIP.model.FileLogger;
import com.tss.day23.DIP.model.Logger;

import java.util.ArrayList;
import java.util.List;

public class LoggerTest {

    static List<Logger> loggers = new ArrayList<>();
    static int count = 0;
    static final int LIMIT = 3;

    public static void main(String[] args) throws InterruptedException {

        loggers.add(new DBLogger());
        loggers.add(new FileLogger());

        for (int i = 1; i <= 8; i++) {

            try {
                generateException(i);
            } catch (Exception e) {

                Logger currentLogger;

                if (count < LIMIT) {
                    currentLogger = loggers.get(0);
                    System.out.println("DB Logger Logs:");
                } else {
                    currentLogger = loggers.get(1);
                    System.out.println("File Logger Logs:");
                }

                currentLogger.registerLog("Error " + i + " : " + e.getMessage());
                currentLogger.getLog();

                count++;

                Thread.sleep(1000);
                System.out.println("--------------------------");
            }
        }
    }

    static void generateException(int i) throws Exception {

        if (i % 2 == 0) {
            int x = 10 / 0;
        } else {
            String s = null;
            s.length();
        }
    }
}
