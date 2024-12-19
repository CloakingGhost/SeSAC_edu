package org.example.collection;

import java.util.*;

public  class StudentManager {
    private static final Map<Integer, Student> studentMap;

    static {
        studentMap = new HashMap<>();

        Student limbo = new Student("limbo", 17);
        limbo.addSubject("국어", 80);
        limbo.addSubject("수학", 40);
        limbo.addSubject("과학", 70);


        Student windy = new Student("windy", 17);
        windy.addSubject("국어", 90);
        windy.addSubject("수학", 50);
        windy.addSubject("과학", 40);


        studentMap.put(limbo.getId(), limbo);
        studentMap.put(windy.getId(), windy);
    }

    public static void addStudent(Student student) {
        studentMap.put(student.getId(), student);
    }

    public static boolean deleteStudent(Integer id) {
        if (studentMap.containsKey(id)) {
            studentMap.remove(id);
            return true;
        }
        return false;
    }

    public static void getStudents() {
        studentMap.values().forEach(System.out::println);
    }

    public static void searchStudent(Integer id) {
        System.out.println(studentMap.get(id));
    }

    public static void searchStudent(String name) {
        display(searchStudents(name));
    }

    private static void display(List<Student> students) {
        students.forEach(System.out::println);
    }

    private static List<Student> searchStudents(String name) {
        return studentMap.values().stream().filter(student -> student.getName().equals(name)).toList();
    }


}
