package Stack;


public interface IMyStack<T>{


    void push(T value);


    /*
        реализация функционала Iterator конфликтует с функцией pop.
        поэтому придётся длать велосипед.

     */
    T pop();
}
