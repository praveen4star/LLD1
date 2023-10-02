package SquareGenerator;

import java.util.concurrent.Callable;

public class SquareGenerator implements Callable<Integer> {
    private Integer number ;
    public  SquareGenerator(int number){
        this.number = number;
    }
    @Override
    public  Integer call(){
        return number*number;
    }
}
