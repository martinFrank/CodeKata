package com.github.martinfrank.skyline;

public class Building {

    public final int x;
    public final int width;
    public final int height;

    public Building(int x, int width, int height) {
        this.x = x;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Building{" +
                "x=" + x +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
