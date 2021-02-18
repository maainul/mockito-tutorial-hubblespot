package com.mainul.mockito.test_doubles.fake;

import java.time.LocalDate;

public class Book {
    private String bookId;
    private String title;
    private int price;
    private LocalDate publishdDate;

    public Book(String bookId, String title, int price, LocalDate publishdDate) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.publishdDate = publishdDate;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getPublishdDate() {
        return publishdDate;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPublishdDate(LocalDate publishdDate) {
        this.publishdDate = publishdDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", publishdDate=" + publishdDate +
                '}';
    }
}
