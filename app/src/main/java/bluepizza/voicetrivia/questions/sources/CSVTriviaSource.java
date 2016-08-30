/*
Author  : Jin
Owner   : Jin
Date    : 11-Aug-2016
 */

package bluepizza.voicetrivia.questions.sources;

import java.io.*;
import java.util.ArrayList;
import bluepizza.voicetrivia.questions.TriviaQuestion;
import bluepizza.voicetrivia.util.CSVReader;

/**
 * This is a CSV source of trivia.
 */
public class CSVTriviaSource {

    //region Variables

    /**
     * The total number of characters found within this source.
     */
    private long _totalCharCount;

    /**
     * The character positions at which questions start.
     */
    private ArrayList<Long> _questionPositions;

    /**
     * The name of this source.
     */
    private String _name;

    //endregion

    //region Initialization

    /**
     * Default CSVTriviaSource constructor. This will create an empty source. Do not use this thing,
     * it's just good measure for serialization.
     */
    public CSVTriviaSource() {
        _questionPositions = new ArrayList<>();
    }

    /**
     * Instantiates a new CSVTriviaSource.
     * @param path The full path to the trivia source.
     */
    public CSVTriviaSource(String path) throws IOException {
        _name = path;
        _questionPositions = new ArrayList<>();
        computeQuestionPositions();
    }

    //endregion

    //region Getters & Setters

    /**
     * Gets the character positions at which questions start.
     * @return The character positions at which questions start.
     */
    public ArrayList<Long> getQuestionPositions() {
        return _questionPositions;
    }

    //endregion

    //region Methods

    /**
     * Computes the character positions at which each question starts.
     * @throws IOException Could be thrown when attempting to read the file.
     */
    public void computeQuestionPositions() throws IOException {

        // This will read the ENTIRE file and save at which positions in the file you can find
        // newline characters; these will allow us to directly load a question from any point
        // in the CSV file without having to read the entire file. This will save storage space,
        // memory and CPU in the long run.

        long index = 0L;
        FileReader fr = null;

        _questionPositions.clear();
        _questionPositions.add(0L);    // Position of first question, duh!

        try {
            int result;
            fr = new FileReader(_name);

            do {
                result = fr.read();
                ++index;
                if (result == 10) _questionPositions.add(index + 1);
            } while (result != -1);

            _totalCharCount = index;
        }
        finally {
            if (fr != null) fr.close();
        }
    }

    /**
     * Reads a question from this source.
     * @param index The number of the question in this source.
     * @return A TriviaQuestion that defines the question.
     * @throws IOException Thrown if there is a problem reading the file.
     */
    public TriviaQuestion readQuestion(int index) throws IOException
    {
        FileReader fr = null;

        try {
            fr = new FileReader(_name);
            CSVReader reader = new CSVReader(fr);

            // Skip to the position where the CSV line starts and just read that line as CSV...
            // and chuck it into a TriviaQuestion object.
            reader.skip(_questionPositions.get(index));
            return new TriviaQuestion(this, reader.readCSVLine());
        }
        finally {
            if (fr != null) fr.close();
        }
    }

//endregion

}