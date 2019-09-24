package com.trilogyed.dominickdechristofarorandomquoteservice.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

@RestController
@RefreshScope
public class RandomQuoteServiceController {

    @Value("${quote}")
    private String quote;

    @RequestMapping(value="/quote", method = RequestMethod.GET)
    public String helloCloud() {
        Random random = new Random();
        int randomNum = random.nextInt(8);
        String[] quoteList = quote.split("~");
        return quoteList[randomNum];
    }
}