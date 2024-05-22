package com.davidbonelo.models;

public class Book {

    private String isbn;
    private String title;
    private String subTitle;
    private String author;
    private String publisher;
    private int pages;
    private String description;
    private String website;

    public Book(String isbn, String title, String subTitle, String author, String publisher,
                int pages, String description, String website) {
        this.isbn = isbn;
        this.title = title;
        this.subTitle = subTitle;
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
        this.description = description;
        this.website = website;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String value) {
        this.isbn = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String value) {
        this.subTitle = value;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String value) {
        this.author = value;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String value) {
        this.publisher = value;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int value) {
        this.pages = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String value) {
        this.website = value;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", pages=" + pages +
                ", description='" + description + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
