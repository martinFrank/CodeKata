package com.github.martinfrank.skyline;

public class Edge {

    public final int x;
    public final int height;
    public final boolean isRising;

    public Edge(int x, int height, boolean isRising){
        this.x = x;
        this.height = height;
        this.isRising = isRising;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "x=" + x +
                ", h=" + height +
                ", isRising=" + isRising +
                '}';
    }
}
