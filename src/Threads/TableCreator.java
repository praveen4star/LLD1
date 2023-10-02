package Threads;

public class TableCreator implements  Runnable{
    private int num;
    public TableCreator(int num){
        this.num = num;
    }
    public  void run(){
       for(int i = 1; i<=10; i++){
           System.out.println(num+" times "+i+" is "+(num*i));
       }
    }
}
