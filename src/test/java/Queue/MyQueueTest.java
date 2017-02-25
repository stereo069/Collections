package Queue;

import Node.MyNode;
import org.junit.Before;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.Assert.*;

public class MyQueueTest {

    private Integer []testArray = {10,21,221,43,0,42};
    private MyQueue<Integer> Queue;
    private int size = 6;

    @Before
    public void init(){
        Queue = new MyQueue<>();
        for(int i=0;i<size;i++){
            Queue.add(testArray[i]);
        }
    }

    @org.junit.Test
    public void add() throws Exception {

    }


    @org.junit.Test
    public void poll(){
        Integer expected;
        Integer actual;

        for(int i = 0;i<size;i++){
            expected = Queue.poll();
            actual = testArray[i];
            assertEquals(expected, actual);
        }

        expected = Queue.poll();
        actual = null;
        assertEquals("Empty Queue error",expected, actual);
    }

    @org.junit.Test
    public void iterator() throws  Exception {

        Iterator<Integer> iterator = Queue.iterator();
        Integer expected=0;
        Integer actual = 0;

        for(int i=0;i<size;i++) {
            expected = iterator.hasNext() != false ? iterator.next() : null;
            actual = testArray[i];
            assertEquals(expected, actual);
        }

        assertTrue("Empty Queue error",!iterator.hasNext());
        assertEquals("poll",Queue.poll(),testArray[0]);

    }

    @org.junit.Test
    public void clear() throws Exception {

        Iterator<Integer> iterator = Queue.iterator();
        Queue.clear();
        boolean expected2 = false;
        Integer expected = Queue.poll();
        assertEquals("Queue is not empty",expected,null);
        try{
            iterator.next();
        }catch (ConcurrentModificationException e)
        {
            expected2 = true;

        }
        assertTrue(expected2);
    }

    @org.junit.Test
    public void getPreviousNodeByKey()throws  Exception {

        Integer actual1 = testArray[size-2];
        Integer actual2 = testArray[size-4];
        Integer actual3 = null;

        MyNode<Integer> expected1 = Queue.getPreviousNodeByKey(testArray[size-1]);
        MyNode<Integer> expected2 = Queue.getPreviousNodeByKey(testArray[size-3]);
        MyNode<Integer> expected3 = Queue.getPreviousNodeByKey(testArray[0]);

        assertEquals("Error in head Queue",expected1.getValue(),actual1);
        assertEquals("Error in half Queue",expected2.getValue(),actual2);
        assertEquals("Error in root Queue",expected3,actual3);


    }

    @org.junit.Test
    public void searchByKey()throws  Exception {

        Integer key1 = testArray[size-1];
        Integer key2 = testArray[size-3];
        Integer key3 = testArray[0];
        Integer key4 = 322;

        boolean expected1 = Queue.search(key1);
        boolean expected2 = Queue.search(key2);
        boolean expected3 = Queue.search(key3);
        boolean expected4 = Queue.search(key4);
        Integer expected5 = Queue.poll();

        assertEquals("Error in head Queue",expected1,true);
        assertEquals("Error in half Queue",expected2,true);
        assertEquals("Error in root Queue",expected3,true);
        assertEquals("Error with false key",expected4,false);
        assertEquals("Error integrity Queue",expected5,testArray[0]);



    }

    @org.junit.Test
    public void isEmpty()throws  Exception {

        assertEquals("Error filled Queue",Queue.isEmpty(),false);

        while (Queue.poll()!=null){

        }

        assertEquals("Error empty Queue",Queue.isEmpty(),true);
    }


    @org.junit.Test
    public void size()throws  Exception {

        for(Integer i =size-1;i>=0;i--){
            Queue.poll();
            assertEquals("Error size Queue",Queue.size(),i);
        }

    }

    @org.junit.Test
    public void removeFromIterator()throws  Exception {

        boolean expectedException = false;
        boolean expectedFirst = true;
        boolean expectedMiddle = true;
        boolean expectedLast = true;
        Iterator<Integer> iterator = Queue.iterator();
        try {
            iterator.remove();
        }catch (IllegalStateException e){
            expectedException  = true;
        }
        iterator.next();

        try {
            iterator.remove();
            if(Queue.search(testArray[0])){
                expectedFirst = false;
            }
        }catch (IllegalStateException e){
            expectedFirst = false;
        }
        try {
            iterator.next();
            iterator.next();
            iterator.remove();
            if(Queue.search(testArray[3])){
                expectedMiddle = false;
            }
        }catch (IllegalStateException e){
            expectedMiddle = false;
        }

        try {
            while (iterator.hasNext()){
                iterator.next();
            }
            iterator.remove();
            if(Queue.search(testArray[size-1])){
                expectedLast = false;
            }
        }catch (IllegalStateException e){
            expectedLast = false;
        }


        assertEquals("Error exception",expectedException ,true);
        assertEquals("Error first remove",expectedFirst,true);
        assertEquals("Error middle remove", expectedMiddle,true);
        assertEquals("Error last remove",expectedLast,true);


    }
    @org.junit.Test
    public void Size()throws  Exception {

        Queue.poll();
        Integer actual = size-1;
        assertEquals("poll",Queue.size(),actual);
        Iterator<Integer> iterator = Queue.iterator();
        iterator.next();
        iterator.remove();
        actual = size-2;
        assertEquals("Iterator",Queue.size(),actual);

    }

}