package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; // Add this import statement
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content; // Add this import statement
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; // Add this import statement

@WebMvcTest(StringController.class)
public class StringControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testConcat() throws Exception {
        String s1 = "Hello";
        String s2 = "World";
        String expected = "HelloWorld";

        mockMvc.perform(get("/api/strings/concat")
                .param("s1", s1)
                .param("s2", s2))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    public void testConcatEmptyString() throws Exception {
        String s1 = "";
        String s2 = "World";

        mockMvc.perform(get("/api/strings/concat")
                .param("s1", s1)
                .param("s2", s2))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testConcatNullString() throws Exception {
        String s2 = "World";

        mockMvc.perform(get("/api/strings/concat")
                .param("s2", s2))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testSubstring() throws Exception {
        String s = "HelloWorld";
        int beginIndex = 2;
        int endIndex = 7;
        String expected = "lloWo";

        mockMvc.perform(get("/api/strings/substring")
                .param("s", s)
                .param("beginIndex", String.valueOf(beginIndex))
                .param("endIndex", String.valueOf(endIndex)))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    // test empty string
    @Test
    public void testSubstringEmptyString() throws Exception {
        String s = "";
        int beginIndex = 2;
        int endIndex = 7;

        mockMvc.perform(get("/api/strings/substring")
                .param("s", s)
                .param("beginIndex", String.valueOf(beginIndex))
                .param("endIndex", String.valueOf(endIndex)))
                .andExpect(status().isBadRequest());
    }

    // test null string
    @Test
    public void testSubstringNullString() throws Exception {
        int beginIndex = 2;
        int endIndex = 7;

        mockMvc.perform(get("/api/strings/substring")
                .param("beginIndex", String.valueOf(beginIndex))
                .param("endIndex", String.valueOf(endIndex)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testContains() throws Exception {
        String s = "HelloWorld";
        String substring = "World";
        boolean expected = true;

        mockMvc.perform(get("/api/strings/contains")
                .param("s", s)
                .param("substring", substring))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(expected)));
    }

    @Test
    public void testReplace() throws Exception {
        String s = "HelloWorld";
        String target = "World";
        String replacement = "Universe";
        String expected = "HelloUniverse";

        mockMvc.perform(get("/api/strings/replace")
                .param("s", s)
                .param("target", target)
                .param("replacement", replacement))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }
}