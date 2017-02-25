package Stack;

import Node.MyNode;
import org.junit.Before;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.Assert.*;


public class MyStackTest {

    private Integer []testArray = {10,21,221,43,0,42};
    private MyStack<Integer> stack;
    private int size = 6;

    @Before
    public void init(){
        stack = new MyStack<>();
        for(int i=0;i<size;i++){
            stack.push(testArray[i]);
        }
    }



    @org.junit.Test
    public void pop() throws Exception {

        Integer expected;
        Integer actual;
        Iterator<Integer> iterator = stack.iterator();
        for(int i=size-1;i>=0;i--) {
            expected = stack.pop();
            actual = testArray[i];
            assertEquals(expected, actual);
        }
        expected = stack.pop();
        assertEquals("Empty Stack error",expected, null);
    }

    @org.junit.Test
    public void iterator() throws  Exception {

        Iterator<Integer> iterator = stack.iterator();
        Integer expected;
        Integer actual;

        for(int i=size-1;i>=0;i--) {
            expected = iterator.hasNext() != false ? iterator.next() : null;
            actual = testArray[i];
            assertEquals(expected, actual);
        }

        assertTrue("Empty Stack error",!iterator.hasNext());
        assertEquals("POP",stack.pop(),testArray[size-1]);

    }

    @org.junit.Test
    public void clear() throws Exception {

        Iterator<Integer> iterator = stack.iterator();
        stack.clear();
        boolean expected2 = false;
        Integer expected = stack.pop();
        assertEquals("Stack is not empty",expected,null);
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

        Integer actual1 = testArray[size-1];
        Integer actual2 = testArray[size-3];
        Integer actual3 = testArray[1];

        MyNode<Integer> expected1 = stack.getPreviousNodeByKey(testArray[size-2]);
        MyNode<Integer> expected2 = stack.getPreviousNodeByKey(testArray[size-4]);
        MyNode<Integer> expected3 = stack.getPreviousNodeByKey(testArray[0]);

        assertEquals("Error in head stack",expected1.getValue(),actual1);
        assertEquals("Error in half stack",expected2.getValue(),actual2);
        assertEquals("Error in root stack",expected3.getValue(),actual3);


    }

    @org.junit.Test
    public void searchByKey()throws  Exception {

        Integer key1 = testArray[size-1];
        Integer key2 = testArray[size-3];
        Integer key3 = testArray[0];
        Integer key4 = 322;

        boolean expected1 = stack.search(key1);
        boolean expected2 = stack.search(key2);
        boolean expected3 = stack.search(key3);
        boolean expected4 = stack.search(key4);
        Integer expected5 = stack.pop();

        assertEquals("Error in head stack",expected1,true);
        assertEquals("Error in half stack",expected2,true);
        assertEquals("Error in root stack",expected3,true);
        assertEquals("Error with false key",expected4,false);
        assertEquals("Error integrity stack",expected5,testArray[size-1]);



    }

    @org.junit.Test
    public void isEmpty()throws  Exception {

        assertEquals("Error filled stack",stack.isEmpty(),false);

        while (stack.pop()!=null){

        }

        assertEquals("Error empty stack",stack.isEmpty(),true);
    }


    @org.junit.Test
    public void size()throws  Exception {

        for(Integer i =size-1;i>=0;i--){
            stack.pop();
            assertEquals("Error size stack",stack.size(),i);
        }

    }

    @org.junit.Test
    public void removeFromIterator()throws  Exception {

        boolean expectedException = false;
        boolean expectedFirst = true;
        boolean expectedMiddle = true;
        boolean expectedLast = true;
        Iterator<Integer> iterator = stack.iterator();
        try {
            iterator.remove();
        }catch (IllegalStateException e){
            expectedException  = true;
        }
        iterator.next();

        try {
            iterator.remove();
            if(stack.search(testArray[size-1])){
                expectedFirst = false;
            }
        }catch (IllegalStateException e){
            expectedFirst = false;
        }
        try {
            iterator.next();
            iterator.next();
            iterator.remove();
            if(stack.search(testArray[size-4])){
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
            if(stack.search(testArray[0])){
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

        stack.pop();
        Integer actual = size-1;
        assertEquals("POP",stack.size(),actual);
        Iterator<Integer> iterator = stack.iterator();
        iterator.next();
        iterator.remove();
        actual = size-2;
        assertEquals("Iterator",stack.size(),actual);

    }

}