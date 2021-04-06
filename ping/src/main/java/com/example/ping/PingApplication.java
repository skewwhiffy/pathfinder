package com.example.ping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class PingApplication {

    public static void main(String[] args) {
        SpringApplication.run(PingApplication.class, args);
    }

    @GetMapping("/ping")
    public String sayHello(@RequestParam(value = "", defaultValue = "") String name) {
        return "pong";
    }

    @PostMapping("/greet")
    public String greet(@RequestBody GreetRequest greetRequest) {
        return "Hello " + greetRequest.name;
    }

    public static class GreetRequest {
        // TODO: Learn about immutable objects
        // TODO: Learn about Lombok
        public String name;
    }
}
