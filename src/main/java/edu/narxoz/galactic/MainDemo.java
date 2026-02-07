package edu.narxoz.galactic;

import edu.narxoz.galactic.bodies.*;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.dispatcher.Dispatcher;
import edu.narxoz.galactic.dispatcher.Result;
import edu.narxoz.galactic.drones.*;
import edu.narxoz.galactic.task.DeliveryTask;
import edu.narxoz.galactic.factory.DroneFactory;
import edu.narxoz.galactic.factory.CelestialFactory;
import edu.narxoz.galactic.factory.DefaultCelestialFactory;

public class MainDemo {
    public static void main(String[] args) {
        CelestialFactory factory=new DefaultCelestialFactory();
        Planet earth=factory.createPlanet();
        SpaceStation station=factory.createStation();
        Cargo heavyCargo=new Cargo(50, "Big box");
        Drone lightDrone=DroneFactory.createDrone("light", "LD-1", 10);
        Drone heavyDrone=DroneFactory.createDrone("heavy", "HD-1", 100);

        DeliveryTask task=new DeliveryTask(earth, station, heavyCargo);
        Dispatcher dispatcher=new Dispatcher();


        Result r1=dispatcher.assignTask(task, lightDrone);
        System.out.println("Light drone assign: " +r1.ok() + " | " + r1.reason());

        Result r2=dispatcher.assignTask(task, heavyDrone);
        System.out.println("Heavy drone assign: " +r2.ok());

        double time=task.estimateTime();
        System.out.println("Estimated time: " +time);

        Result r3=dispatcher.completeTask(task);
        System.out.println("Complete result: " +r3.ok());

        System.out.println("Drone status: " + heavyDrone.getStatus());
        System.out.println("Task state: " + task.getState());
    }
}

