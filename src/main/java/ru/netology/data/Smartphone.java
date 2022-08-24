package ru.netology.data;

public class Smartphone extends Product {

    private String manufacturer;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int praise, String manufacturer) {
        super(id, name, praise);
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
