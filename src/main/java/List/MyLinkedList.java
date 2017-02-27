package List;

import Interface.IMyLinkedList;
import Node.MyListNode;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import Interface.IMyCollection;


public class  MyLinkedList<E extends Comparable<E>> implements IMyLinkedList<E>, IMyCollection<E>{

    private MyListNode<E> head;
    private MyListNode<E> tail;
    private int size;
    private int modCount;



    private void checkBoundsInclusive(int index)
        {
        if (index < 0 || index > size)
                 throw new IndexOutOfBoundsException("Index: " + index + ", Size:"
                                                         + size);
        }

    private void checkBoundsExclusive(int index)
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size:"
                    + size);
    }


    private void linkBefore(E element, MyListNode<E> node){

        MyListNode<E> prev = node.getPrevNode();

        MyListNode<E> newNode = new MyListNode<>(element,node.getPrevNode(),node);
        if(prev==null){
            head = newNode;
        }else{
            prev.setNextNode(newNode);
        }
        node.setPrevNode(newNode);
        size++;
        modCount++;
    }

    @Override
    public void add(int index, E element) {
       checkBoundsInclusive(index);

        if(index < size) {
            MyListNode<E> node = head;
            for (int i = 0; i < index; i++) {
                node = node.getNextNode();
            }
            size++;
            MyListNode<E> newNode = new MyListNode<>(element, node.getPrevNode(), node);

            if (node.getPrevNode() != null) {
                node.getPrevNode().setNextNode(newNode);
            } else {
                head = newNode;
            }

            node.setPrevNode(newNode);
        }else
        {
            addLast(element);
        }


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
        modCount++;

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
        modCount++;

    }

    @Override
    public void removeFirst() {

        if(head==null){
            throw new NoSuchElementException();
        }
        size--;
        modCount++;
        head = head.getNextNode();
        head.setPrevNode(null);

    }

    @Override
    public void removeLast() {

        if(tail==null){
            throw new NoSuchElementException();
        }
        size--;
        modCount++;
        tail = tail.getPrevNode();
        tail.setNextNode(null);

    }

    @Override
    public void sort() {

        if(size <2){
            return;
        }

        for(int i=0;i<size-1;i++){
            MyListNode<E> one = head;
            MyListNode<E> two = one.getNextNode();
            for(int j=0;j<(size-1)-i;j++){
                    E o = one.getValue();
                    E t = two.getValue();
                    if(o.compareTo(t)>0){
                        swap(one,two);
                    }
                one = one.getNextNode();
                two = two.getNextNode();
            }
        }


    }

    private void swap(MyListNode<E> eO, MyListNode<E> eT){
        E buffer = eO.getValue();
        eO.setValue(eT.getValue());
        eT.setValue(buffer);
    }

    @Override
    public E remove(int index) {

        checkBoundsExclusive(index);

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

            unlink(node);


        }

        return returnElement;

    }

    private E unlink(MyListNode<E> node){

        E value = node.getValue();
        MyListNode<E> next = node.getNextNode();
        MyListNode<E> prev = node.getPrevNode();

        if(prev==null){
            head = next;
        }else{
            prev.setNextNode(next);
        }

        if(next == null){
            tail = prev;
        }else{
            next.setPrevNode(prev);
        }

        node.setNextNode(null);
        node.setPrevNode(null);
        size--;
        modCount++;
        return value;


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

        checkBoundsInclusive(index);

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

        return new MyLinkedListIterator(index);
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
        modCount++;
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

    private class MyLinkedListIterator implements ListIterator<E>{

        private MyListNode<E> lastReturned = head;
        private MyListNode<E> next;
        private int nextIndex;
        private int expectedmodCount = modCount;

        MyLinkedListIterator(int index){

            checkBoundsInclusive(index);

            if(index < (size>>1)){
                next = head;
                for(nextIndex = 0;nextIndex<index;nextIndex++){
                    next = next.getNextNode();
                }
            }else
            {
                next = tail;
                for(nextIndex = size;nextIndex>index;nextIndex--){
                    next = next.getPrevNode();
                }
            }



        }

        private void checkForComodification(){
            if(modCount!=expectedmodCount){
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public boolean hasNext() {
            return nextIndex!=size;
        }

        @Override
        public E next() {
            checkForComodification();
            if(!hasNext())
            {
                throw new NoSuchElementException();
            }
            lastReturned = next;
            nextIndex++;
            next = next.getNextNode();
            return lastReturned.getValue();

        }

        @Override
        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public E previous() {
            checkForComodification();
            if(!hasPrevious()){
                throw new NoSuchElementException();
            }
            lastReturned = next = (next==null) ? tail : next.getPrevNode();
            nextIndex--;
            return lastReturned.getValue();

        }

        @Override
        public int nextIndex() {
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            return nextIndex-1;
        }

        @Override
        public void remove() {
            checkForComodification();
            if (lastReturned == null)
                throw new IllegalStateException();

            MyListNode<E> lastNext = lastReturned.getNextNode();
            unlink(lastReturned);

            if(next == lastReturned){
                next = lastNext;
            }else
            {
                nextIndex--;
            }
            expectedmodCount++;
            lastReturned=null;

        }

        @Override
        public void set(E value) {

            if (lastReturned == null)
                throw new IllegalStateException();
            checkForComodification();
            lastReturned.setValue(value);

        }

        @Override
        public void add(E value) {

            checkForComodification();
            lastReturned =null;
            if(next==null){
                addLast(value);
            }else{
                linkBefore(value,next);
            }
            nextIndex++;
            expectedmodCount++;

        }
    }
}
