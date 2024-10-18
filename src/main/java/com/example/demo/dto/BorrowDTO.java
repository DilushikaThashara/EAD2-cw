package com.example.demo.dto;

import java.util.Date;

public class BorrowDTO {
    private int id;
    private int bookId;
    private int memberId;
    private Date borrowDate;
    private Date returnDate;

    public BorrowDTO() {
        id = 0;
        bookId = 0;
        memberId = 0;
        borrowDate = new Date();
        returnDate = new Date();
    }

    public BorrowDTO(int id, int bookId, int memberId, Date borrowDate, Date returnDate) {
        this.id = id;
        this.bookId = bookId;
        this.memberId = memberId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}

