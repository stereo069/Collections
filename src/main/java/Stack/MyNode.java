package Stack;

/**
 * Created by diasonov on 09.02.2017.
 */
public class MyNode<T> {

    MyNode prevNode;
    T value;

    MyNode(T value, MyNode prevNode){

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

}
