package com.example.HelloWebService.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWebServiceController {

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String helloName(@PathVariable String name) {
        return "Hello " + name;
    }
}
