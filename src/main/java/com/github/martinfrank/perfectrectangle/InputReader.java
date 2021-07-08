package com.github.martinfrank.perfectrectangle;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {

    private ArrayDeque<Rectangle> rectangles;
    private int minx = Integer.MAX_VALUE;
    private int maxx = Integer.MIN_VALUE;
    private int miny = Integer.MAX_VALUE;
    private int maxy = Integer.MIN_VALUE;


    public void readInput(int[][] input) {
        rectangles = new ArrayDeque(Arrays.stream(input).map(this::addRectangle).collect(Collectors.toList()));
    }

    public ArrayDeque<Rectangle> getRectangles() {
        return rectangles;
    }

    public Rectangle getBounds() {
        return new Rectangle(minx, miny, maxx, maxy);
    }

    private Rectangle addRectangle(int[] rectData) {
        int x0 = rectData[0];
        int y0 = rectData[1];
        int x1 = rectData[2];
        int y1 = rectData[3];

        if (x0 < minx) {
            minx = x0;
        }
        if (x1 > maxx) {
            maxx = x1;
        }
        if (y0 < miny) {
            miny = y0;
        }
        if (y1 > maxy) {
            maxy = y1;
        }

        return new Rectangle(x0, y0, x1, y1);

    }


}
