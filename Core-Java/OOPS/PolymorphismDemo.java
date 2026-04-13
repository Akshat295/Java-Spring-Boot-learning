class Shape {

    // Method Overloading (Compile-time polymorphism)
    void draw() {
        System.out.println("Drawing a shape");
    }

    void draw(String type) {
        System.out.println("Drawing a " + type);
    }
}

// Runtime Polymorphism (Method Overriding)
class Circle extends Shape {

    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

public class PolymorphismDemo {

    public static void main(String[] args) {

        Shape s1 = new Shape();
        s1.draw();
        s1.draw("square");

        System.out.println("----------------");

        Shape s2 = new Circle(); // runtime polymorphism
        s2.draw();
    }
}