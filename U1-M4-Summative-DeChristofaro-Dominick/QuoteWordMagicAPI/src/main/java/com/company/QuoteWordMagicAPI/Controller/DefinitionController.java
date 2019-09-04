/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.04.2019
 *  Description:    Controller for the word-of-a-day REST API. Will generate and return a random
 *                  Definition every time the URI "/word" is accessed.  Definition consists of a
 *                  word (String) and definition (String).
 *************************************************************************************************/
package com.company.QuoteWordMagicAPI.Controller;

import com.company.QuoteWordMagicAPI.Model.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController     // Spring annotation for a REST Controller
public class DefinitionController {

    // Mapping the URI and declare the HTTP status when the method is executed
    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Definition wordOfTheDay() {
        // Instantiate Objects
        Definition definitionOfTheDay = new Definition();
        Random random = new Random();

        // Generate a random number between 0 and 9
        int randomNum = random.nextInt(10);

        // Assign a word and definition based on the random number generated.
        switch(randomNum) {
            case 0:
                definitionOfTheDay.setWord("luftmensch");
                definitionOfTheDay.setDefinition("an impractical contemplative person having no definite " +
                        "business or income");
                break;
            case 1:
                definitionOfTheDay.setWord("clarion");
                definitionOfTheDay.setDefinition("brilliantly clear; also loud and clear");
                break;
            case 2:
                definitionOfTheDay.setWord("silly season");
                definitionOfTheDay.setDefinition("a period (such as late summer) when the mass media often " +
                        "focus on trivial or frivolous matters for lack of major news stories");
                break;
            case 3:
                definitionOfTheDay.setWord("faze");
                definitionOfTheDay.setDefinition("to disturb the composure of");
                break;
            case 4:
                definitionOfTheDay.setWord("passim");
                definitionOfTheDay.setDefinition("in one place and another");
                break;
            case 5:
                definitionOfTheDay.setWord("totem");
                definitionOfTheDay.setDefinition("an object (such as an animal or plant) serving as the " +
                        "emblem of a family or clan and often as a reminder of its ancestry");
                break;
            case 6:
                definitionOfTheDay.setWord("ransack");
                definitionOfTheDay.setDefinition("to look through thoroughly in often a rough way");
                break;
            case 7:
                definitionOfTheDay.setWord("aggregate");
                definitionOfTheDay.setDefinition("a mass or body of units or parts somewhat loosely " +
                        "associated with one another");
                break;
            case 8:
                definitionOfTheDay.setWord("omnium-gatherum");
                definitionOfTheDay.setDefinition("a miscellaneous collection (as of things or persons)");
                break;
            case 9:
                definitionOfTheDay.setWord("balkanize");
                definitionOfTheDay.setDefinition("to break up (a region, a group, etc.) into smaller and " +
                        "often hostile units");
                break;
            default:
                System.out.println("Logic Error");
                break;
        }

        // Return the definition object
        return definitionOfTheDay;
    }
}
