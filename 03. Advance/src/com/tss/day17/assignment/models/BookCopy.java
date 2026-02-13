package com.tss.day17.assignment.models;

import java.util.Random;

public class BookCopy { ;
    private int copyId;
    private boolean borrowed;
    private Book book;

    public BookCopy(Book book) {
        this.copyId = generateCopyId();
        this.book = book;
        this.borrowed = false;
    }

    public int getCopyId() {
        return copyId;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void borrowed() {
        this.borrowed = true;
    }

    public void returnCopy() {
        this.borrowed = false;
    }

    public Book getBook() {
        return book;
    }

    private static int generateCopyId(){
        return new Random().nextInt(1_000_000);
    }
}

