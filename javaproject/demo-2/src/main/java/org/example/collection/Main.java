package org.example.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(30);
        list.add(20);
        list.add(10);

        Optional<Integer> reduce = list.stream().reduce(Integer::sum);
        System.out.println("reduce = " + reduce.get());
        System.out.println();

        StudentManager.getStudents();
        System.out.println();
        StudentManager.searchStudent("limbo");
        System.out.println();
        StudentManager.deleteStudent(1);
        StudentManager.getStudents();

        Student s1 = new Student("s1", 14);
        StudentManager.addStudent(s1);
        StudentManager.getStudents();
        System.out.println();
        s1.addSubject("프랑스어", 30);
        StudentManager.getStudents();



    }
}
