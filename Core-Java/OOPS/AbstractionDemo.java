abstract class Animal {

    // Abstract method (no body)
    abstract void sound();

    // Non-abstract method
    void sleep() {
        System.out.println("Animal is sleeping");
    }
}

// Child class
class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class AbstractionDemo {

    public static void main(String[] args) {

        Animal obj = new Dog(); // runtime polymorphism

        obj.sound();
        obj.sleep();
    }
}