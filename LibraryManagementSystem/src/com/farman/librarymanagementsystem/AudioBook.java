package com.farman.librarymanagementsystem;

public class AudioBook extends Book {
    private String duration;

    public AudioBook(String title, String author, String duration) {
        super(title, author);
        this.duration = duration;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", Duration: " + duration;
    }
}