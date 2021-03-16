package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkHours {

    public String minWork(String file) {
        Path path = Path.of(file);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            return processLines(reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

    private String processLines(BufferedReader reader) throws IOException {
        String result = null;
        int minHours = Integer.MAX_VALUE;
        String line;
        while ((line = reader.readLine()) != null) {
            String[] splitLine = line.split(",");
            if (Integer.parseInt(splitLine[1]) < minHours) {
                minHours = Integer.parseInt(splitLine[1]);
                result = splitLine[0] + ": " + splitLine[2];
            }
        }
        return result;
    }
}
