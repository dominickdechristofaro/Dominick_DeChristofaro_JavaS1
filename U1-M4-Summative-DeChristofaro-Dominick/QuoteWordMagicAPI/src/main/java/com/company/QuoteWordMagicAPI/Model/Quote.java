/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.04.2019
 *  Description:    Model for a quote-of-a-day REST API. I named the class Quote at the direction
 *                  of the summative instructions.  I believe a better class name would be
 *                  QuoteOfTheDay (or similar).
 *************************************************************************************************/
package com.company.QuoteWordMagicAPI.Model;

public class Quote {
    // Properties
    private String author;
    private String quote;

    // Getters & Setters
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor(String authorIn) {
        this.author = authorIn;
    }
    public String getQuote() {
        return this.quote;
    }
    public void setQuote(String quoteIn) {
        this.quote = quoteIn;
    }
}
