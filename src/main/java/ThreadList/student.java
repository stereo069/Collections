package ThreadList;

/**
 * Created by den on 3/29/17.
 */
public class student {

    public String name;
    public Integer phone;

    public student(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString(){
        return new String("Name : "+name+"  Phone : "+ phone);
    }
}
