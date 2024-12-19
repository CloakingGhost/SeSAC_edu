package org.example.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Student {
    private static int studentNum = 1;

    private final int id;
    private String name;
    private int age;
    private final Map<String, Integer> subjects;

    public Student(String name, int age) {
        this.id = studentNum++;
        this.name = name;
        this.age = age;
        this.subjects = new HashMap<>();
    }

    public void addSubject(String subject, int score) {
        subjects.put(subject, score);
    }

    public double averageSubjectScore() {
        Optional<Integer> sum = subjects.values().stream().reduce(Integer::sum);
        return sum.map(integer -> (double) integer / subjects.size()).orElse(-1.0);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", subjects=" + subjects +
                ", Score Average=" + averageSubjectScore() +
                '}';
    }
}
