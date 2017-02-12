package Stack;

import org.junit.Before;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by diasonov on 09.02.2017.
 */
public class MyStackTest {

    Integer []testArray = {10,21,221,43,0,43};
    MyStack<Integer> stack;
    int size = 6;

    @Before
    public void init(){
        stack = new MyStack<>();
        for(int i=0;i<size;i++){
            stack.push(testArray[i]);
        }
    }



    @org.junit.Test
    public void pop() throws Exception {

        Integer expected=0;
        Integer actual = 0;
        for(int i=size-1;i>=0;i--) {
            expected = stack.pop();
            actual = testArray[i];
            assertEquals(expected, actual);
        }
        expected = stack.pop();
        actual = null;
        assertEquals("Empty Stack error",expected, actual);
    }

    @org.junit.Test
    public void iterator() throws  Exception {

        Iterator<Integer> iterator = stack.iterator();
        Integer expected=0;
        Integer actual = 0;

        for(int i=size-1;i>=0;i--) {
            expected = iterator.hasNext() != false ? iterator.next() : null;
            actual = testArray[i];
            assertEquals(expected, actual);
        }

        assertTrue("Empty Stack error",!iterator.hasNext());

    }

}