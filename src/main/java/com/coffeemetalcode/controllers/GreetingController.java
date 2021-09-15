package com.coffeemetalcode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    @Autowired()
    Greeting greeting;

    AtomicLong counter = new AtomicLong();

    // @RequestMapping(value = "/greeting", method = RequestMethod.GET) // <-- more explicit
    @GetMapping("/greeting") // <-- more pre-fab
    public Greeting greeting(@RequestParam(value="name") String name) {
        greeting.setId(counter.incrementAndGet());
        greeting.setContent("I am learning Spring Boot with " + name);

        return greeting;
    }
}
