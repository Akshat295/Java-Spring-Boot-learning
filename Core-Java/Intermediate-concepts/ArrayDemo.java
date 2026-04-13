public class ArrayDemo {
    public static void main(String[] args) {

        // Declare and initialize array
        int[] arr = {5, 10, 15, 20};

        // Access elements
        System.out.println("First element: " + arr[0]);
        System.out.println("Second element: " + arr[1]);

        // Loop through array
        System.out.println("All elements:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}