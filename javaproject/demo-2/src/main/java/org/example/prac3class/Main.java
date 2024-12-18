package org.example.prac3class;

import org.example.prac3class.classes.Coffee;

import static java.lang.Math.abs;
import static org.example.prac3class.classes.Bread.*;

public class Main {
    public static void main(String[] args) {
        Coffee.taste();
        taste();

        int abs = abs(-24);
        System.out.println("abs = " + abs);
    }
}
