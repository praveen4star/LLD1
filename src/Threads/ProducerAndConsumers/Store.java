package Threads.ProducerAndConsumers;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private  int maxValue = 0;
    private  ArrayList<Object> items;
    public  Store(int maxValue){
        this.maxValue = maxValue;
        this.items = new ArrayList<>();
    }

    public void increment(){

        items.add(new Object());
        System.out.println(items.size()+" "+Thread.currentThread().getName());
    }
    public  void decrement(){
        items.remove(items.size()-1);
        System.out.println(items.size()+" "+Thread.currentThread().getName());

    }
    public ArrayList<Object> getItems(){
        return items;
    }
    public int getCapacity(){
        return maxValue;
    }


}
