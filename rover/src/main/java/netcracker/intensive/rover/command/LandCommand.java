package netcracker.intensive.rover.command;

import netcracker.intensive.rover.programmable.ProgrammableRover;

public class LandCommand implements RoverCommand {

    private ProgrammableRover rover;

    public LandCommand(ProgrammableRover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {

    }
}
