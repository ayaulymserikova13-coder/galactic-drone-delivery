package edu.narxoz.galactic.dispatcher;

import edu.narxoz.galactic.drones.Drone;
import edu.narxoz.galactic.drones.DroneStatus;
import edu.narxoz.galactic.task.DeliveryTask;
import edu.narxoz.galactic.task.TaskState;

public class Dispatcher {

    public Result assignTask(DeliveryTask task, Drone drone) {

        if (task == null || drone == null) {
            return new Result(false, "task or drone is null");
        }

        if (drone.getStatus() != DroneStatus.IDLE) {
            return new Result(false, "drone not IDLE");
        }

        if (task.getCargo().getWeightKg() > drone.getMaxPayloadKg()) {
            return new Result(false, "cargo too heavy");
        }

        if (task.getState() != TaskState.CREATED) {
            return new Result(false, "task not CREATED");
        }

        task.setAssignedDrone(drone);
        task.setState(TaskState.ASSIGNED);
        drone.setStatus(DroneStatus.IN_FLIGHT);

        return new Result(true, "");
    }

    public Result completeTask(DeliveryTask task) {

        if (task == null) {
            return new Result(false, "task is null");
        }

        if (task.getState() != TaskState.ASSIGNED) {
            return new Result(false, "task not ASSIGNED");
        }

        if (task.getAssignedDrone() == null) {
            return new Result(false, "no drone");
        }

        if (task.getAssignedDrone().getStatus() != DroneStatus.IN_FLIGHT) {
            return new Result(false, "drone not IN_FLIGHT");
        }

        task.setState(TaskState.DONE);
        task.getAssignedDrone().setStatus(DroneStatus.IDLE);

        return new Result(true, "");
    }
}

