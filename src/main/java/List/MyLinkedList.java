package List;

import Interface.IMyLinkedList;
import Node.MyListNode;

import java.util.ListIterator;
import Interface.IMyCollection;


public class MyLinkedList<E> implements IMyLinkedList<E>, IMyCollection<E> {

    private MyListNode<E> head;
    private MyListNode<E> tail;
    private int size;
    private boolean isMofifcation;

    @Override
    public void add(int index, E element) {
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }

        MyListNode<E> node = head;
        for(int i=1;i<index;i++){
            node = node.getNextNode();
        }
        size++;
        MyListNode<E> newNode = new MyListNode<>(element,node.getPrevNode(),node);

        if(node.getPrevNode() != null){
            node.getPrevNode().setNextNode(newNode);
        }else{
            head = newNode;
        }

        node.setPrevNode(newNode);



    }

    @Override
    public void addFirst(E value) {

        size++;
        if(head == null){
            head = new MyListNode<>(value,null,null);
            tail = head;
            return;
        }

        MyListNode<E> newHead = new MyListNode<>(value,null,head);
        head.setPrevNode(newHead);
        head = newHead;

    }

    @Override
    public void addLast(E value) {
        size++;
        if(tail == null){
            head = new MyListNode<>(value,null,null);
            tail = head;
            return;
        }
        MyListNode<E> newTail = new MyListNode<>(value,tail,null);
        tail.setNextNode(newTail);
        tail = newTail;

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
        if(head == null){
            return null;
        }
        return head.getValue();
    }

    @Override
    public E getLast() {
        if(tail == null)
        {
            return null;
        }
        return tail.getValue();
    }

    @Override
    public E get(int index) {
        if(index<0 || index >=size){
            throw new IndexOutOfBoundsException();
        }
        MyListNode<E> node = head;
        for(int i=1;i<index;i++){
            node = node.getNextNode();
        }
        return node.getValue();
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public boolean search(E key) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Integer size() {
        return null;
    }
}
