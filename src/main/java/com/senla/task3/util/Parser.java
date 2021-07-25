package com.senla.task3.util;

import java.util.Arrays;

public class Parser {

    public int[] parse(String input) {
        return Arrays.stream(input.split(","))
                .map(s -> s.replace("(", ""))
                .map(s -> s.replace(")", ""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

}
