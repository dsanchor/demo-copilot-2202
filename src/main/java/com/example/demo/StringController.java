package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/strings")
public class StringController {

    private static final Logger logger = LoggerFactory.getLogger(StringController.class);

    @GetMapping("/concat")
    public ResponseEntity<String> concat(@RequestParam String s1, @RequestParam String s2) {
        logger.info("Received request to concatenate strings: s1={}, s2={}", s1, s2);

        if (s1 == null || s1.isEmpty() || s2 == null || s2.isEmpty()) {
            logger.warn("Invalid input: s1={}, s2={}", s1, s2);
            return ResponseEntity.badRequest().build();
        }

        String result = s1 + s2;
        logger.info("Concatenated strings: result={}", result);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/substring")
    public ResponseEntity<String> substring(@RequestParam String s, @RequestParam int beginIndex,
            @RequestParam int endIndex) {
        logger.info("Received request to get substring: s={}, beginIndex={}, endIndex={}", s, beginIndex, endIndex);

        if (s == null || s.isEmpty() || beginIndex < 0 || endIndex < 0 || beginIndex > endIndex
                || endIndex > s.length()) {
            logger.warn("Invalid input: s={}, beginIndex={}, endIndex={}", s, beginIndex, endIndex);
            return ResponseEntity.badRequest().build();
        }

        String result = s.substring(beginIndex, endIndex);
        logger.info("Substring: result={}", result);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/contains")
    public ResponseEntity<Boolean> contains(@RequestParam String s, @RequestParam String substring) {
        logger.info("Received request to check if string contains substring: s={}, substring={}", s, substring);

        if (s == null || s.isEmpty() || substring == null || substring.isEmpty()) {
            logger.warn("Invalid input: s={}, substring={}", s, substring);
            return ResponseEntity.badRequest().build();
        }

        boolean result = s.contains(substring);
        logger.info("Contains substring: result={}", result);

        return ResponseEntity.ok(result);
    }

    // reemplazar strings
    @GetMapping("/replace")
    public ResponseEntity<String> replace(@RequestParam String s, @RequestParam String target,
            @RequestParam String replacement) {
        logger.info("Received request to replace string: s={}, target={}, replacement={}", s, target, replacement);

        if (s == null || s.isEmpty() || target == null || target.isEmpty() || replacement == null
                || replacement.isEmpty()) {
            logger.warn("Invalid input: s={}, target={}, replacement={}", s, target, replacement);
            return ResponseEntity.badRequest().build();
        }

        String result = s.replace(target, replacement);
        logger.info("Replaced string: result={}", result);

        return ResponseEntity.ok(result);
    }

}