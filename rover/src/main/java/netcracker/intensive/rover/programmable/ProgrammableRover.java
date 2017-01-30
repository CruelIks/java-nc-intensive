package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.GroundVisor;
import netcracker.intensive.rover.Rover;
import netcracker.intensive.rover.command.RoverCommand;
import netcracker.intensive.rover.stats.SimpleRoverStatsModule;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Этот класс должен уметь все то, что умеет обычный Rover, но при этом он еще должен уметь выполнять программы,
 * содержащиеся в файлах
 */
public class ProgrammableRover extends Rover implements ProgramFileAware {

    private SimpleRoverStatsModule statsModule;
    private final Map<String, Object> settings = new HashMap<>();


    public ProgrammableRover(GroundVisor groundVisor, SimpleRoverStatsModule statsModule) {
        super(groundVisor);
        this.statsModule = statsModule;
    }

    @Override
    public void executeProgramFile(String path) {
        RoverProgram program = new RoverCommandParser(this, path).getProgram();
        settings.putAll(program.getSettings());

        for (RoverCommand roverCommand : program.getCommands()){
            roverCommand.execute();
        }

    }

    @Override
    public void move() {
        super.move();

        if (settings.containsKey(RoverProgram.STATS)){
            if ((boolean)settings.get(RoverProgram.STATS)){
                statsModule.registerPosition(getCurrentPosition());
            }
        }
    }

    public Map<String, Object> getSettings() {
        return Collections.unmodifiableMap(settings);
    }
}
