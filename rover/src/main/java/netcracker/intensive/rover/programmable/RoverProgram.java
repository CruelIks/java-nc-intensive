package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.command.RoverCommand;

import java.util.*;

public class RoverProgram {
    public static final String LOG = "log";
    public static final String STATS = "stats";
    public static final String SEPARATOR = "===";

    private final Map<String, Object> settings = new HashMap<>();
    private final Collection<RoverCommand> commands = new ArrayList<>();

    public Map<String, Object> getSettings() {
        return settings;
    }

    public Collection<RoverCommand> getCommands() {
        return commands;
    }
}
