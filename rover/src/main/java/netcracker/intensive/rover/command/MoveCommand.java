package netcracker.intensive.rover.command;

import netcracker.intensive.rover.programmable.ProgrammableRover;

public class MoveCommand implements RoverCommand {

    private ProgrammableRover rover;

    public MoveCommand(ProgrammableRover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.move();
    }
}
