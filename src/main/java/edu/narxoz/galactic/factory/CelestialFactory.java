package edu.narxoz.galactic.factory;

import edu.narxoz.galactic.bodies.Planet;
import edu.narxoz.galactic.bodies.SpaceStation;

public interface CelestialFactory {

    Planet createPlanet();
    SpaceStation createStation();
}
