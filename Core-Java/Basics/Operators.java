public class Operators {
    public static void main(String[] args) {

        int a = 10, b = 5;

        // Arithmetic Operators
        System.out.println("Arithmetic:");
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));

        // Relational Operators
        System.out.println("\nRelational:");
        System.out.println("a > b = " + (a > b));
        System.out.println("a < b = " + (a < b));
        System.out.println("a == b = " + (a == b));
        System.out.println("a != b = " + (a != b));

        // Logical Operators
        System.out.println("\nLogical:");
        System.out.println("(a > 5 && b < 10) = " + (a > 5 && b < 10));
        System.out.println("(a < 5 || b == 5) = " + (a < 5 || b == 5));
        System.out.println("!(a > b) = " + !(a > b));

        // Assignment Operators
        System.out.println("\nAssignment:");
        int c = a;
        c += b;
        System.out.println("c += b → " + c);

        c -= b;
        System.out.println("c -= b → " + c);

        // Unary Operators
        System.out.println("\nUnary:");
        int d = 5;
        System.out.println("++d = " + (++d)); // pre-increment
        System.out.println("d++ = " + (d++)); // post-increment
        System.out.println("d = " + d);

        // Ternary Operator
        System.out.println("\nTernary:");
        int max = (a > b) ? a : b;
        System.out.println("Max = " + max);

        // Bitwise Operators
        System.out.println("\nBitwise:");
        System.out.println("a & b = " + (a & b));
        System.out.println("a | b = " + (a | b));
        System.out.println("a ^ b = " + (a ^ b));
    }
}