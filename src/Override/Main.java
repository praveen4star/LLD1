package Override;

import java.util.Stack;

public class Main {
    public static  void display(Iterable<?> data){
        for(Object t : data){
            System.out.println(t);
        }
    }
    public static void main(String[]args){
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        display(st);
    }
}
