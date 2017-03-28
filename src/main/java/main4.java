import ThreadList.*;

import java.io.IOException;

/**
 * Created by diasonov on 28.03.2017.
 */
public class main4 {

    public static void main(String[] args) throws IOException {
        ThreadList list = new ThreadList();
        Student student = new Student("Den",20);
        list.add(student);
        student = new Student("Ann",21);
        list.add(student);
        String name = list.searchByphone(20);
        int phone = list.searchByName("Ann");

        TIteratorName iterator = list.IteratorName();

        while(iterator.hasNext()){
            System.out.println(iterator.next().name);
        }

        TIteratorPhone iterator2 = list.IteratorPhone();
        while(iterator2.hasNext()){
            System.out.println(iterator2.next().phone);
        }

        list.deleteByName("Ann");
        iterator2 = list.IteratorPhone();
        while(iterator2.hasNext()){
            System.out.println(iterator2.next().phone);
        }

        return;
    }
}
