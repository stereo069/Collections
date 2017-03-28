package ThreadList;

/**
 * Created by diasonov on 27.03.2017.
 */
public class Student {

    public String name;
    public Integer age;
    public Student nextName,prevName,nextAge,prevAge;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }
}
