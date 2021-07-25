/*
Создать программу, которая будет:
подсчитывать количество гласных в словах;
выводить слова отсортированные по кол-ву гласных (сперва те у которых больше гласных);
делать первую гласную букву в слове заглавной. Предложение вводится вручную. Разделитель пробел (“ ”).
*/

package com.senla.task5;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Task5 {

    private static final String INPUT_MESSAGE = "Enter a sentence for processing ...\n";
    private static final String REG_EX = "(?iu)[аоэеиыуёюяaeiouy]";
    private static final String DELIMITER = " ";

    public static void main(String[] args) {

        try (var scanner = new Scanner(System.in)) {

            System.out.println(INPUT_MESSAGE);

            var task5 = new Task5();

            String input = scanner.nextLine();

            String[] words = input.split(DELIMITER);

            Arrays.stream(words)
                    .sorted((s1, s2) -> Integer.compare(task5.vocalCounter(s2), task5.vocalCounter(s1)))
                    .forEach(w -> System.out.println(task5.firstUpperCase(w)));

        }

    }

    private String firstUpperCase(String word) {

        return word == null || word.isEmpty()
                ? ""
                : word.substring(0, 1).toUpperCase() + word.substring(1);

    }

    private int vocalCounter(String input) {

        var result = 0;
        var vocals = Pattern.compile(REG_EX);
        var matcher = vocals.matcher(input);

        while (matcher.find()) {
            result++;
        }

        return result;

    }

}
