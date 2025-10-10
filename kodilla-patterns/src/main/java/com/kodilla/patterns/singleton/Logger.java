package com.kodilla.patterns.singleton;

public final class Logger {

    private static Logger instatnce;
    private String lastLog = "";


    public static Logger getInstance() {
        if (instatnce == null) {
            instatnce = new Logger();
        }
        return instatnce;
    }

    public void log(String log) {
        lastLog = log;
        System.out.println("Log: [" + log + "]");
    }

    public String getLastLog() {
        return lastLog;
    }
}
