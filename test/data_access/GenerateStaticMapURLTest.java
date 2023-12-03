package data_access;

import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.*;

public class GenerateStaticMapURLTest {
    @Test
    public void getMap() throws IOException {
        String[] coordinates = CoordinatesFromIP.getCoordinates();
        assert(coordinates.length == 2);
        String formattedCoordinates = coordinates[0] + "," + coordinates[1];
        GenerateStaticMapURL newGenerator = new GenerateStaticMapURL();
        HashMap<Integer, String> otherCoordinates = new HashMap<>();
        otherCoordinates.put(0, formattedCoordinates);
        BufferedImage image = newGenerator.generateMap(formattedCoordinates, otherCoordinates, "500,500");
        assert(!(image == null));
    }
}