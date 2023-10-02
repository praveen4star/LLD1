package SquareThread;
public class SquareNumPrinter implements  Runnable{
    int number;
    public  SquareNumPrinter(int num){
        number = num;
    };
    @Override
    public void run(){
        System.out.println(number*number);
    }
}
