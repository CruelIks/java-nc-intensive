package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.constants.Direction;

public class LandCommand implements RoverCommand {

    private Rover rover;
    private Point position;
    private Direction direction;

    public LandCommand(Rover rover, Point position, Direction direction) {
        this.rover = rover;
        this.position = position;
        this.direction = direction;
    }

    @Override
    public void execute() {
        rover.land(position, direction);
    }
}
