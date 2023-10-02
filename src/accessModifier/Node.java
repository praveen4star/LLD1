package accessModifier;

public class Node {
    // write the code of node class here
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
    public Node(Node next){
        this.data = next.data;
        if(next.next != null){
            this.next =  new Node(next.next);
        }
        else{
            this.next = null;
        }
    }
}