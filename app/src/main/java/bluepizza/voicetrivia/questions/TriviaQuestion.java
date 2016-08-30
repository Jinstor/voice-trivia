/*
Author  : Jin
Owner   : Jin
Date    : 11-Aug-2016
 */

package bluepizza.voicetrivia.questions;

import bluepizza.voicetrivia.questions.sources.*;
import java.util.ArrayList;

/**
 * Contains the definition of a trivia question.
 */
public class TriviaQuestion {

    //region Variables

    /**
     * The maximum number of possible answers.
     */
    public static final int MAX_ANSWERS = 4;

    /**
     * The trivia source from which this question is coming from.
     */
    public final CSVTriviaSource source;

    /**
     * The question string.
     */
    public final String question;

    /**
     * The right answer to the question.
     */
    public final String rightAnswer;

    /**
     * Wrong answers to the questions.
     */
    public final ArrayList<String> wrongAnswers;

    /**
     * The question's hash code. This is used to determine equality.
     */
    public final long hashCode;

    //endregion

    //region Initialization

    /**
     * Instantiates a new Question.
     * @param source The trivia source from which this question is coming from.
     * @param question The question string.
     * @param rightAnswer The right answer to the question.
     * @param wrongAnswers Wrong answers to the questions.
     */
    public TriviaQuestion(
            CSVTriviaSource source, String question, String rightAnswer,
            ArrayList<String> wrongAnswers) {
        this.source = source;
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.wrongAnswers = wrongAnswers;
        this.hashCode = hashCode64(question);
    }

    /**
     * Instantiates a new Question.
     * @param source The trivia source from which this question is coming from.
     * @param values An array containing parsed CSV values of a question.
     */
    public TriviaQuestion(CSVTriviaSource source, String[] values) {
        this.source = source;
        this.question = values[0];
        this.rightAnswer = values[2];
        this.wrongAnswers = new ArrayList<String>();

        for (int i = 3; i < values.length; ++i)
            wrongAnswers.add(values[i]);

        this.hashCode = hashCode64(question);

    }

    //endregion

    //region Methods

    /**
     * Ripped from
     * http://stackoverflow.com/questions/1660501/what-is-a-good-64bit-hash-function-in-java-for-textual-strings
     * @param question The question string.
     * @return A 64-bit hash that probably won't have any collisions..!
     */
    public static long hashCode64(String question) {
        long h = 1125899906842597L; // prime
        int len = question.length();

        for (int i = 0; i < len; i++) {
            h = 31*h + question.charAt(i);
        }

        return h;
    }

    /**
     * Generates a set of answers for this question.
     * @return An AnswerSet containing the generated answers.
     */
    public AnswerSet generateAnswers()
    {
        return new AnswerSet(this);
    }

    /**
     * Checks if this question's hash matches a hash.
     * @param hashCode The hash code to compare to.
     * @return If this question's hash matches the provided hash.
     */
    public boolean hashEquals(long hashCode) {
        return this.hashCode == hashCode;
    }

    //endregion

}