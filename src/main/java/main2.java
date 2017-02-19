import Queue.MyQueue;
import Stack.MyStack;

import java.io.IOException;
import java.util.Iterator;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by diasonov on 19.02.2017.
 */
public class main2 {
    public static void main(String[] args) throws IOException {

        MyQueue<Integer> Queue = new MyQueue<>();
        Scanner in = new Scanner(System.in);
        int type;

        do {

            type = menu();


            switch (type) {
                case 1: {
                    System.out.print("value --- ");
                    Integer value = in.nextInt();
                    Queue.add(value);


                }
                break;

                case 2 : {
                    Integer val =  Queue.poll();
                    if(val == null)
                    {
                        System.out.println("Queue is empty");
                    }
                    System.out.println("poll value - "+val);
                }
                break;
                case 3 : {
                    Iterator<Integer> iterator = Queue.iterator();
                    if(!iterator.hasNext()){
                        System.out.println(" ----- Queue is empty");
                    }
                    while(iterator.hasNext()){
                        System.out.println(" delete - " + iterator.next() +"?");
                        System.out.println("Y/N");
                        String result = in.next();
                        if(result.compareTo("Y")==0){
                            iterator.remove();
                            break;
                        }
                    }

                }
                break;
                case 5:
                    printStack(Queue);
                    break;

                case 4: {
                    System.out.println("size ---- "+Queue.size());
                }break;



                case 6: {
                    System.out.println("isEmpty ---- "+Queue.isEmpty());
                }break;

                case 7: {
                    System.out.print("key - ");
                    int key = in.nextInt();
                    boolean result = Queue.search(key);
                    if(result)
                    {
                        System.out.println("found");
                    }else{
                        System.out.println("not found");
                    }
                }break;

                case 8: {
                    System.out.println("        clear Queue ");
                    Queue.clear();
                }
                break;

                case 9: {
                    System.out.println("        Random add ");
                    RandomAdd(Queue);
                }
                break;
            }
        }while (type != 0);
        return;

    }

    public static int menu(){
        Scanner in = new Scanner(System.in);
        System.out.println("1 - add");
        System.out.println("2 - poll");
        System.out.println("3 - remove");
        System.out.println("4 - size");
        System.out.println("5 print");
        System.out.println("6 is empty");
        System.out.println("7 search");
        System.out.println("8 clear");
        System.out.println("9 random add");
        System.out.println("0 exit");
        int  n ;
        n = in.nextInt();

        return n;
    }

    public static void printStack(MyQueue<Integer> queue){
        Iterator<Integer> iterator = queue.iterator();
        if(!iterator.hasNext()){
            System.out.println(" ----- Queue  is empty");
        }
        while(iterator.hasNext()){
            System.out.println("elem Queue  ------- "+iterator.next());
        }
    }

    public static void RandomAdd(MyQueue<Integer> queue){
        Random rnd = new Random();

        Integer size = rnd.nextInt(10);

        for(int i=0;i<size;i++){
            queue.add(rnd.nextInt(50));
        }
    }

}
