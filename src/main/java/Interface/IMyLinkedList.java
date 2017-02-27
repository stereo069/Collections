package Interface;

import java.util.ListIterator;

/**
 * Created by diasonov on 25.02.2017.
 */
public interface IMyLinkedList<E extends Comparable<E>> {

        void add(int index, E element);
        void addFirst(E value);
        void addLast(E value);
        void removeFirst();
        void removeLast();
        void sort();
        E remove(int index);
        E getFirst();
        E getLast();
        E get(int index);
        int indexOf(Object o);
        ListIterator<E> listIterator(int index);




}
