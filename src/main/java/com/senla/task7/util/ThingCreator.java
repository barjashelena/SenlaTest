package com.senla.task7.util;

import com.senla.task7.entity.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThingCreator {

    private static final String COUNT_NOMENCLATURE_MESSAGE =
            "Let's fill in the list of items for the safe. Enter the number of different Items (ranging from %d to %d) ...";
    private static final String INPUT_ITEM_NAME = "Enter the name Item #%d ...";
    private static final String INPUT_ITEM_PRICE_MESSAGE = "Enter the price Item #%d (ranging from %d to %d) ...";
    private static final String INPUT_ITEM_WEIGHT_MESSAGE = "Enter the weight Item #%d (ranging from %d to %d) ...";
    private static final int MIN_COUNT_NOMENCLATURE = 1;
    private static final int MAX_COUNT_NOMENCLATURE = 10;
    private static final int MIN_PRICE_ITEM = 1;
    private static final int MAX_PRICE_ITEM = 10000;
    private static final int MIN_WEIGHT_ITEM = 1;
    private static final int MAX_WEIGHT_ITEM = 10;

    private ThingCreator() {}

    public static Item[] createNomenclature(Scanner scanner) {

        System.out.printf((COUNT_NOMENCLATURE_MESSAGE) + "%n", MIN_COUNT_NOMENCLATURE, MAX_COUNT_NOMENCLATURE);

        List<Item> items = new ArrayList<>();

        int countNomenclatureItems = InputUtil.getInputNumberConstraints(scanner, MIN_COUNT_NOMENCLATURE, MAX_COUNT_NOMENCLATURE);

        for (int i = 0; i < countNomenclatureItems; i++) {
            items.add(createItem(scanner, i + 1));
        }

        Item[] array = new Item[items.size()];

        return items.toArray(array);

    }

    private static Item createItem(Scanner scanner, int numberItem) {

        System.out.printf((INPUT_ITEM_NAME) + "%n", numberItem);
        String name = InputUtil.getString(scanner);

        System.out.printf((INPUT_ITEM_WEIGHT_MESSAGE) + "%n", numberItem, MIN_WEIGHT_ITEM, MAX_WEIGHT_ITEM);
        int weight = InputUtil.getInputNumberConstraints(scanner, MIN_WEIGHT_ITEM, MAX_WEIGHT_ITEM);

        System.out.printf((INPUT_ITEM_PRICE_MESSAGE) + "%n", numberItem, MIN_PRICE_ITEM, MAX_PRICE_ITEM);
        int price = InputUtil.getInputNumberConstraints(scanner, MIN_PRICE_ITEM, MAX_PRICE_ITEM);

        return new Item(name, weight, price);

    }

}
