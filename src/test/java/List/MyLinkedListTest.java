package List;

import org.junit.Before;
import org.junit.Test;
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

    }

    @Test
    public void getFirst() throws Exception {

    }

    @Test
    public void getLast() throws Exception {

    }

    @Test
    public void get() throws Exception {

    }

    @Test
    public void indexOf() throws Exception {

    }

    @Test
    public void listIterator() throws Exception {

    }

    @Test
    public void search() throws Exception {

    }

    @Test
    public void clear() throws Exception {

    }

    @Test
    public void isEmpty() throws Exception {

    }

    @Test
    public void size() throws Exception {

    }

}