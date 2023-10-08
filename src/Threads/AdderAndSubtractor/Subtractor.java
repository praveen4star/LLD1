package Threads.AdderAndSubtractor;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {
    Value value  = null;
    Lock lock = null;
    public Subtractor(Value val, Lock lock){
        this.value = val;
        this.lock = lock;
    }
    public  Void call(){
        for(int i = 0; i<5000; i++){
            if(i == 6){
                System.out.println(Thread.currentThread().getName());
            }
            lock.lock();
            this.value.val--;
            lock.unlock();
        }
        return null;
    }
}
