package com.senla.task3.util;

public class Validator {

    private static final String REG_EX = "^[(]-?\\d+[,]-?\\d+[)]$";

    public boolean validate(String input) {
        return input.matches(REG_EX);
    }

}
