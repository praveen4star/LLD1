package Threads.ProducerAndConsumers;

import java.util.concurrent.Semaphore;

public class Producer implements  Runnable{
    Store st ;
    Semaphore prodSemaphore;
    Semaphore conSemaphore;
    public Producer(Store st, Semaphore prodSemaphore, Semaphore conSemaphore){
        this.st = st;
        this.prodSemaphore = prodSemaphore;
        this.conSemaphore = conSemaphore;
    }

    @Override
    public void run(){
        while(true){
            try {
                prodSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            st.increment();
            conSemaphore.release();
        }
    }
}
