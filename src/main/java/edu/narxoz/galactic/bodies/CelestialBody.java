package edu.narxoz.galactic.bodies;

public class CelestialBody {
    private String name;
    private double x;
    private double y;

    public CelestialBody(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
