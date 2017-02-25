package Node;


public class MyListNode<T> {

   private MyListNode prevNode;
   private MyListNode nextNode;
   private T value;

    public MyListNode(T value, MyListNode prevNode, MyListNode nextNode){

        this.prevNode = prevNode;
        this.nextNode = nextNode;
        this.value = value;

    }

    public T getValue(){
        return value;
    }
    public MyListNode getPrevNode()
    {
        return prevNode;
    }
    public MyListNode getNextNode()
    {
        return nextNode;
    }

    public void setPrevNode(MyListNode<T> prevNode){
        this.prevNode = prevNode;
    }

    public void setNextNode(MyListNode<T> nextNode){
        this.nextNode = nextNode;
    }


}
