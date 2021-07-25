/*
Создать программу, которая будет вычислять и выводить на экран простые множители из которых состоит целое число,
введенное пользователем. Если введено не целое число, то сообщать ему об ошибке.
*/

package com.senla.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task4 {

    private static final String INPUT_MESSAGE = "Enter an integer ...\n";
    private static final String INCORRECT_INPUT_MESSAGE = "The entered value is not an integer, please try again ...";
    private static final String RESULT_MESSAGE = "\nThe number %d consists of multipliers:\n";

    public static void main(String[] args) {

        var task4 = new Task4();

        System.out.println(INPUT_MESSAGE);
        var inputNumber = task4.getInputNumber();

        System.out.printf(RESULT_MESSAGE, inputNumber);
        task4.getMultipliers(inputNumber).forEach(System.out::println);

    }

    private int getInputNumber() {

        try (var scanner = new Scanner(System.in)) {

            Integer input = null;

            while (input == null) {

                try {
                    input = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println(INCORRECT_INPUT_MESSAGE);
                }

            }

            return input;

        }

    }

    private List<Integer> getMultipliers(int number) {

        List<Integer> multipliers = new ArrayList<>();
        var multiplier = 2;

        while (number > 1 && multiplier <= Math.sqrt(number)) {

            if (number % multiplier == 0) {
                multipliers.add(multiplier);
                number /= multiplier;
            } else if (multiplier == 2) {
                multiplier++;
            } else {
                multiplier += 2;
            }

        }

        if (number != 1) {
            multipliers.add(number);
        }

        return multipliers;

    }

}
