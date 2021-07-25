package com.senla.task7.entity;

public class Item {

    private final String name;
    private final int weight;
    private final int price;

    public Item(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Item: name - %s, weight - %d, price - %d", name, weight, price);
    }

}
