package com.senla.task3.entity;

public class Vector {

    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;

    public Vector(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public double getLengthVector() {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public int multiplyVector(Vector vector) {
        return (x2 - x1) * (vector.getX2() - vector.getX1()) + (y2 - y1) * (vector.getY2() - vector.getY1());
    }

    @Override
    public String toString() {
        return String.format(("Vector: start (%d,%d), end (%d,%d)"), x1, y1, x2, y2);
    }

}
