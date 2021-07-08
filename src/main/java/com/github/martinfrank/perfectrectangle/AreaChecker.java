package com.github.martinfrank.perfectrectangle;

import java.util.List;

public class AreaChecker {

    private final Rectangle bounds;

    public AreaChecker(Rectangle bounds ) {
        this.bounds = bounds;

    }

    public boolean check(List<Rectangle> rectangles){
        int sumOfRectangleAreas = rectangles.stream().mapToInt(Rectangle::getArea).sum();
        return bounds.area == sumOfRectangleAreas;
    }
}
