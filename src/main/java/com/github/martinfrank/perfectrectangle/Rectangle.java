package com.github.martinfrank.perfectrectangle;

public class Rectangle {

    public final Point[] points;
    public final int area;

    public Rectangle(int x0, int y0, int x1, int y1) {
        points = new Point[4];
        points[0] = new Point(x0,y0);
        points[1] = new Point(x1,y0);
        points[2] = new Point(x0,y1);
        points[3] = new Point(x1,y1);
        area = (x1-x0)*(y1-y0);
    }
    public Rectangle(int[] input) {
        this(input[0],input[1],input[2],input[3]);
    }

}
