package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.Rover;

/**
 * Этот класс должен уметь все то, что умеет обычный Rover, но при этом он еще должен уметь выполнять программы,
 * содержащиеся в файлах
 */
public class ProgrammableRover extends Rover implements ProgramFileAware {

    @Override
    public void executeProgramFile(String path) {

    }
}
