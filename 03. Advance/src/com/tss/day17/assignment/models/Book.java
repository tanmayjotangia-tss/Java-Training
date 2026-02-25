package com.tss.day17.assignment.models;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private int bookNumber;
    private String title;
    private String author;
    //    private String category;
    private List<BookCopy> copies = new ArrayList<>();
    private BookCategories category;

    public Book(int bookNumber,String title, String author, BookCategories category){
        this.bookNumber=bookNumber;
        this.title=title;
        this.author=author;
        this.category=category;
        copies.add(new BookCopy(this));
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BookCategories getCategory() {
        return category;
    }

    public void addCopy(){
        copies.add(new BookCopy(this));
    }

    public List<BookCopy> getCopies() {
        return copies;
    }

    public BookCopy availableCopies(){
        for(BookCopy copy : copies){
            if(!copy.isBorrowed()){
                return copy;
            }
        }
        return null;
    }

    public int getTotalCopies() {
        return copies.size();
    }

    public int getAvailableCopiesCount() {
        int count = 0;
        for (BookCopy copy : copies) {
            if (!copy.isBorrowed()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return  "\n---------------- Book Details ----------------\n" +
                "Book Number : " + bookNumber + "\n" +
                "Title       : " + title + "\n" +
                "Author      : " + author + "\n" +
                "Category    : " + category + "\n" +
                "Total Copies: " + getTotalCopies() + "\n" +
                "Available   : " + getAvailableCopiesCount() + "\n" +
                "---------------------------------------------";
    }
}

