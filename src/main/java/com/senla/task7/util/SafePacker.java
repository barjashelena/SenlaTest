package com.senla.task7.util;

import com.senla.task7.entity.Item;
import com.senla.task7.entity.Safe;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class SafePacker {

    private SafePacker() {}

    public static Safe pack(int capacitySafe, Item[] items) {

        // array of intermediate states of the safe
        Safe[][] safePack = new Safe[items.length + 1][capacitySafe + 1];

        for (int i = 0; i < items.length + 1; i++) {

            for (int j = 0; j < capacitySafe + 1; j++) {

                if (i == 0 || j == 0) {

                    // the zero row and column are filled with zeros
                    safePack[i][j] = new Safe(new Item[]{}, 0);

                } else if (i == 1) {

                    // the first line is filled in simply: put the first item or not, depending on the weight
                    safePack[1][j] = items[0].getWeight() <= j
                            ? new Safe(new Item[]{items[0]}, items[0].getPrice())
                            : new Safe(new Item[]{}, 0);

                } else {

                    // if the next item does not fit into the safe,
                    if (items[i - 1].getWeight() > j) {

                        // write down the previous maximum
                        safePack[i][j] = safePack[i - 1][j];

                    } else {

                        // we will calculate the price of the next item + the maximum price for
                        // (the maximum possible weight for the safe - the weight of the item)
                        int newPrice = items[i - 1].getPrice() + safePack[i - 1][j - items[i - 1].getWeight()].getPrice();

                        // if the previous maximum is greater
                        if (safePack[i - 1][j].getPrice() > newPrice) {

                            // write it down
                            safePack[i][j] = safePack[i - 1][j];

                        } else {

                            // otherwise, we fix a new maximum: the current item + the cost of free space
                            safePack[i][j] = new Safe(Stream.concat(Arrays.stream(new Item[]{items[i - 1]}),
                                    Arrays.stream(safePack[i - 1][j - items[i - 1].getWeight()].getItems())).toArray(Item[]::new),
                                    newPrice);

                        }

                    }

                }
            }

        }

        return Arrays.stream(safePack)
                .map(row -> row[row.length - 1])
                .max(Comparator.comparing(Safe::getPrice))
                .orElse(new Safe(null, 0));

    }

}
