package Threads.NumberPrinter;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String []args){
        ExecutorService executeService = Executors.newFixedThreadPool(2);
        for(int i = 1; i<=10; i++){
            executeService.execute(new NumberPrinter(i));
        }
    }
}
