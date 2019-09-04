/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.04.2019
 *  Description:    Model for a magic 8 ball (question and answer) REST API.  I have named the
 *                  class Answer at the direction of the summative instructions.  I think a better
 *                  name for the class would be Magic8Ball.
 *************************************************************************************************/
package com.company.QuoteWordMagicAPI.Model;
import javax.validation.constraints.NotNull;

public class Answer {
    // Properties
    @NotNull(message = "You must enter a question for the magic 8 ball.")
    private String question;
    private String answer;

    // Getters & Setters
    public String getQuestion() {
        return this.question;
    }
    public void setQuestion(String questionIn) {
        this.question = questionIn;
    }
    public String getAnswer() {
        return this.answer;
    }
    public void setAnswer(String answerIn) {
        this.answer = answerIn;
    }
}
