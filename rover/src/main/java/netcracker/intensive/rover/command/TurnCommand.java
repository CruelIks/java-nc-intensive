package netcracker.intensive.rover.command;

import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.constants.Direction;

public class TurnCommand implements RoverCommand {

    private Rover rover;
    private Direction direction;

    public TurnCommand(Rover rover, Direction direction) {
        this.rover = rover;
        this.direction = direction;
    }

    @Override
    public void execute() {

    }
}
