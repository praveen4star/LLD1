package NumberPrinter;

public class NumberPrinter implements  Runnable{
    int numberToPrint;
    public NumberPrinter(int num){
        this.numberToPrint = num;
    }
    @Override
    public void run(){
        System.out.println(numberToPrint);
    }


}
