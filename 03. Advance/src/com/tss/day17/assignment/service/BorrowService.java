package com.tss.day17.assignment.service;

import com.tss.day17.assignment.models.Book;
import com.tss.day17.assignment.models.BookCopy;
import com.tss.day17.assignment.models.Member;
import com.tss.utils.InputUtil;

import java.util.*;

public class BorrowService {

    private static Map<Integer, Book> bookList = BookService.getBookList();
    private static Map<Integer, Member> memberList = MemberService.getMemberList();
    private static Map<Integer, Set<Integer>> borrowedCopyByMember = new HashMap<>();
    private static Map<Integer,Integer> copytoMemberMap = new HashMap<>();

    public static void borrowBook() {
        int memberId = MemberService.selectMemberById();
        int bookNumber = BookService.selectBookByNumber();

        if(bookNumber == -1 || memberId == -1){
            return;
        }

        Book book = bookList.get(bookNumber);
        BookCopy copy = book.availableCopies();
        if (book == null) {
            throw new IllegalArgumentException("Select a valid Book Number");
        }
        if (!memberList.containsKey(memberId)) {
            throw new IllegalArgumentException("Select a valid Member ID");
        }
        if (copy == null){
            throw new IllegalArgumentException("No available free copies");
        }

        copy.borrowed();
        borrowedCopyByMember.putIfAbsent(memberId, new HashSet<>());

        for (int copyId : borrowedCopyByMember.get(memberId)) {
            BookCopy borrowedCopy = findCopyById(copyId);
            if (borrowedCopy.getBook().getBookNumber() == bookNumber) {
                throw new IllegalArgumentException("Member already borrowed this book");
            }
        }

        borrowedCopyByMember.get(memberId).add(copy.getCopyId());
        copytoMemberMap.put(copy.getCopyId(), memberId);

        System.out.println("Book borrowed successfully!");
    }

    public static void returnBook() {
        if(borrowedCopyByMember.size() == 0){
            throw new IllegalArgumentException("No books borrowed!");
        }
        int memberId = MemberService.selectMemberById();
        if (memberId == -1) {return;}
        Set<Integer> borrowedCopies = getBorrowedCopiesByMember(memberId);

        if (borrowedCopies.isEmpty()) {
            throw new IllegalArgumentException("No books borrowed by this member");
        }

        displayBorrowedCopiesNumberByMember(memberId);

        int copyNumber = InputUtil.readInt("Enter the copy number you want to return: ");

        if (!borrowedCopies.contains(copyNumber)) {
            throw new IllegalArgumentException("Enter Valid Book Number");
        }

        BookCopy copy = findCopyById(copyNumber);
        copy.returnCopy();
        borrowedCopies.remove(copyNumber);
        copytoMemberMap.remove(copyNumber);

        System.out.println("Book returned successfully!");
    }

    private static BookCopy findCopyById(int copyNumber) {
        for(Book book : bookList.values()){
            for(BookCopy copy : book.getCopies()){
                if(copy.getCopyId() == copyNumber){
                    return copy;
                }
            }
        }
        return null;
    }

    public static Set<Integer> getBorrowedCopiesByMember(int memberId) {
        return borrowedCopyByMember.getOrDefault(memberId, new HashSet<>());
    }

    public static void displayBorrowedBooksByMember() {
        int memberId = MemberService.selectMemberById();
        if (memberId == -1) {return;}
        Set<Integer> borrowed = getBorrowedCopiesByMember(memberId);

        if (borrowed.isEmpty()) {
            System.out.println("No books borrowed by member ID " + memberId);
            return;
        }

        System.out.println("Books borrowed by member ID " + memberId + ":");
        for (int copyId : borrowed) {
            BookCopy copy = findCopyById(copyId);
            System.out.println(copy.getBook());
        }
    }

    public static void displayBorrowedCopiesNumberByMember(int memberId) {
        Set<Integer> borrowed = getBorrowedCopiesByMember(memberId);

        if (borrowed.isEmpty()) {
            System.out.println("No books borrowed by member ID " + memberId);
            return;
        }
        System.out.println("Book numbers borrowed by member ID " + memberId + ":");
        for (int bookNumber : borrowed) {
            System.out.println(bookNumber);
        }
    }

//    public static void whoBorrowedBook() {
//        BookService.displayBookNumber();
//        int bookNumber = InputUtil.readInt("Enter book number: ");
//
//        boolean found = false;
//        for (Map.Entry<Integer, Set<Integer>> entry : borrowedBookByMember.entrySet()) {
//            int memberId = entry.getKey();
//            Set<Integer> borrowedBooks = entry.getValue();
//
//            if (borrowedBooks.contains(bookNumber)) {
//                System.out.println(memberList.get(memberId));
//                found = true;
//            }
//        }
//        if (!found) {
//            System.out.println("This book has not been borrowed by anyone.");
//        }
//    }

    public static void whoBorrowedBook() {
        if(bookList.isEmpty()){
            System.out.println("No books borrowed");
            return;
        }
        BookService.displayBookNumber();
        int bookNumber = InputUtil.readInt("Enter Book Number: ");

        Book book = bookList.get(bookNumber);
        if (book == null) {
            System.out.println("Invalid book number");
            return;
        }

        System.out.println("------- Borrowed Copies -------");
        if(copytoMemberMap.isEmpty()){
            System.out.println("No book copies borrowed");
            return;
        }
        for (BookCopy copy : book.getCopies()) {
            if (copytoMemberMap.containsKey(copy.getCopyId())) {
                System.out.println("Copy ID: " + copy.getCopyId());
            }
        }
        int copyNumber = InputUtil.readInt("Enter Copy Id: ");
        Integer memberId = copytoMemberMap.get(copyNumber);

        if (memberId == null) {
            System.out.println("This copy is not borrowed.");
            return;
        }

        System.out.println(memberList.get(memberId));
    }

    public static void displayBorrowedBooksTableByMember() {
        int  memberId = MemberService.selectMemberById();
        if(memberId == -1){
            return;
        }
        Set<Integer> borrowed = getBorrowedCopiesByMember(memberId);

        if (borrowed.isEmpty()) {
            System.out.println("No books borrowed by this member.");
            return;
        }
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-12s %-25s %-20s%n",
                "Book No", "Title", "Author");
        System.out.println("------------------------------------------------------------");

        for (int copyId : borrowed) {
            BookCopy copy = findCopyById(copyId);
            Book book = copy.getBook();

            System.out.printf("%-12d %-25s %-20s%n",
                    book.getBookNumber(),
                    book.getTitle(),
                    book.getAuthor());
        }
        System.out.println("------------------------------------------------------------");
    }

}

