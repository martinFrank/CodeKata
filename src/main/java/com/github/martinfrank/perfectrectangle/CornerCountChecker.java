package com.github.martinfrank.perfectrectangle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CornerCountChecker {

    private final HashSet<Point> disjunctiveCorners = new HashSet<>();
    private final Rectangle bounds;
    private int area;

    public CornerCountChecker (Rectangle bounds){
        this.bounds = bounds;
    }

    public boolean check(ArrayDeque<Rectangle> rectangles) {
        for (Rectangle r : rectangles) {
            addOrRemoveCorners(r);
        }

        if(area != bounds.area){
            return false;
        }

        for (Point boundCorner : bounds.points) {
            if (!disjunctiveCorners.contains(boundCorner)) {
                return false;
            }
        }

        return disjunctiveCorners.size() == 4;
    }

    private void addOrRemoveCorners(Rectangle r) {
        area = area + r.getArea();
        for (Point p : r.getPoints()) {
            addOrRemovePoints(p);
        }
    }

    private void addOrRemovePoints(Point p) {
        if (disjunctiveCorners.contains(p)) {
            disjunctiveCorners.remove(p);
        }else{
            disjunctiveCorners.add(p);
        }
    }
}
