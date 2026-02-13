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

//    public int getAvailableCopies() {
//        return availableCopies;
//    }
//
//    public int getTotalCopies() {
//        return totalCopies;
//    }


//    public boolean isAvailabe(){
//        return availableCopies > 0;
//    }

//    public void incrementCopies(){
//        availableCopies++;
//        totalCopies++;
//        System.out.println("Book copy incremented !!");
//    }

//    public void borrowCopy(){
//        if(availableCopies <=0){
//            throw new IllegalArgumentException("No available copy to borrow");
//        }
//        availableCopies--;
//    }
//
//    public void returnCopy(){
//        if(availableCopies < totalCopies){
//            availableCopies++;
//        }
//    }

    @Override
    public String toString() {
        return  "\n---------------- Book Details ----------------\n" +
                "Book Number : " + bookNumber + "\n" +
                "Title       : " + title + "\n" +
                "Author      : " + author + "\n" +
                "Category    : " + category + "\n" +
                "---------------------------------------------";
    }

}

