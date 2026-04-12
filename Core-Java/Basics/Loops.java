public class Loops {
    public static void main(String[] args) {

        // 1. for loop
        System.out.println("For Loop:");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        // 2. while loop
        System.out.println("\nWhile Loop:");
        int j = 1;
        while (j <= 5) {
            System.out.println(j);
            j++;
        }

        // 3. do-while loop
        System.out.println("\nDo-While Loop:");
        int k = 1;
        do {
            System.out.println(k);
            k++;
        } while (k <= 5);

        // 4. Enhanced for loop (for-each)
        System.out.println("\nEnhanced For Loop:");
        int[] arr = {10, 20, 30, 40};
        for (int num : arr) {
            System.out.println(num);
        }

        // 5. break and continue
        System.out.println("\nBreak and Continue:");
        for (int x = 1; x <= 5; x++) {
            if (x == 3) {
                continue; // skip 3
            }
            if (x == 5) {
                break; // stop at 5
            }
            System.out.println(x);
        }
    }
}