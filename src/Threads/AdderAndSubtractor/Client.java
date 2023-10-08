package Threads.AdderAndSubtractor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String []args) throws ExecutionException, InterruptedException {
        Value val = new Value();
        Lock lock = new ReentrantLock();
        Adder add = new Adder(val, lock);
        Subtractor sub = new Subtractor(val, lock);

        ExecutorService esc = Executors.newCachedThreadPool();
        Future<Void> a = esc.submit(add);
        Future<Void> b = esc.submit(sub);
        a.get();
        b.get();
        System.out.println(val.val);
    }

}
