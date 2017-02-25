package List;

import Interface.IMyLinkedList;
import Node.MyListNode;

import java.util.ListIterator;


public class LinkedList<E> implements IMyLinkedList<E> {

    private MyListNode<E> head;
    private MyListNode<E> tail;
    private int size;
    private boolean isMofifcation;

    @Override
    public void add(int index, E element) {

    }

    @Override
    public void addFirst(E value) {

    }

    @Override
    public void addLast(E value) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void removeLast() {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }
}
