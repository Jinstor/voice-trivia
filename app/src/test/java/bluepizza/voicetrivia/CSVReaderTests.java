package bluepizza.voicetrivia;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

import bluepizza.voicetrivia.util.CSVReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * This is a unit test class. All methods marked with @Test will be runnable from the IDE.
 *
 * Unit tests are kind of like a console project you would create JUST to test your code. Every
 * time you'd test something different, you'd comment out or delete whatever's in that project.
 *
 * Sure, this works for small projects like college assignments but it quickly becomes a
 * clusterfuck in larger projects. What if there was a simple way to manage a BUNCH of console
 * applications used for testing your code? Enter unit tests. As you will see, I have a hard on for
 * unit tests.
 *
 * Unit tests aren't quite the same as console projects but they're much better at testing than
 * a console project could ever be. They're a fantastic way to organize test code and a Godsend
 * when debugging smaller parts of code. Heck, there's always an easy way to run them all in one
 * click; this is invaluable when checking if a change you've made has broken something else.
 */
public class CSVReaderTests {

    @Test
    public void isWorking() throws Exception
    {
        // A unit test consists of a method. If the method returns, the test passes. If an
        // exception is thrown and unhandled, the test fails. Unit tests have "assertions"
        // that simply throws an exception if certain conditions aren't fulfilled.
        //
        // For example, assertEquals(4, 2 + 2) will check if both parameters are equal. They are in
        // this case, the method will do nothing. However, assertEquals(3, 1+1) will throw an
        // exception and fail the test because the assertion is FALSE.

        // Here, we're loading a sample CSV file that is embedded within this project.
        InputStream stream = ClassLoader.getSystemResourceAsStream("sampleCSV");

        // Here's your CSVReader class in action:
        CSVReader reader = new CSVReader(new InputStreamReader(stream));

        String[] expected, actual;

        expected = new String[] {"question", "category", "right answer"};
        actual = reader.readCSVLine();
        Assert.assertArrayEquals(expected, actual);

        expected = new String[] {"\"In the game of cricket, which bird name means scoring no runs?\"", "Sports", "Duck"};
        actual = reader.readCSVLine();
        Assert.assertArrayEquals(expected, actual);

        expected = new String[] {"\"Which Capital City Is Home To \"Carrasco\" International Airport\"", "General", "Montevideo"};
        actual = reader.readCSVLine();
        Assert.assertArrayEquals(expected, actual);

        expected = new String[] {"\"Can your reader handle commas inside quotes, good sir?\"", "surprise motherfucker", "maybe"};
        actual = reader.readCSVLine();
        Assert.assertArrayEquals(expected, actual);
    }
}