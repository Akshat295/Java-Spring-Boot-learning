interface Animal {

    void sound(); // abstract method

    void sleep();
}

class Dog implements Animal {

    @Override
    public void sound() {
        System.out.println("Dog barks");
    }

    @Override
    public void sleep() {
        System.out.println("Dog sleeps");
    }
}

public class InterfacesDemo {

    public static void main(String[] args) {

        Animal a = new Dog(); // upcasting using interface

        a.sound();
        a.sleep();
    }
}