class Car {
    String brand;
    int speed;

    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed);
    }
}

public class ClassDemo {
    public static void main(String[] args) {

        // Creating object
        Car c1 = new Car();

        // Assigning values
        c1.brand = "BMW";
        c1.speed = 120;

        // Accessing method
        c1.display();
    }
}