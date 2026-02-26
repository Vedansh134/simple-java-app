package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController  // This makes this class handle web requests
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("=================================");
        System.out.println("🚀 Hello DevOps App Started!");
        System.out.println("📝 Open: http://localhost:3000");
        System.out.println("=================================");
    }

    @GetMapping("/")
    public String home() {
        return "👋 Hello DevOps! CI/CD Pipeline is working!";
    }

    @GetMapping("/health")
    public String health() {
        return "✅ App is healthy! Version: 1.0.0";
    }

    @GetMapping("/info")
    public String info() {
        return "📦 Simple Java App for DevOps Pipeline Practice";
    }
}