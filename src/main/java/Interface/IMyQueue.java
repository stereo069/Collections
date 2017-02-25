package Interface;

/**
 * Created by diasonov on 17.02.2017.
 */
public interface IMyQueue<T> {

    void add(T value);
    T poll();


}
