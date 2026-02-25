package com.tss.day27;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {
    static UserManager manager;

    @BeforeAll
    static void init(){
        manager = new UserManager();
        manager.addUser("Tanmay","tan");


    }
    @Test
    void addUserThrowsExceptionForNull() {
        assertThrows(IllegalArgumentException.class,()-> manager.addUser(null,null));
    }


    @Test
    void userExists() {
        assertTrue(manager.userExists("Tanmay"));
    }

    @Test
    void login() {
        assertFalse(manager.login("Tanmay","may"));
    }

    @Test
    void getUser() {
        Object user = manager.getUser("Tanmay");
        assertInstanceOf(String.class,user);
    }
    @AfterEach
    void afterEachTest() {
        System.out.println("Test completed.");
    }

    @AfterAll
    static void cleanup() {
        manager = null;
        System.out.println("All tests completed. UserManager cleaned up.");
    }
}