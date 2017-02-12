package Stack;


import java.util.Iterator;

public interface IMyCollection<T> {


    /*
     Search by key. Return true if was found node.
     @param: T key
     @return: boolean
     */
    boolean search(T key);

    /*
     Remove by key. Return true if was deleted at least one node.
     @param: T key
     @return: boolean
     */
    boolean remove(T key);

    /*
      Remove all nodes;
      @param:  void
      @return: void
     */
    void clear();


    /*
       on the void check
       @param: void
       @return: boolean
     */
    boolean isEmpty();

    /*

     */
    Integer size();


}
