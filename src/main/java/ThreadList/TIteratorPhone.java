package ThreadList;

/**
 * Created by diasonov on 28.03.2017.
 */
public class TIteratorPhone {
    Student current;
    int index;
    int size;


    public TIteratorPhone(Student node,int size){
        current = node;
        this.size = size;
        index=0;
    }

    public boolean hasNext(){
        return index<size;
    }

    public boolean hasPrev(){
        return index>0;
    }

    public Student next(){
        if(!hasNext())  return null;
        index++;
        current = current.nextPhone;
        return current;
    }

    public Student prev(){
        if(!hasPrev()) return null;
        index--;
        current= current.prevPhone;
        return current;
    }
}
