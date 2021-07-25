/*
Создайте программу, которая будет получать число и печатать его в следующем формате ASCII ART
(формы цифр можно придумать свою, главное чтобы она читалась на экране)
Дополнительно: сделайте так, чтобы «большая цифра» состояла не из ‘*’, а из соответствующих маленьких(обычных) цифр.
*/

package com.senla.task6;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Scanner;

public class Task6 {

    private static final String INPUT_MESSAGE = "Enter text to generate ASCII Art...\n";
    private static final String BACKGROUND = " ";
    private static final String PRINT_SYMBOL = "*";
    private static final int WIDTH = 140;
    private static final int HEIGHT = 30;
    private static final int SIZE = 20;
    private static final int START_PRINT_X = 0;
    private static final int START_PRINT_Y = 20;
    private static final int COLOR_MODEL = -16777216;

    public static void main(String[] args) {

        try (var scanner = new Scanner(System.in)) {

            System.out.println(INPUT_MESSAGE);
            String input = scanner.nextLine();
            System.out.println();

            var image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

            Graphics2D graphics = (Graphics2D) image.getGraphics();
            graphics.setFont(new Font("SansSerif", Font.PLAIN, SIZE));
            graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            graphics.drawString(input, START_PRINT_X, START_PRINT_Y);

            for (var y = 0; y < HEIGHT; y++) {

                var printString = new StringBuilder();

                for (var x = 0; x < WIDTH; x++) {
                    printString.append(image.getRGB(x, y) == COLOR_MODEL ? BACKGROUND : PRINT_SYMBOL);
                }

                if (printString.toString().trim().isEmpty()) {
                    continue;
                }

                System.out.println(printString);

            }

        }

    }

}