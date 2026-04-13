class ConstructorDemo {

    String name;
    int age;

    // 1. Default Constructor
    ConstructorDemo() {
        name = "Default Name";
        age = 0;
        System.out.println("Default Constructor Called");
    }

    // 2. Parameterized Constructor
    ConstructorDemo(String n, int a) {
        name = n;
        age = a;
        System.out.println("Parameterized Constructor Called");
    }

    // 3. Copy Constructor
    ConstructorDemo(ConstructorDemo obj) {
        name = obj.name;
        age = obj.age;
        System.out.println("Copy Constructor Called");
    }

    // Display method
    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {

        // Using Default Constructor
        ConstructorDemo obj1 = new ConstructorDemo();
        obj1.display();

        System.out.println("---------------------");

        // Using Parameterized Constructor
        ConstructorDemo obj2 = new ConstructorDemo("Aman", 21);
        obj2.display();

        System.out.println("---------------------");

        // Using Copy Constructor
        ConstructorDemo obj3 = new ConstructorDemo(obj2);
        obj3.display();

        System.out.println("---------------------");

        // Constructor Overloading Demo
        ConstructorDemo obj4 = new ConstructorDemo("Riya", 22);
        obj4.display();
    }
}