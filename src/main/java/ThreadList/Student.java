package ThreadList;

/**
 * Created by diasonov on 27.03.2017.
 */
public class Student {

    public String name;
    public Integer phone;
    public Student nextName,prevName,nextPhone,prevPhone;

    public Student(String name, int phone){
        this.name = name;
        this.phone = phone;
    }
}
