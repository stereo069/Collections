package Node;

public class MyNode<T> {

    private MyNode prevNode;
    private T value;

    public MyNode(T value, MyNode prevNode){

        this.prevNode = prevNode;
        this.value = value;

    }

    public T getValue(){
        return value;
    }
    public MyNode getPrevNode()
    {
        return prevNode;
    }

    public void setPrevNode(MyNode<T> prevNode){
        this.prevNode = prevNode;
    }



}
