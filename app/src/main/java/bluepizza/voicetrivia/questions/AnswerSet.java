/*
Author  : Jin (actually auto-generated)
Owner   : Jin
Date    : 11-Aug-2016
 */

package bluepizza.voicetrivia.questions;

import java.util.ArrayList;
import java.util.Random;

/**
 * Contains a set of answers for a question.
 */
public class AnswerSet extends ArrayList<String>
{

    //region Variables

    /**
     * Random object used by this class.
     */
    public static final Random random;

    /**
     * The question definition from where the answers are coming from.
     */
    public final TriviaQuestion questionDefinition;

    /**
     * The index at which the right answer is found.
     */
    public final int rightAnswerIndex;

    //endregion

    //region Initialization

    /**
     * Type initializer. This is called when the class is first
     * referenced.
     */
    static
    {
        random = new Random();
    }

    /**
     * Instantiates a new AnswerSet.
     * @param questionDefinition The question definition from where the answers are coming from.
     */
    public AnswerSet(TriviaQuestion questionDefinition)
    {
        super(
            Math.min(
                questionDefinition.wrongAnswers.size() + 1, TriviaQuestion.MAX_ANSWERS));
        this.questionDefinition = questionDefinition;

        // Set the correct answer to a random index within the
        // answers list
        rightAnswerIndex = random.nextInt(questionDefinition.wrongAnswers.size() + 1);
        this.set(rightAnswerIndex, questionDefinition.rightAnswer);

        // Now just fill the rest of the answers with random
        // wrong answers
        ArrayList<Integer> wrongAnswerIndexes =
            new ArrayList<Integer>(questionDefinition.wrongAnswers.size());

        for (int i = 0; i < wrongAnswerIndexes.size(); ++i)
        {
            wrongAnswerIndexes.set(i, i);
        }

        for (int i = 0; i < this.size(); ++i)
        {
            // If we're at the correct answer index, move on
            if (i == rightAnswerIndex)
                continue;

            int wrongIndex =
                wrongAnswerIndexes.remove(random.nextInt(wrongAnswerIndexes.size()));
            this.set(i, questionDefinition.wrongAnswers.get(wrongIndex));
        }
    }

    //endregion

}