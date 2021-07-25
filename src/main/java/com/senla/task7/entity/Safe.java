package com.senla.task7.entity;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Safe {

    private final Item[] items;
    private final int price;

    public Safe(Item[] items, int price) {
        this.items = items;
        this.price = price;
    }

    public Item[] getItems() {
        return items;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return items == null
                ? "Safe is empty"
                : "Safe contents:\n" +
                Arrays.stream(items)
                        .map(Item::getName)
                        .collect(Collectors.joining(", "))
                + "\nContent cost: " + getPrice();
    }

}
