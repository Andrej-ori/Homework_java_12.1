package ru.netology.data;

public class Product {
    protected int id;
    protected String name;
    protected int praise;

    public Product() {
    }

    public Product(int id, String name, int praise) {
        this.id = id;
        this.name = name;
        this.praise = praise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }
}
