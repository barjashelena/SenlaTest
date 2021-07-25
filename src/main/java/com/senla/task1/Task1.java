/*
Напишите программу, которая возвращает количество "троек" в заданной строке.
Тройка - это символ, появляющийся три раза подряд в строке.
*/

package com.senla.task1;

import java.util.Scanner;

public class Task1 {

    private static final String INPUT_MESSAGE = "Enter a string to search for \"triplets\"...\n";
    private static final String RESULT_MESSAGE = "\nNumber of \"triplets\" in a given string = ";
    private static int result = 0;

    public static void main(String[] args) {

        try (var scanner = new Scanner(System.in)) {

            System.out.println(INPUT_MESSAGE);

            String input = scanner.nextLine();

            for (var i = 0; i < input.length() - 2; i++) {

                if (input.charAt(i) == input.charAt(i + 1) && input.charAt(i) == input.charAt(i + 2)) {
                    result++;
                }

            }

            System.out.println(RESULT_MESSAGE + result);

        }

    }

}
