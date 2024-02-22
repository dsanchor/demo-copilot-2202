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

        if (s == null || s.isEmpty() || beginIndex < 0 || beginIndex >= s.length() || endIndex < 0
                || endIndex > s.length() || beginIndex > endIndex) {
            logger.warn("Invalid input: s={}, beginIndex={}, endIndex={}", s, beginIndex, endIndex);
            return ResponseEntity.badRequest().build();
        }

        String result = s.substring(beginIndex, endIndex);
        logger.info("Substring: result={}", result);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/contains")
    public ResponseEntity<Boolean> contains(@RequestParam String s, @RequestParam String searchStr) {
        logger.info("Received request to check if string contains substring: s={}, searchStr={}", s, searchStr);

        if (s == null || s.isEmpty() || searchStr == null || searchStr.isEmpty()) {
            logger.warn("Invalid input: s={}, searchStr={}", s, searchStr);
            return ResponseEntity.badRequest().build();
        }

        boolean result = s.contains(searchStr);
        logger.info("Contains: result={}", result);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/replace")
    public ResponseEntity<String> replace(@RequestParam String s, @RequestParam String oldStr,
            @RequestParam String newStr) {
        logger.info("Received request to replace substring: s={}, oldStr={}, newStr={}", s, oldStr, newStr);

        if (s == null || s.isEmpty() || oldStr == null || oldStr.isEmpty() || newStr == null) {
            logger.warn("Invalid input: s={}, oldStr={}, newStr={}", s, oldStr, newStr);
            return ResponseEntity.badRequest().build();
        }

        String result = s.replace(oldStr, newStr);
        logger.info("Replaced: result={}", result);

        return ResponseEntity.ok(result);
    }
}