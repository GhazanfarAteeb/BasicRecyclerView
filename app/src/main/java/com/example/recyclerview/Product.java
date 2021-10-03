package com.example.recyclerview;

public class Product {
    int id;
    String name;
    double price;
    int quantity;
    String shortDescription;

    public Product(int id, String name, double price, int quantity, String shortDescription) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.shortDescription = shortDescription;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
