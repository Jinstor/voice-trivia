/*
Author  : Jin (actually auto-generated)
Owner   : Jin
Date    : 11-Aug-2016
 */

package bluepizza.voicetrivia.questions;

import java.util.ArrayList;

/**
 * Contains the definition of a trivia question...
 */
public class QuestionDefinition
{

    //region Variables

    /**
     * The maximum number of possible answers.
     */
    public static final int MAX_ANSWERS = 4;

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

    //endregion

    //region Initialization

    /**
     * Instantiates a new Question.
     * @param question The question string.
     * @param rightAnswer The right answer to the question.
     * @param wrongAnswers Wrong answers to the questions.
     */
    public QuestionDefinition(String question, String rightAnswer, ArrayList<String> wrongAnswers)
    {
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.wrongAnswers = wrongAnswers;
    }

    //endregion

    //region Methods

    /**
     * Generates a set of answers for this question.
     * @return An AnswerSet containing the generated answers.
     */
    public AnswerSet generateAnswers()
    {
        return new AnswerSet(this);
    }

    //endregion

}