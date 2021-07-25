package com.senla.task7.util;

import java.util.Scanner;

public class InputUtil {

    private static final String INCORRECT_INPUT = "You entered an incorrect value, please try again ...";

    private InputUtil() {}

    public static int getInputNumberConstraints(Scanner scanner, int min, int max) {

        while (true) {

            try {

                int input = Integer.parseInt(scanner.nextLine());

                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println(INCORRECT_INPUT);
                }

            } catch (NumberFormatException e) {
                System.out.println(INCORRECT_INPUT);
            }

        }

    }

    public static String getString(Scanner scanner) {
        return scanner.nextLine();
    }

}
