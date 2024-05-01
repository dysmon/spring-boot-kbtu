package kz.kbtu.backend.controller;

import kz.kbtu.backend.model.Greeting;
import kz.kbtu.backend.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    GreetingService greetingService = new GreetingService();
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return greetingService.generateGreeting(name);
    }
}
