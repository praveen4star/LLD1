package Threads.ProducerAndConsumers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String []args){
        Store st = new Store(5);
        Semaphore prodSeamphore = new Semaphore(5);
        Semaphore conSemaphore = new Semaphore(0);
        ExecutorService es = Executors.newCachedThreadPool();


        for(int i = 0; i<10; i++){
            es.execute(new Consumer(st, prodSeamphore, conSemaphore));
        }
        for(int j = 0; j<50; j++){
            es.execute(new Producer(st, prodSeamphore, conSemaphore));
        }
    }

}
