package com.dechristofaro.dominickdechristofaromagiceightballservice.controller;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class MagicEightBallServiceController {
    // Properties
    private List<String> magicEightBallList = new ArrayList<>();
    private Random randomNumber = new Random();

    // Constructor
    public MagicEightBallServiceController() {
        magicEightBallList.add("No");
        magicEightBallList.add("Yes");
        magicEightBallList.add("Looking cloudy");
        magicEightBallList.add("Not sure");
        magicEightBallList.add("Absolutely!");
        magicEightBallList.add("Ask again");
        magicEightBallList.add("Ummm");
        magicEightBallList.add("Not a chance");
    }

    @RequestMapping(value = "/eightballanswer", method = RequestMethod.GET)
    public String getRandomEightBallAnswer() {
        // port: 3344
        int randomEightBallAnswer = randomNumber.nextInt(8);
        return magicEightBallList.get(randomEightBallAnswer);
    }
}
