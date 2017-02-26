package List;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;


public class MyLinkedListTest {

    private MyLinkedList<Integer> list;
    private Integer []testArray = {10,21,221,43,0,42};
    private Integer size = 6;

    @Before
    public void init(){
        list = new MyLinkedList<>();
     for(int i=0;i<size;i++){
         list.addLast(testArray[i]);
     }
    }


    @Test
    public void add() throws Exception {

        Integer actual = 16;

        list.add(0,actual);
        list.add(6,actual);

        assertEquals("First",list.get(0),actual);
        assertEquals("Last",list.get(6),actual);

        try{

            list.add(10,1);
            assertTrue("Index range",false);
        }
        catch (IndexOutOfBoundsException e){

        }

    }

    @Test
    public void addFirst() throws Exception {

    }

    @Test
    public void addLast() throws Exception {

    }

    @Test
    public void removeFirst() throws Exception {

    }

    @Test
    public void removeLast() throws Exception {

    }

    @Test
    public void remove() throws Exception {

        Integer expected = list.remove(0);
        assertEquals(expected,testArray[0]);

        init();

        expected = list.remove(5);
        assertEquals(expected,testArray[5]);

        init();

        expected = list.remove(2);
        assertEquals(expected,testArray[2]);

    }

    @Test
    public void getFirst() throws Exception {

        Integer expected = list.getFirst();

        assertEquals(expected,testArray[0]);
        list.clear();

        try{
            list.getFirst();
            assertTrue(false);
        }catch (NoSuchElementException e){
            assertTrue(true);
    }

    }

    @Test
    public void getLast() throws Exception {

        Integer expected = list.getLast();

        assertEquals(expected,testArray[size-1]);
        list.clear();

        try{
            list.getFirst();
            assertTrue(false);
        }catch (NoSuchElementException e){
            assertTrue(true);
        }
    }

    @Test
    public void get() throws Exception {
        Integer expected;
        for(int i=0;i<size;i++){
            expected = list.get(i);
            assertEquals(expected,testArray[i]);
        }

        try{
            list.get(size+1);
            assertTrue(false);
        }catch (IndexOutOfBoundsException e){
            assertTrue(true);
        }

    }

    @Test
    public void indexOf() throws Exception {



        for(int i=0;i<size;i++){
            assertEquals(i,list.indexOf(testArray[i]));
        }

        assertEquals(-1,list.indexOf(243));


    }

    @Test
    public void listIterator() throws Exception {

    }

    @Test
    public void search() throws Exception {

        for(int i=0;i<size;i++){
            assertEquals(true,list.search(testArray[i]));
        }

        assertEquals(false,list.search(243));
    }

    @Test
    public void clear() throws Exception {

    }

    @Test
    public void isEmpty() throws Exception {

        assertEquals(false,list.isEmpty());

        list.clear();

        assertEquals(true,list.isEmpty());

    }

    @Test
    public void size() throws Exception {

        assertEquals(list.size(),size);

        list.addFirst(10);
        Integer actual = size+1;
        assertEquals(list.size(),actual);

        list.addLast(12);
        actual++;
        assertEquals(list.size(),actual);

        list.add(0,12);
        actual++;
        assertEquals(list.size(),actual);

        list.add(list.size()-1,13);
        actual++;
        assertEquals(list.size(),actual);

        list.add(3,14);
        actual++;
        assertEquals(list.size(),actual);

        list.removeFirst();
        actual--;
        assertEquals(list.size(),actual);

        list.removeLast();
        actual--;
        assertEquals(list.size(),actual);

        list.remove(0);
        actual--;
        assertEquals(list.size(),actual);


    }

}