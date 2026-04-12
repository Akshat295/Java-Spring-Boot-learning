class Conditionals {
    public static void main(String[] args) {

        int number = 15;

        // 1. if statement
        if (number > 10) {
            System.out.println("Number is greater than 10");
        }

        // 2. if-else statement
        if (number % 2 == 0) {
            System.out.println("Even number");
        } else {
            System.out.println("Odd number");
        }

        // 3. if-else-if ladder
        if (number < 0) {
            System.out.println("Negative number");
        } else if (number == 0) {
            System.out.println("Zero");
        } else {
            System.out.println("Positive number");
        }

        // 4. Nested if
        if (number > 0) {
            if (number < 20) {
                System.out.println("Number is between 1 and 20");
            }
        }

        // 5. switch statement
        int day = 3;

        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            default -> System.out.println("Invalid day");
        }
    }
}