package com.tss.day27;

import java.util.HashMap;
import java.util.Map;

public class UserManager {

    private Map<String, String> users = new HashMap<>();

    public void addUser(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username or password cannot be null");
        }
        users.put(username, password);
    }

    public boolean userExists(String username) {
        return users.containsKey(username);
    }

    public boolean login(String username, String password) {
        if (!users.containsKey(username)) return false;
        return users.get(username).equals(password);
    }

    public Object getUser(String username) {
        if (!users.containsKey(username)) return null;
        return users.get(username);
    }
}
