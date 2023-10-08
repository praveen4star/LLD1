package Threads.ProducerAndConsumers;

import java.util.concurrent.Semaphore;

public class Consumer implements  Runnable{
    Store st ;
    Semaphore prodSemaphore;
    Semaphore conSemaphore;
    public Consumer(Store st, Semaphore prodSemaphore, Semaphore conSemaphore){
        this.st = st;
        this.prodSemaphore = prodSemaphore;
        this.conSemaphore = conSemaphore;
    }

    @Override
    public void run(){
        while(true){
            try {
                conSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            st.decrement();
            prodSemaphore.release();
        }
    }
}
