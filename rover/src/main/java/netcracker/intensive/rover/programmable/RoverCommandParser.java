package netcracker.intensive.rover.programmable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RoverCommandParser {
    private String path;

    public RoverCommandParser(String path) {
        this.path = path;
    }

    public void loadProgramFromFile() {

        try (FileReader fileReader = new FileReader(path);
             BufferedReader buffer = new BufferedReader(fileReader)) {

            String line;
            while ((line = buffer.readLine()) != null){



            }

        } catch (IOException e) {
            throw new RoverCommandParserException(e);
        }

    }

}
