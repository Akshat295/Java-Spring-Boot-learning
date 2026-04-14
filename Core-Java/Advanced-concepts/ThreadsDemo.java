public class ThreadsDemo {

    // 1. Using Thread class
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread class running...");
        }
    }

    // 2. Using Runnable interface
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Runnable thread running...");
        }
    }

    // 5. Synchronization example
    static class Counter {
        int count = 0;

        synchronized void increment() {
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        // 1. Thread class
        MyThread t1 = new MyThread();

        // 2. Runnable
        Thread t2 = new Thread(new MyRunnable());

        // 3. Multiple threads
        Thread t3 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Thread 3: " + i);
            }
        });

        Thread t4 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Thread 4: " + i);
            }
        });

        // 4. Sleep example
        Thread t5 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Sleep Thread: " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        });

        // 5. Synchronization (race condition fix)
        Counter counter = new Counter();

        Thread t6 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        });

        Thread t7 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        });

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();

        // Wait for some threads to finish
        t6.join();
        t7.join();

        // Final result
        System.out.println("Final Counter: " + counter.count);

        // 6. Lambda thread
        Thread t8 = new Thread(() -> System.out.println("Lambda thread running..."));
        t8.start();
    }
}