package SquareGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public  static  void main(String []args) throws ExecutionException, InterruptedException {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Integer>> result = new ArrayList<>();
        for(Integer num : numbers){
            SquareGenerator sg = new SquareGenerator(num);
            Future<Integer> square = executorService.submit(sg);
            System.out.println("State of future : " + square.isDone());
            result.add(square);

        }
        for(Future<Integer> square : result){
            System.out.println("State of future : " + square.isDone());
            System.out.println(square.get());
        }
    }
}
