import exercise.exercise3.Exercise3;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

/**
 * Created by Radu.Hoaghe on 4/20/2015.
 */
public class Exercise3Test {
    private Exercise3 exercise3;
    private String[] stringsToAddToSet = {"A", "collection", "that", "contains", "no", "duplicate", "elements", "."};

    @Before
    public void setUp() throws Exception {
        exercise3 = new Exercise3(Arrays.asList(stringsToAddToSet));

    }

    @Test
    public void testExercise3() throws Exception {
        exercise3.addElementsToSets();

        // 2 1 3 2
    }
}
