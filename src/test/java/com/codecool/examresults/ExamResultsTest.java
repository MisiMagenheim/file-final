package com.codecool.examresults;

import cccr.CCCRTestExecutionListener;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({CCCRTestExecutionListener.class})
class ExamResultsTest {

    @Test
    void getStudentsNameOrderedByExamResultsAverageReturnsCorrectList(){
        List<String> expected = Arrays.asList(
                "Gottfried Wilhelm Leibniz",
                "Alan Turing",
                "Isaac Newton",
                "Marie Curie",
                "Barbara Liskov",
                "Albert Einstein",
                "Nikola Tesla",
                "Ada Lovelace",
                "Robert C. Martin",
                "Linus Torvalds",
                "James Clerk Maxwell");
        List<String> results = ExamResults.getStudentsNameOrderedByExamResultsAverageFromFile("src/main/resources/results.txt");
        assertEquals(expected,results);
    }

    @Test
    void correctErrorMessageForFileNotFound(){
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        ExamResults.getStudentsNameOrderedByExamResultsAverageFromFile("src/main/resources/notExisting.txt");
        assertEquals("File not found!",outputStreamCaptor.toString()
                .trim());
    }
}