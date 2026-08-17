package practical2;

// Abstract class
abstract class Shape {
    abstract void draw();
}

// Subclass 1
class Circle extends Shape {
    void draw() {
        System.out.println("Drawing Circle");
    }
}

// Subclass 2
class Rectangle extends Shape {
    void draw() {
        System.out.println("Drawing Rectangle");
    }
}

public class PRACTICAL2 {

    public static void main(String[] args) {

        Shape s1 = new Circle();
        Shape s2 = new Rectangle();

        s1.draw();
        s2.draw();
    }
}