package ru.netology.data;

public class Book extends Product {

    private int id;
    private String author;

    public Book() {
        super();
    }

    public Book(int id, String name, int praise, String author) {
        super(id, name, praise);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
