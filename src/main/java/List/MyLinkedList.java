package List;

import Interface.IMyLinkedList;
import Node.MyListNode;

import java.util.ListIterator;
import java.util.NoSuchElementException;

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
        for(int i=0;i<index;i++){
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

        if(head==null){
            throw new NoSuchElementException();
        }
        size--;
        isMofifcation = true;
        head = head.getNextNode();
        head.setPrevNode(null);

    }

    @Override
    public void removeLast() {

        if(tail==null){
            throw new NoSuchElementException();
        }
        size--;
        isMofifcation = true;
        tail = tail.getPrevNode();
        tail.setNextNode(null);

    }

    @Override
    public E remove(int index) {

        if(index<0 || index >=size){
            throw new IndexOutOfBoundsException();
        }
        MyListNode<E> node = head;
        for(int i=0;i<index;i++){
            node = node.getNextNode();
        }
        E returnElement = node.getValue();

        if(index == 0){
            removeFirst();
            return returnElement;
        }
        if(index == size-1){
            removeLast();
            return returnElement;
        }

        if(index>0 && index != size-1){
            size--;
            isMofifcation = true;
            node.getPrevNode().setNextNode(node.getNextNode());
            node.getNextNode().setPrevNode(node.getPrevNode());

        }

        return returnElement;

    }

    @Override
    public E getFirst() {
        if(head == null){
            throw new NoSuchElementException();
        }
        return head.getValue();
    }

    @Override
    public E getLast() {
        if(tail == null)
        {
            throw new NoSuchElementException();
        }
        return tail.getValue();
    }

    @Override
    public E get(int index) {
        if(index<0 || index >=size){
            throw new IndexOutOfBoundsException();
        }
        MyListNode<E> node = head;
        for(int i=0;i<index;i++){
            node = node.getNextNode();
        }
        return node.getValue();
    }

    @Override
    public int indexOf(Object o) {
        MyListNode<E> node = head;
        for(int i=0;i<size;i++){
            if(node.getValue() == o){
                return i;
            }
            node = node.getNextNode();

        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public boolean search(E key) {
        MyListNode<E> node = head;
        for(int i=0;i<size;i++){
            if(node.getValue().equals(key)){
                return true;
            }
            node = node.getNextNode();

        }
        return false;
    }

    @Override
    public void clear() {

        head=null;
        tail = null;
        isMofifcation = true;
        size = 0;

    }

    @Override
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    @Override
    public Integer size() {
        return size;
    }
}
