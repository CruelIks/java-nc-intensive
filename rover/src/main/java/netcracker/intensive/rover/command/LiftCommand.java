package netcracker.intensive.rover.command;

import netcracker.intensive.rover.programmable.ProgrammableRover;

public class LiftCommand implements RoverCommand {

    private ProgrammableRover rover;

    public LiftCommand(ProgrammableRover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.lift();
    }
}
