public class Variables {
    public static void main(String[] args) {

        // Variables
        int age = 25;          // integer variable
        double salary = 45678.90;  // double variable

        // Type Conversion (int → double)
        double newAge = age;

        // Type Casting (double → int)
        int roundedSalary = (int) salary;

        // Output
        System.out.println("Age (int): " + age);
        System.out.println("Converted Age (double): " + newAge);
        System.out.println("Salary (double): " + salary);
        System.out.println("Casted Salary (int): " + roundedSalary);
    }
}