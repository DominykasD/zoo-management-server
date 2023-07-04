package com.example.intershipserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class IntershipServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntershipServerApplication.class, args);
    }

    @GetMapping(value = "/json/animals", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> getJsonAnimalsFile() throws IOException {
        String filePath = "resources/animals.json";
        byte[] fileBytes = Files.readAllBytes(Path.of(filePath));
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(fileBytes);
    }

    @GetMapping(value = "/json/enclosures", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<byte[]> getJsonEnclosuresFile() throws IOException {
        String filePath = "resources/enclosures.json";
        byte[] fileBytes = Files.readAllBytes(Path.of(filePath));
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(fileBytes);
    }
}
