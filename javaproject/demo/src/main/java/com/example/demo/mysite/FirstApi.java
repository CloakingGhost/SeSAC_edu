package com.example.demo.mysite;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstApi {

    @GetMapping("/")
    public String magePage() {
        return "Hello Spring";
    }
    @GetMapping("/hello")
    public String helloPage() {
        return "Hello User";
    }

}
