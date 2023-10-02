package Threads.Callable;

import java.util.List;
import java.util.concurrent.*;

public class Client {
    public static void main(String []args) throws ExecutionException, InterruptedException {
        List<Integer> arr = List.of(2, 4, 5, 24, 5,34,2,24,3,5);
        ExecutorService es = Executors.newCachedThreadPool();
        Callable<List<Integer>> thread = new MergeSort(arr, es);
        Future<List<Integer>> sorted = es.submit(thread);
        List<Integer> sortedArray = sorted.get();
        for(Integer x : sortedArray ) System.out.print(x+" ");
    }

}
