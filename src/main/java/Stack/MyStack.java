package Stack;

import java.util.Iterator;

/**
 * Created by diasonov on 09.02.2017.
 */


public class MyStack<T> implements Iterable<T>, IMyStack<T>, IMyCollection<T> {

    MyNode<T> head;
    Integer size;
    Iterator<T> iterator;

    public MyStack(){
        size = new Integer(0);
    }


    public void push(T value) {

            size++;
            head = new MyNode<T>(value,head);

    }

    public T pop() {

        if(head == null)
        {
            return null;
        }else{
            size--;
            T locValue = head.getValue();
            head = head.getPrevNode();
                iterator.next(); // я могу не првоерять на сущетсвоание т.е выше есть проверка на сущестование head
            return locValue;

        }

    }

    /*
        return head collection
        @param:  void
        @return: Iterator<T>
    */
    @Override
    public Iterator<T> iterator() {
        iterator = new Iterator<T>() {

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
        return iterator;
    }

    @Override
    public boolean search(T key) {
        return false;
    }

    @Override
    public boolean remove(T key) {
        return false;
    }

    @Override
    public void clear() {

        while(head != null){
            this.pop();
        }

    }

    @Override
    public boolean isEmpty() {

        if(size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Integer size() {
        return size;
    }
}
