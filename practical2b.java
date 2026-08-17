package practical2;

// Interface
interface Animal {
    void sound();
}

// Implementing class
class Dog implements Animal {
    public void sound() {
        System.out.println("Dog barks");
    }
}

// Implementing class
class Cat implements Animal {
    public void sound() {
        System.out.println("Cat meows");
    }
}

public class practical2b {

    public static void main(String[] args) {

        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.sound();
        a2.sound();
    }
}