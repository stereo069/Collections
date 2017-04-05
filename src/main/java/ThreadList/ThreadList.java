package ThreadList;

import java.text.Collator;
import java.util.Locale;

/**
 * Created by diasonov on 27.03.2017.
 */
public class ThreadList {

    Student head,tail;
    int size;

    public ThreadList(){
        head = new Student("ZZZZZZ",Integer.MAX_VALUE);
        tail = new Student("AAAAA",Integer.MIN_VALUE);
        tail.nextName = head;
        tail.nextPhone = head;
        head.prevPhone = tail;
        head.prevName = tail;


        size=0;
    }


    public void add(student Node){
        Student node = new Student(Node);
        if(size ==0 ) {
            linphone(tail,node);
            linkName(tail,node);
            size++;
            return;
        }
        linphone(getBeforephone(node),node);
        linkName(getBeforeName(node),node);
        size++;
    }


    private void linkName(Student before, Student newNode){
        Student next = before.nextName;
        before.nextName = newNode;
        newNode.prevName = before;
        newNode.nextName = next;
        next.prevName = newNode;
    }

    private void linphone(Student before, Student newNode){
        Student next = before.nextPhone;
        before.nextPhone = newNode;
        newNode.prevPhone = before;
        newNode.nextPhone = next;
        next.prevPhone = newNode;
    }

    private void unLink(Student node){
        node.prevPhone.nextPhone = node.nextPhone;
        node.prevName.nextName = node.nextName;
        node.nextPhone.prevPhone=node.prevPhone;
        node.nextName.prevName = node.prevName;
    }

    // size not 0
    private Student getBeforeName(Student node){
        Student loopNode = tail.nextName;
        Collator englishCollator = Collator.getInstance(new Locale("en", "US"));
        for(int i=0;i<size+1;i++){
            int comp = englishCollator.compare(node.name,loopNode.name);
           // int comp = node.name.compareTo(loopNode.name);
            if(comp<0) return loopNode.prevName;
            loopNode = loopNode.nextName;
        }
        //not achievable
        return null;
    }

    // size not 0
    private Student getBeforephone(Student node){
        Student loopNode = tail.nextPhone;
        for(int i=0;i<size+1;i++){
            if(node.phone.compareTo(loopNode.phone)<0) return loopNode.prevPhone;
            loopNode = loopNode.nextPhone;
        }
        //not achievable
        return null;
    }


    public String searchByphone(Integer phone){
        Student loopNode = tail.nextPhone;
        for(int i=0;i<size+1;i++){
            if(phone.compareTo(loopNode.phone)==0) return loopNode.name;
            loopNode = loopNode.nextPhone;
        }
        return "";
    }

    public int searchByName(String name){
        Student loopNode = tail.nextName;
        for(int i=0;i<size+1;i++){
            if(name.compareTo(loopNode.name)==0) return loopNode.phone;
            loopNode = loopNode.nextName;
        }
        return 0;
    }

    public TIteratorName IteratorName(){
        return new TIteratorName(tail,size);
    }

    public TIteratorPhone IteratorPhone(){
        return new TIteratorPhone(tail,size);
    }

    public void deleteByPhone(Integer phone){
        Student loopNode = tail.nextPhone;
        for(int i=0;i<size+1;i++){
            if(phone.equals(loopNode.phone)){ unLink(loopNode); size--; return;}
            loopNode = loopNode.nextPhone;
        }
    }

    public void deleteByName(String name){
        Student loopNode = tail.nextName;
        for(int i=0;i<size+1;i++){
            if(name.equals(loopNode.name)) {
                unLink(loopNode); size--; return;}
            loopNode = loopNode.nextName;
        }
    }

    public boolean isEmpty(){
        return size<=0;
    }

}