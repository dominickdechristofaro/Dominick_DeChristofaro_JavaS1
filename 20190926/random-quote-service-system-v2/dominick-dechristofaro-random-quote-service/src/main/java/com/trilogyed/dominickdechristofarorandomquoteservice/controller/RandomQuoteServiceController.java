package com.trilogyed.dominickdechristofarorandomquoteservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class RandomQuoteServiceController {
    // Properties
    private List<String> quoteList = new ArrayList<>();
    private Random randomNumber = new Random();

    @Autowired
    private DiscoveryClient discoveryClient;
    @Value("${magicEightBallServiceName}")
    private String magicEightBallServiceName;
    @Value("${serviceProtocol}")
    private String serviceProtocol;
    @Value("${servicePath}")
    private String servicePath;
    private RestTemplate restTemplate = new RestTemplate();

    // Constructor
    public RandomQuoteServiceController() {
        quoteList.add("To me programming is more than an important practical art. It is also a gigantic undertaking in the foundations of knowledge. - Grace Hopper");
        quoteList.add("Programs must be written for people to read, and only incidentally for machines to execute. - Hal Ableson");
        quoteList.add("Don't call me the mother of the internet. - Radia Perlman");
        quoteList.add("When I first started using the phrase software engineering, it was considered to be quite amusing. They used to kid me about my radical ideas. Software eventually and necessarily gained the same respect as any other discipline. - Margaret Hamilton");
        quoteList.add("Machines take me by surprise with great frequency. - Alan Turing");
        quoteList.add("The function of good software is to make the complex appear simple. - Grady Booch");
        quoteList.add("An API that isn't comprehensible isn't usable. - James Gosling");
        quoteList.add("I'm not a great programmer; I'm just a good programmer with great habits. - Martin Fowler");
    }

    @RequestMapping(value="/quote", method = RequestMethod.GET)
    public String helloCloud() {
        // port: 2244
        int randomQuote = randomNumber.nextInt(8);
        return quoteList.get(randomQuote);
    }

    @RequestMapping(value = "/answerme", method = RequestMethod.GET)
    public String answerMe() {
        // port: 2244
        List<ServiceInstance> instances = discoveryClient.getInstances(magicEightBallServiceName);
        String magicEightBallServiceUri = serviceProtocol + instances.get(0).getHost() + ":" + instances.get(0).getPort() + servicePath;
        return restTemplate.getForObject(magicEightBallServiceUri, String.class);
    }
}