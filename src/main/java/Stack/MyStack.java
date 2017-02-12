package Stack;

import java.util.Iterator;

/**
 * Created by diasonov on 09.02.2017.
 */


public class MyStack<T> implements Iterable<T>, IMyStack<T> {

    MyNode<T> head;
    Integer size;

    public MyStack(){
        size = new Integer(0);
    }


    public void push(T value) {

            head = new MyNode<T>(value,head);

    }

    public T pop() {

        if(head == null)
        {
            return null;
        }else{
            T locValue = head.getValue();
            head = head.getPrevNode();
            return locValue;

        }

    }
    @Override
    public Iterator iterator() {
        return new Iterator<T>() {

            private MyNode<T> currentNode = head;

            @Override
            public boolean hasNext() {
                return (currentNode == null ? false : true);
            }

            @Override
            public T next() {
                T localValue = currentNode.getValue();
                currentNode = currentNode.getPrevNode();
                return (localValue);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
