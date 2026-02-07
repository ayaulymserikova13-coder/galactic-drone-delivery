package edu.narxoz.galactic.factory;

import edu.narxoz.galactic.drones.Drone;
import edu.narxoz.galactic.drones.LightDrone;
import edu.narxoz.galactic.drones.HeavyDrone;

public class DroneFactory {

    public static Drone createDrone(String type, String id, double maxPayloadKg) {

        if (type.equalsIgnoreCase("light")) {
            return new LightDrone(id, maxPayloadKg);
        }

        if (type.equalsIgnoreCase("heavy")) {
            return new HeavyDrone(id, maxPayloadKg);
        }

        throw new IllegalArgumentException("Unknown drone type: "+type);
    }
}

