package netcracker.intensive.rover.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingCommand implements RoverCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingCommand.class);

    private RoverCommand roverCommand;

    public LoggingCommand(RoverCommand roverCommand) {
        this.roverCommand = roverCommand;
    }

    @Override
    public void execute() {
        LOGGER.debug(roverCommand.toString());
        roverCommand.execute();
    }

    @Override
    public String toString() {
        return roverCommand.toString();
    }
}
