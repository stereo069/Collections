package ThreadList;

/**
 * Created by diasonov on 28.03.2017.
 */
public class TIteratorName {
    Student current;
    int index;
    int size;


    public TIteratorName(Student node,int size){
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
        current = current.nextName;
        return current;
    }

    public Student prev(){
        if(!hasPrev()) return null;
        index--;
        current = current.prevName;
        return current;
    }
}
