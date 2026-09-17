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
    @GetMapping("/api/time")
    public Map<String, Object> getTime(
            @RequestParam(defaultValue = "Asia/Almaty") String zone) {

        java.time.ZoneId zoneId = java.time.ZoneId.of(zone);
        java.time.ZonedDateTime time = java.time.ZonedDateTime.now(zoneId);

        return Map.of(
                "zone", zone,
                "time", time.toLocalDateTime().toString(),
                "offset", time.getOffset().toString()
        );
    }
    @GetMapping("/api/bmi")
    public BmiResult bmi(
            @RequestParam double weight,
            @RequestParam double height) {

        double bmi = weight / (height * height);

        String category;

        if (bmi < 18.5) {
            category = "Underweight";
        } else if (bmi < 25) {
            category = "Normal weight";
        } else if (bmi < 30) {
            category = "Overweight";
        } else {
            category = "Obesity";
        }

        return new BmiResult(weight, height, bmi, category);
    }

    public record BmiResult(
            double weight,
            double height,
            double bmi,
            String category
    ) {}
}
