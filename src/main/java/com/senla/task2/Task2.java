/*
Напишите программу, которая возвращает сумму цифр, присутствующих в данной строке.
Если цифр нет, возвращаемая сумма равна 0.
*/

package com.senla.task2;

import java.util.Scanner;

public class Task2 {

    private static final String INPUT_MESSAGE = "Enter a string to sum the digits included ...\n";
    private static final String RESULT_MESSAGE = "\nSum the digits included = ";
    private static int result = 0;

    public static void main(String[] args) {

        try (var scanner = new Scanner(System.in)) {

            System.out.println(INPUT_MESSAGE);

            String input = scanner.nextLine();

            for (var i = 0; i < input.length(); i++) {

                if (Character.isDigit(input.charAt(i))) {
                    result += Character.getNumericValue(input.charAt(i));
                }

            }

            System.out.println(RESULT_MESSAGE + result);

        }

    }

}
