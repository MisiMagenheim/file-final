package com.codecool.examresults;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class ExamResults {
    public static List<String> getStudentsNameOrderedByExamResultsAverageFromFile(String fileName){
        List<String> raw;
        List<Students> students = new ArrayList<>();
        try {
            raw = Files.readAllLines(Paths.get(fileName));
            for (int i = 0; i < raw.size(); i++) {
                students.add(getStudent(raw.get(i)));
            }
        } catch (IOException ioException) {
            System.out.println("File not found!");
        }
        return students.stream()
                .sorted(Comparator.comparingInt(Students::getPoint).reversed())
                .map(Students::getName)
                .collect(Collectors.toList());
    }

    private static Students getStudent(String line) {
        String[] studentExam = line.split(",");
        return new Students(studentExam[0],
                Integer.parseInt(studentExam[1])
                        + Integer.parseInt(studentExam[2])
                        + Integer.parseInt(studentExam[3]) / 3);
    }
        //TODO your code comes here

    }

