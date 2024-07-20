package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path path, Car car) throws IOException {
        var object = car.serialize();
        Files.write(path, object.getBytes(), StandardOpenOption.APPEND);
    }

    public static Car extract(Path path) throws IOException {
        String str = Files.readString(path);
        var result = Car.unserialize(str);
        return result;
    }
}
// END
