package Threads.Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSort implements Callable<List<Integer>> {
    List<Integer> arr;
    ExecutorService es;
    public MergeSort(List<Integer> arr, ExecutorService es){
        this.arr = arr;
        this.es = es;
    }
    public List<Integer> call() throws ExecutionException, InterruptedException {
        if(arr.size() <=1 ) return arr;
        int mid = arr.size()/2;
        List<Integer> left = new ArrayList<>(), right = new ArrayList<>();
        for(int i = 0; i<mid; i++) left.add(arr.get(i));
        for(int i = mid; i<arr.size(); i++) right.add(arr.get(i));
        MergeSort msLeft = new MergeSort(left,es);
        MergeSort msRight = new MergeSort(right, es);
        Future<List<Integer>> leftFuture = es.submit(msLeft);
        Future<List<Integer>> rightFuture = es.submit(msRight);
        List<Integer> leftSorted = leftFuture.get(), rightSorted = rightFuture.get();
        return merge(leftSorted, rightSorted);
    }
    @org.jetbrains.annotations.NotNull
    private List<Integer> merge(List<Integer> left, List<Integer> right){
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0, k = 0, n = left.size(), m = right.size();
        while(i < n && j < m){
            if(left.get(i) <= right.get(j)){
                res.add(left.get(i++));
            }
            else{
                res.add( right.get(j++));
            }
        }
        while (i < n) res.add(left.get(i++));
        while (j < m) res.add(right.get(j++));
        return res;
    }
}
