package Stack;

import java.util.Iterator;

/**
 * Created by diasonov on 09.02.2017.
 */


public class MyStack<T> implements Iterable<T>, IMyStack<T>, IMyCollection<T> {

    MyNode<T> head;
    Integer size;
    Iterator<T> iterator;
    boolean isIterator;

    public MyStack(){
        size = new Integer(0);
        isIterator = false;  // для тестов
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
            if(isIterator) {
                iterator.next(); // я могу не првоерять на сущетсвоание т.е выше есть проверка на сущестование head
            }
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
        isIterator = true;
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

        iterator = iterator();
            while(iterator.hasNext()){
                if(iterator.next() == key)
                {
                    iterator = iterator();
                    return true;
                }
            }

        iterator = iterator();
        return false;
    }

    @Override
    public boolean remove(T key) {

        MyNode<T> localNode = this.getPreviousNodeByKey(key);
        if(localNode == null){
            if(head.getValue() == key){
                this.pop();
                return true;
            }
            return false;
        }
        MyNode<T>  deletedNode = localNode.getPrevNode();
        if(deletedNode.getPrevNode()==null)
        {
            localNode.setPrevNode(null);
        }else {
            localNode.setPrevNode(deletedNode.getPrevNode());
        }
        return true;
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


    public MyNode<T> getPreviousNodeByKey(T key){

        MyNode<T> localHead = new MyNode<T>(head.getValue(),head.getPrevNode());
        MyNode<T> previousNode = null;
        while(localHead != null){
            if(localHead.getValue() == key && previousNode != null)
            {
                return previousNode;
            }
            previousNode = localHead;
            localHead = localHead.getPrevNode();
        }
        return  null;
    }
}
