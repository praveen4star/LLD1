package SquareThread;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String []args){
        List<Integer> values = List.of(1,2,3);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(Integer value : values){
            executorService.execute(new SquareNumPrinter(value));
        }

    }
}
