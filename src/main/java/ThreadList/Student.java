package ThreadList;

/**
 * Created by diasonov on 27.03.2017.
 */
public class Student extends student {


    public Student nextName,prevName,nextPhone,prevPhone;


    public Student(String name, int phone) {
        super(name, phone);
    }

    public Student(student student) {
        super(student.name, student.phone);
    }
}
