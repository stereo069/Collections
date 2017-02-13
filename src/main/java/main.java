import Stack.MyStack;

import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;


public class main {

    public static void main(String[] args) throws IOException {

        MyStack<Integer> stack = new MyStack<>();
        Scanner in = new Scanner(System.in);
        int type;

        do {

            type = menu();


            switch (type) {
                case 1: {
                    System.out.print("value --- ");
                    Integer value = in.nextInt();
                    stack.push(value);


                }
                break;

                case 2 : {
                    Integer val =  stack.pop();
                    System.out.println("pop value - "+val);
                }
                break;
                case 3 : {
                    Iterator<Integer> iterator = stack.iterator();
                    if(!iterator.hasNext()){
                        System.out.println(" ----- Stack is empty");
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
                    printStack(stack);
                    break;

                case 4: {
                    System.out.println("size ---- "+stack.size());
                }break;



                case 6: {
                    System.out.println("isEmpty ---- "+stack.isEmpty());
                }break;

                case 7: {
                    System.out.print("key - ");
                    int key = in.nextInt();
                    boolean result = stack.search(key);
                            if(result)
                            {
                                System.out.println("found");
                            }else{
                                System.out.println("not found");
                            }
                }break;

                case 8: {
                    System.out.println("        clear stack");
                    stack.clear();
                    }
                    break;
            }
        }while (type != 0);
        return;

    }

    public static int menu(){
        Scanner in = new Scanner(System.in);
        System.out.println("1 - push");
        System.out.println("2 - pop");
        System.out.println("3 - remove");
        System.out.println("4 - size");
        System.out.println("5 print");
        System.out.println("6 is empty");
        System.out.println("7 search");
        System.out.println("8 clear");
        System.out.println("0 exit");
        int  n ;
        n = in.nextInt();

        return n;
    }

    public static void printStack(MyStack<Integer> stack){
        Iterator<Integer> iterator = stack.iterator();
        if(!iterator.hasNext()){
            System.out.println(" ----- Stack is empty");
        }
        while(iterator.hasNext()){
            System.out.println("elem stack ------- "+iterator.next());
        }
    }

}
