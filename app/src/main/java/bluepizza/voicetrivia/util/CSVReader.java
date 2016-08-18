/*
Author  : ???
Owner   : ???
Date    : 17-Aug-2016
 */

package bluepizza.voicetrivia.util;

import java.io.*;

/**
 *
 */
public class CSVReader extends BufferedReader {

    // TODO: Document this constructor
    public CSVReader(Reader in, int sz) {
        super(in, sz);
    }

    // TODO: Document this constructor
    public CSVReader(Reader in) {
        super(in);
    }

    /**
     * Reads a line from the CSV file.
     * @return null if the end-of-file has been reached, otherwise an array consisting of each
     * comma-separated value.
     */
    public String[] readCSVLine() {
        // TODO: implement this method
        throw new RuntimeException("Method not implemented... yet.");
    }
}