package Threads.FooBarProblem;

public class Client {

    public static  void main(String []args){
        int n = 5; // Replace with the desired number of iterations

        FooBar fooBar = new FooBar(n);

        // Create two threads, one for foo and one for bar
        Thread fooThread = new Thread(() -> {
            try {
                fooBar.foo(() -> {
                    System.out.print("foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread barThread = new Thread(() -> {
            try {
                fooBar.bar(() -> {
                    System.out.print("bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Start both threads
        fooThread.start();
        barThread.start();

        // Wait for both threads to finish
        try {
            fooThread.join();
            barThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

