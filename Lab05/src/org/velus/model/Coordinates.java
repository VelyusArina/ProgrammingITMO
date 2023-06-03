package org.velus.model;

import java.io.Serializable;

public class Coordinates implements Comparable<Coordinates>, Serializable {
    private final Double x; //Поле не может быть null
    private final double y;

    public Coordinates(Double x, double y) {
        this.x = x;
        this.y = y;
    }


    public double getY() {
        return y;
    }

    public Double getX() {
        return x;
    }

    @Override
    public int compareTo(Coordinates o) {
        if (x.equals(o.x)) {
            return Double.compare(y, o.y);
        } else {
            return Double.compare(x, o.x);
        }
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
