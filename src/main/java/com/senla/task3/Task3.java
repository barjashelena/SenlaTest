/*
На вход приходят 2 вектора, описанные координатами точек начала (x1,y1) и конца (x2,y2) вектора. Найти длины векторов,
а так же вектор произведения первого вектора на второй и второго на первый (получим 2 новых вектора).
Векторы выводить в формате “начало (x1,y1), конец (x2,y2).
*/

package com.senla.task3;

import com.senla.task3.entity.Vector;
import com.senla.task3.util.Parser;
import com.senla.task3.util.Validator;

import java.util.Scanner;

public class Task3 {

    private static final String INPUT_MESSAGE = "Enter point #%d of vector #%d in the format (x,y) ...";
    private static final String NEW_VECTOR_MESSAGE = "The vector of the product of the vector #%d by the vector #%d: ";
    private final Scanner scanner;
    private final Validator validator;
    private final Parser parser;
    private Vector vector1;
    private Vector vector2;

    public Task3(Scanner scanner) {
        this.scanner = scanner;
        this.validator = new Validator();
        this.parser = new Parser();
    }


    public static void main(String[] args) {

        try (var scanner = new Scanner(System.in)) {
            var task3 = new Task3(scanner);

            task3.vector1 = task3.getVector(1);
            System.out.println(task3.vector1 + " with length = " + task3.vector1.getLengthVector());

            task3.vector2 = task3.getVector(2);
            System.out.println(task3.vector2 + " with length = " + task3.vector2.getLengthVector());

            var multiplyVector = task3.vector1.multiplyVector(task3.vector2);
            System.out.println(String.format(NEW_VECTOR_MESSAGE, 1, 2) + multiplyVector);

        }

    }

    private Vector getVector(int numberVector) {

        int[] point1 = parser.parse(getVectorPoint(numberVector, 1));
        int[] point2 = parser.parse(getVectorPoint(numberVector, 2));

        return new Vector(point1[0], point1[1], point2[0], point2[1]);

    }

    private String getVectorPoint(int numberVector, int numberPoint) {

        while (true) {

            System.out.printf((INPUT_MESSAGE) + "%n", numberPoint, numberVector);

            String input = scanner.nextLine();

            if (validator.validate(input)) {
                return input;
            }

        }

    }

}
