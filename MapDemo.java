package com.mycompany.practical4;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(101, "Krishna");
        students.put(102, "Rahul");
        students.put(103, "Amit");

        System.out.println("Student Details:");

        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println("Roll No: " + entry.getKey()
                    + " Name: " + entry.getValue());
        }

        System.out.println("Student with Roll No 102: " + students.get(102));

        students.remove(103);

        System.out.println("After Removing Roll No 103:");
        System.out.println(students);
    }
}