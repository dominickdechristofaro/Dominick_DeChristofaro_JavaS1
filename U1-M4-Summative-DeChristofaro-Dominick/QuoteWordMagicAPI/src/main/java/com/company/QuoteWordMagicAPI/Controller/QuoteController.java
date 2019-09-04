/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.04.2019
 *  Description:    Controller for the quote-of-a-day REST API. Will generate and return a random
 *                  Quote every time the URI "/quote" is accessed.  Quote consists of a quote (String)
 *                  and author (String).
 *************************************************************************************************/
package com.company.QuoteWordMagicAPI.Controller;

import com.company.QuoteWordMagicAPI.Model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

// Spring annotation to declare a class a REST controller
@RestController
public class QuoteController {

    // Mapping the URI and declare the HTTP status when the method is ran
    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Quote quoteOfTheDay() {
        // Instantiate Objects
        Quote quoteOfTheDay = new Quote();
        Random random = new Random();

        // Generate a random number between 0 and 9
        int randomNum = random.nextInt(10);

        // Assign an author and quote based on the random number generated.
        switch(randomNum) {
            case 0:
                quoteOfTheDay.setAuthor("Dita Von Teese");
                quoteOfTheDay.setQuote("Some days are just bad days, that's all. You have to " +
                        "experience sadness to know happiness, and I remind myself that not every " +
                        "day is going to be a good day, that's just the way it is!");
                break;
            case 1:
                quoteOfTheDay.setAuthor("Karan Patel");
                quoteOfTheDay.setQuote("I don't go by or change my attitude based on what people " +
                        "say. At the end of the day, they, too, are judging me from their perspective. " +
                        "I would rather be myself and let people accept me for what I am then be " +
                        "somebody who I am not, just because I want people's approval.");
                break;
            case 2:
                quoteOfTheDay.setAuthor("Nadia Comaneci");
                quoteOfTheDay.setQuote("Enjoy the journey and try to get better every day. And don't " +
                        "lose the passion and the love for what you do.");
                break;
            case 3:
                quoteOfTheDay.setAuthor("Eleanor Roosevelt");
                quoteOfTheDay.setQuote("With the new day comes new strength and new thoughts.");
                break;
            case 4:
                quoteOfTheDay.setAuthor("Gretchen Bleiler");
                quoteOfTheDay.setQuote("Life is short, and if we enjoy every moment of every day, then " +
                        "we will be happy no matter what happens or what changes along the way.");
                break;
            case 5:
                quoteOfTheDay.setAuthor("Prince");
                quoteOfTheDay.setQuote("Every day I feel is a blessing from God. And I consider it a new " +
                        "beginning. Yeah, everything is beautiful.");
                break;
            case 6:
                quoteOfTheDay.setAuthor("Bradley Whitford");
                quoteOfTheDay.setQuote("I was at the vice president's Christmas party. I thought that his " +
                        "speech was spectacular, and I knew that it was a very emotional and difficult " +
                        "thing for him to do, but I admonished him for not waiting just one more stinking day.");
                break;
            case 7:
                quoteOfTheDay.setAuthor("Joel Osteen");
                quoteOfTheDay.setQuote("Every day we have plenty of opportunities to get angry, stressed, or " +
                        "offended. But what you're doing when you indulge these negative emotions is giving " +
                        "something outside yourself power over your happiness. You can choose to not let " +
                        "little things upset you.");
                break;
            case 8:
                quoteOfTheDay.setAuthor("Rachel Boston");
                quoteOfTheDay.setQuote("Keep looking up! I learn from the past, dream about the future and " +
                        "look up. There's nothing like a beautiful sunset to end a healthy day.");
                break;
            case 9:
                quoteOfTheDay.setAuthor("Erin Cummings");
                quoteOfTheDay.setQuote("At the end of the day, you are solely responsible for your success " +
                        "and your failure. And the sooner you realize that, you accept that, and integrate " +
                        "that into your work ethic, you will start being successful. As long as you blame " +
                        "others for the reason you aren't where you want to be, you will always be a failure.");
                break;
            default:
                System.out.println("Logic Error");
                break;
        }

        // Return the quote object
        return quoteOfTheDay;
    }
}
