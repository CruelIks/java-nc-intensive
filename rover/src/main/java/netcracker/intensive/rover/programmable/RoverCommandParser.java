package netcracker.intensive.rover.programmable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RoverCommandParser {
    private String path;
    private ProgrammableRover rover;

    public RoverCommandParser(ProgrammableRover rover, String path) {
        this.rover = rover;
        this.path = path;
    }

    public RoverProgram getProgram() {

        try (FileReader fileReader = new FileReader(path);
             BufferedReader buffer = new BufferedReader(fileReader)) {

            String line;
            while ((line = buffer.readLine()) != null){



            }

        } catch (IOException e) {
            throw new RoverCommandParserException(e);
        }
        return null;
    }

}
