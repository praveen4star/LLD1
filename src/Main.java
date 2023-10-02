import NumberPrinter.NumberPrinter;
import Threads.HelloWorldPrinter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

        public static void main(String []args) {
            System.out.println(1);
            System.out.println(2);

            HelloWorldPrinter p = new HelloWorldPrinter();
            Thread t = new Thread(p);
            t.start();

            System.out.println(3+" "+Thread.currentThread().getName());
            System.out.println(4);
        }
}