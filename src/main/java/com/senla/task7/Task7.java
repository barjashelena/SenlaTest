/*
Есть набор предметов, задаётся заранее, предметы могут повторяться. Предмет имеет 2 параметра
(обязательных, остальные на усмотрения, типа имя и т.д.), объём (целое значение) и ценность (целое значение).
Предметы неделимы. Задаётся размер сейфа, параметром его объёма (целое значение).
Нужно написать программу, которая набивает сейф набором предметов,
таким образом чтобы ценность этого набора была максимальной.
*/

package com.senla.task7;

import com.senla.task7.entity.Item;
import com.senla.task7.util.InputUtil;
import com.senla.task7.util.SafePacker;
import com.senla.task7.util.ThingCreator;

import java.util.Scanner;

public class Task7 {

    private static final String INPUT_CAPACITY_SAFE_MESSAGE = "Enter the capacity of the safe (ranging from %d to %d) ...";
    private static final int MIN_CAPACITY_SAFE = 1;
    private static final int MAX_CAPACITY_SAFE = 10;


    public static void main(String[] args) {

        try (var scanner = new Scanner(System.in)) {

            System.out.printf((INPUT_CAPACITY_SAFE_MESSAGE) + "%n", MIN_CAPACITY_SAFE, MAX_CAPACITY_SAFE);
            int capacitySafe = InputUtil.getInputNumberConstraints(scanner, MIN_CAPACITY_SAFE, MAX_CAPACITY_SAFE);

            Item[] items = ThingCreator.createNomenclature(scanner);

            System.out.println("\n" + SafePacker.pack(capacitySafe, items));

        }

    }

}


