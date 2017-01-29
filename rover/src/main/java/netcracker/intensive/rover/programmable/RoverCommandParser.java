package netcracker.intensive.rover.programmable;

import netcracker.intensive.rover.Point;
import netcracker.intensive.rover.command.*;
import netcracker.intensive.rover.constants.Direction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RoverCommandParser {
    private String file;
    private ProgrammableRover rover;

    public RoverCommandParser(ProgrammableRover rover, String path) {
        this.rover = rover;
        this.file = path;
    }

    public RoverProgram getProgram() {

        RoverProgram program = new RoverProgram();
        String filePath = null;
        try {
            filePath = this.getClass().getResource(file).getFile();
        } catch (NullPointerException e) {
            throw new RoverCommandParserException();
        }

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader buffer = new BufferedReader(fileReader)) {

            String line;
            while ((line = buffer.readLine()) != null) {
                String[] members = line.split("\\s+");
                if (members.length > 0) {
                    switch (members[0]) {

                        case RoverProgram.LOG: {
                            if (members[1].equals("on")) {
                                program.addSetting(RoverProgram.LOG, true);
                            } else if (members[1].equals("off")) {
                                program.addSetting(RoverProgram.LOG, false);
                            }
                            break;
                        }

                        case RoverProgram.STATS: {
                            if (members[1].equals("on")) {
                                program.addSetting(RoverProgram.STATS, true);
                            } else if (members[1].equals("off")) {
                                program.addSetting(RoverProgram.STATS, false);
                            }
                            break;
                        }

                        case RoverProgram.SEPARATOR: {

                            break;
                        }

                        case "move": {
                            MoveCommand moveCommand = new MoveCommand(rover);
                            if ((boolean) program.getSettings().get(RoverProgram.LOG)) {
                                program.addCommand(new LoggingCommand(moveCommand));
                            }
                            else{
                                program.addCommand(moveCommand);
                            }

                            break;
                        }

                        case "lift": {
                            program.addCommand(new LiftCommand(rover));
                            break;
                        }

                        case "land": {
                            Point point = new Point(Integer.parseInt(members[1]), Integer.parseInt(members[2]));
                            Direction direction = Direction.valueOf(members[3].toUpperCase());
                            program.addCommand(new LandCommand(rover, point, direction));
                            break;
                        }

                        case "turn": {
                            Direction direction = Direction.valueOf(members[1].toUpperCase());
                            program.addCommand(new TurnCommand(rover, direction));
                            break;
                        }

                        default: {
                            throw new RoverCommandParserException();
                        }
                    }
                }
            }

        } catch (IOException e) {
            throw new RoverCommandParserException(e);
        }

        return program;
    }

}
