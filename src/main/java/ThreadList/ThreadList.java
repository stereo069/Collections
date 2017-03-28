package ThreadList;

/**
 * Created by diasonov on 27.03.2017.
 */
public class ThreadList {

    Student head,tail;
    int size;

    public ThreadList(){
        head = new Student("ZZZZZZ",Integer.MAX_VALUE);
        tail = new Student("AAAAA",Integer.MIN_VALUE);
        linAge(tail,head);
        linkName(tail,head);
        size=0;
    }


    public void add(Student node){
        if(size ==0 ) {
            linAge(tail,node);
            linkName(tail,node);
            return;
        }
    }


    private void linkName(Student before, Student newNode){
        Student next = before.nextName;
        before.nextName = newNode;
        newNode.prevName = before;
        newNode.nextName = next;
    }

    private void linAge(Student before, Student newNode){
        Student next = before.nextAge;
        before.nextAge = newNode;
        newNode.prevAge = before;
        newNode.nextAge = next;
    }

    // size not 0
    private Student getBeforeName(Student node){
        Student loopNode = tail.nextName;
       for(int i=0;i<size;i++){
           if(node.name.compareTo(loopNode.name)<0) return loopNode;
           loopNode = loopNode.nextName;
       }
       //not achievable
       return null;
    }

    // size not 0
    private Student getBeforeAge(Student node){
        Student loopNode = tail.nextAge;
        for(int i=0;i<size;i++){
            if(node.age.compareTo(loopNode.age)<0) return loopNode;
            loopNode = loopNode.nextAge;
        }
        //not achievable
        return null;
    }

}
