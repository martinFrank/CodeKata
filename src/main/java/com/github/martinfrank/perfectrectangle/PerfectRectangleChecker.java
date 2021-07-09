package com.github.martinfrank.perfectrectangle;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Predicate;

public class PerfectRectangleChecker {

    private final HashSet<Point> disjunctiveCorners = new HashSet<>();
    private final Rectangle bounds;
    private int area;

    public PerfectRectangleChecker(Rectangle bounds) {
        this.bounds = bounds;
    }

    public boolean check(ArrayDeque<Rectangle> rectangles) {
        for (Rectangle r : rectangles) {
            processRectangles(r);
        }

        if (isAreaMismatching()){
            return false;
        }

        if (boundsMismatchDisjunctivePoints()){
            return false;
        }

        if(disjunctiveCornersMismatchAmount()){
            return false;
        }

        //not simplified return statement to emphasize the three checks performed
        return true;


    }

    private boolean disjunctiveCornersMismatchAmount() {
        return disjunctiveCorners.size() != 4;
    }

    private boolean boundsMismatchDisjunctivePoints() {
        return Arrays.stream(bounds.points).anyMatch(Predicate.not(disjunctiveCorners::contains));
    }

    private boolean isAreaMismatching() {
        return area != bounds.area;
    }

    private void processRectangles(Rectangle r) {
        area = area + r.area;
        Arrays.stream(r.points).forEach(this::processDisjunctiveCorners);
    }

    private void processDisjunctiveCorners(Point p) {
        if (disjunctiveCorners.contains(p)) {
            disjunctiveCorners.remove(p);
        } else {
            disjunctiveCorners.add(p);
        }
    }
}
