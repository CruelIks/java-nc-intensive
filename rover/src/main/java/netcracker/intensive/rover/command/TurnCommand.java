package netcracker.intensive.rover.command;

import netcracker.intensive.rover.programmable.ProgrammableRover;

public class TurnCommand implements RoverCommand {

    private ProgrammableRover rover;

    public TurnCommand(ProgrammableRover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {

    }
}
