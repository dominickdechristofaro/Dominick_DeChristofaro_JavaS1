/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.04.2019
 *  Description:    Model for a word-of-the-day REST API. I have named the class Definition at the
 *                  direction of the summative instructions.  I believe a better name for the
 *                  class would be WordOfTheDay (or similar).
 *************************************************************************************************/
package com.company.QuoteWordMagicAPI.Model;

public class Definition {
    // Properties
    private String word;
    private String definition;

    // Getters & Setters
    public String getWord() {
        return this.word;
    }
    public void setWord(String wordIn) {
        this.word = wordIn;
    }
    public String getDefinition() {
        return this.definition;
    }
    public void setDefinition(String definitionIn) {
        this.definition = definitionIn;
    }
}
