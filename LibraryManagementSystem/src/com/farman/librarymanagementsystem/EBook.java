package com.farman.librarymanagementsystem;

public class EBook extends Book {
    private String fileSize;

    public EBook(String title, String author, String fileSize) {
        super(title, author);
        this.fileSize = fileSize;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", File Size: " + fileSize;
    }
}