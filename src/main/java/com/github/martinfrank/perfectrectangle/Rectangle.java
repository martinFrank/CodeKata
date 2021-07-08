package com.github.martinfrank.perfectrectangle;

import java.util.Arrays;

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

    public Point[] getPoints() {
        return points;
    }

    public int getArea(){
        return area;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
