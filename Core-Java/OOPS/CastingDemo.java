class Animal {

    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }

    void fetch() {
        System.out.println("Dog is fetching the ball");
    }
}

public class CastingDemo {

    public static void main(String[] args) {

        // UPCASTING (Child → Parent)
        Animal a = new Dog();
        a.sound(); // runtime polymorphism

        System.out.println("----------------");

        // DOWNCASTING (Parent → Child)
        Dog d = (Dog) a; // explicit casting
        d.sound();
        d.fetch();
    }
}