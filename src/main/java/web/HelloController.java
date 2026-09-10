package it1sso2503is.springlab01.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello, Spring Boot!";
    }

    @GetMapping("/api/hello")
    public String helloApi(
            @RequestParam(defaultValue = "IITU") String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/api/info")
    public Map<String, Object> info() {
        return Map.of(
                "message", "Hello, IITU!",
                "owner", "Renatuly Anuar, IT1SSO-2503IS",
                "timestamp", LocalDateTime.now().toString()
        );
    }
}