class Animal {

    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

// Main class MUST match file name for safe execution
public class MethodOverridingDemo {

    public static void main(String[] args) {

        Animal obj1 = new Animal();
        obj1.sound();

        Animal obj2 = new Dog(); // runtime polymorphism
        obj2.sound();
    }
}