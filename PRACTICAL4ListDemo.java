package com.mycompany.practical4;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {

        List<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");

        System.out.println("List Elements:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        System.out.println("Second Element: " + fruits.get(1));

        fruits.remove("Banana");

        System.out.println("After Removing Banana:");
        System.out.println(fruits);
    }
}
