package com.mycompany.practical4;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {

        Set<String> colors = new HashSet<>();

        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Blue");   // Duplicate

        System.out.println("Set Elements:");
        System.out.println(colors);

        colors.remove("Green");

        System.out.println("After Removing Green:");
        System.out.println(colors);
    }
}
