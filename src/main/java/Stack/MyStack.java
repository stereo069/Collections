package Stack;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;



public class MyStack<T> implements Iterable<T>, IMyStack<T>, IMyCollection<T> {

    MyNode<T> head;
    Integer size;
    Iterator<T> iterator;
    boolean isIterator;
    boolean isModification;

    public MyStack(){
        size = new Integer(0);
        isIterator = false;  // для тестов
        isModification = false;
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
            isModification = true;
            size--;
            T locValue = head.getValue();
            head = head.getPrevNode();

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
        isModification = false;
        isIterator = false;
         Iterator<T> Lociterator = new Iterator<T>() {

                private MyNode<T> currentNode;

                @Override
                public boolean hasNext() {
                    if(isModification)
                    {
                        isModification = false;
                        isIterator = false;
                        iterator = null;
                        currentNode = null;
                        throw new ConcurrentModificationException();
                    }


                            if(!isIterator){
                                if(head!= null)
                                {
                                    return true;
                                }else
                                {
                                    return false;
                                }
                            }
                    if(currentNode == null ) {
                        return false;
                    }
                    return ( currentNode.getPrevNode() == null ? false : true);
                }

                @Override
                public T next() {

                    if(isModification)
                    {
                        isModification = false;
                        isIterator = false;
                        iterator = null;
                        currentNode = null;
                        throw new ConcurrentModificationException();
                    }

                    if(!isIterator){
                        currentNode = head;
                        isIterator = true;
                        return currentNode != null ? currentNode.getValue() : null;
                    }
                    if(currentNode == null)
                    {
                        throw new NoSuchElementException();
                    }

                    currentNode = currentNode.getPrevNode();
                    if(currentNode == null)
                    {
                        throw new NoSuchElementException();
                    }
                    T localValue = currentNode.getValue();

                    return localValue;
                }

                @Override
                public void remove() {

                    if(currentNode == null){
                        throw new IllegalStateException();

                    }

                    MyNode<T> localNode = getPreviousNodeByNode(currentNode);
                    if(localNode == null){
                        if(head == currentNode){
                            head = currentNode!= null ? currentNode.getPrevNode() : null;
                            currentNode = head;
                            size--;
                            return;
                        }

                    }
                    if(currentNode.getPrevNode()==null)
                    {
                        localNode.setPrevNode(null);
                    }else {
                        localNode.setPrevNode(currentNode.getPrevNode());
                    }
                    size--;

                }

            };
        if(iterator==null){
            iterator = Lociterator;
        }
        return Lociterator;
    }

    @Override
    public boolean search(T key) {

        MyNode<T> localHead = head;

        while(localHead != null){
            if(localHead.getValue() == key){
                return true;
            }
            localHead = localHead.getPrevNode();
        }
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
        size--;
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

        MyNode<T> localHead = head;
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


    public MyNode<T> getPreviousNodeByNode(MyNode<T> key){

        MyNode<T> localHead = head;
        MyNode<T> previousNode = null;
        while(localHead != null){
            if(localHead == key && previousNode != null)
            {
                return previousNode;
            }
            previousNode = localHead;
            localHead = localHead.getPrevNode();
        }
        return  null;
    }

}
