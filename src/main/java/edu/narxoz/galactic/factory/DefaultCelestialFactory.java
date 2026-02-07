package edu.narxoz.galactic.factory;

import edu.narxoz.galactic.bodies.Planet;
import edu.narxoz.galactic.bodies.SpaceStation;

public class DefaultCelestialFactory implements CelestialFactory {

    @Override
    public Planet createPlanet() {
        return new Planet("Earth", 0, 0, "Oxygen");
    }

    @Override
    public SpaceStation createStation() {
        return new SpaceStation("ISS", 10, 10, 3);
    }
}

