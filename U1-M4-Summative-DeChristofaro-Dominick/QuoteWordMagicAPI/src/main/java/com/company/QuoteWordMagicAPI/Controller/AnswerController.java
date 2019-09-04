/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.04.2019
 *  Description:    Controller for the magic 8 ball REST API. Will generate and return a random
 *                  Answer every time the URI "/magic" is accessed.  Answer consists of a question (String)
 *                  and answer (String).
 *************************************************************************************************/
package com.company.QuoteWordMagicAPI.Controller;

import com.company.QuoteWordMagicAPI.Model.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Random;

// Spring annotation to declare a class a REST controller
@RestController
public class AnswerController {

    // Mapping the URI and declare the HTTP status when the method is executed
    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Answer magic8Ball(@RequestBody @Valid Answer question) {
        // Instantiate Objects
        Answer magic8Ball = new Answer();
        Random random = new Random();

        // Generate a random number between 0 and 5
        int randomNum = random.nextInt(6);

        // Set the question for the magic8Ball object to the question
        // input by the user in the Request Body
        magic8Ball.setQuestion(question.getQuestion());

        // Assign an answer for magic8Ball based on the random number generated
        switch(randomNum) {
            case 0:
                magic8Ball.setAnswer("MY REPLY IS NO!");
                break;
            case 1:
                magic8Ball.setAnswer("DON'T COUNT ON IT!");
                break;
            case 2:
                magic8Ball.setAnswer("AS I SEE IT, YES!");
                break;
            case 3:
                magic8Ball.setAnswer("MOST LIKELY!");
                break;
            case 4:
                magic8Ball.setAnswer("OUTLOOK GOOD!");
                break;
            case 5:
                magic8Ball.setAnswer("YES DEFINITELY!");
                break;
            default:
                System.out.println("Logic Error");
                break;
        }

        // Return the magic8Ball object
        return magic8Ball;
    }
}
