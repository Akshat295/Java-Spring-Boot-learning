class Parent {

    void show() {
        System.out.println("Parent class method");
    }
}

class Child extends Parent {

    @Override
    void show() {
        System.out.println("Child class method");
    }

    @Deprecated
    void oldMethod() {
        System.out.println("This method is deprecated");
    }
}
public class AnnotationsDemo{
    public static void main(String[] args) {

        Child c = new Child();

        c.show();

        c.oldMethod(); // deprecated method usage
    }
}