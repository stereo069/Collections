import List.MyLinkedList;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.nio.file.Files;


/**
 * Created by diasonov on 27.02.2017.
 */
public class main3 {
    public static void main(String[] args) throws IOException {

        MyLinkedList<Integer> list = new MyLinkedList<>();

        Scanner in = new Scanner(System.in);
        int type;

        do {

            type = menu();


            switch (type) {
                case 1: {
                    System.out.print("value --- ");
                    Integer value = in.nextInt();
                    list.add(value);


                }
                break;

                case 2 : {
                    Integer val = 0;
                    try {
                        val =  list.getFirst();
                    }catch (NoSuchElementException e){
                        System.out.println("NoSuchElementException");
                        System.out.println("list is empty");
                        continue;

                    }


                    System.out.println("value - "+val);
                }
                break;
                case 3 : {
                    System.out.print("index - ");
                   Integer index = in.nextInt();
                    try{
                        System.out.println("value - "+list.get(index));
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("IndexOutOfBoundsException");
                    }

                }
                break;
                case 5:
                   printList(list);
                    break;

                case 4: {
                    System.out.print("index - ");
                    Integer index = in.nextInt();
                    try{
                        System.out.println("remove value - "+list.remove(index));
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("IndexOutOfBoundsException");
                    }
                }break;



                case 6: {
                    System.out.println("isEmpty ---- "+list.isEmpty());
                }break;

                case 7: {
                    System.out.print("key - ");
                    int key = in.nextInt();
                    boolean result = list.search(key);
                    if(result)
                    {
                        System.out.println("found");
                    }else{
                        System.out.println("not found");
                    }
                }break;

                case 8: {
                    System.out.println("        clear list ");
                    list.clear();
                }
                break;

                case 9: {
                    System.out.println("        Random add ");
                    RandomAdd(list);
                }
                break;
                case 10: {
                    System.out.println("        sort");
                    list.sort();
                }break;
                case 11: {
                    System.out.println("        Read file ");
                    ReadFile("C:/List/1.txt",list);
                }
                case 12: {
                System.out.println("        Write to file ");
                WriteFile("/home/den/Documents/List/1.txt",list);
            }
                case 13: {
                    System.out.println("        xor ");
                    xorPrint();
                }
                break;
            }
        }while (type != 0);
        return;

    }

    public static int menu(){
        Scanner in = new Scanner(System.in);
        System.out.println("1 - add");
        System.out.println("2 - getFirst");
        System.out.println("3 - get");
        System.out.println("4 - remove");
        System.out.println("5 - print");
        System.out.println("6 - isEmpty");
        System.out.println("7 - search");
        System.out.println("8 - clear");
        System.out.println("9 - random add");
        System.out.println("10- sort");
        System.out.println("11- readFile");
        System.out.println("12- writeFile");
        System.out.println("13- xor");
        System.out.println("0 - exit");
        int  n ;
        n = in.nextInt();

        return n;
    }

    public static void printList(MyLinkedList<Integer> list){
        ListIterator<Integer> iterator = list.listIterator(0);
        if(!iterator.hasNext()){
            System.out.println(" ----- List  is empty");
        }
        while(iterator.hasNext()){
            System.out.println("elem List  ------- "+iterator.next());
        }
    }

    public static void RandomAdd(MyLinkedList<Integer> list){
        Random rnd = new Random();

        Integer size = rnd.nextInt(10);

        for(int i=0;i<size;i++){
            list.add(rnd.nextInt(50));
        }
    }

    public static void ReadFile(String path, MyLinkedList<Integer> list) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
        for(String line: lines){
          //  System.out.println(line);
            Integer val = Integer.valueOf(line);
            list.add(val);
        }

    }

    public static void WriteFile(String path, MyLinkedList<Integer> list) throws IOException {

        List<String> lines = new ArrayList<>();
        ListIterator<Integer> iterator = list.listIterator(0);
        while (iterator.hasNext()){
            lines.add(iterator.next().toString());
        }
        Files.write(Paths.get(path),lines);
    }

    public static void xorPrint() throws IOException {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        MyLinkedList<Integer> list2 = new MyLinkedList<>();

        //RandomAdd(list);
        //RandomAdd(list2);

        ReadFile("/home/den/Documents/List/1.txt",list);
        ReadFile("/home/den/Documents/List/2.txt",list2);

        list.sort();
        list2.sort();
        MyLinkedList<Integer> list3 = xor(list.listIterator(0),list2.listIterator(0));
        printList(list);
        System.out.println("----------------------------");
        printList(list2);
        System.out.println("----------------------------");
        printList(list3);
    }

    public static MyLinkedList<Integer> xor(ListIterator<Integer> one,ListIterator<Integer> two){

        MyLinkedList<Integer> xorList = new MyLinkedList<Integer>();


        Integer a=0;
        Integer b=0;

        if(one.hasNext()){
            a= one.next();
        }
        while (two.hasNext()) {
            b=two.next();
            while (a < b) {
                if (one.hasNext()) {
                    xorList.add(a);
                    a = one.next();

                }else{
                    break;
                }
            }
            if (a == b) {
                if (one.hasNext()) {
                        a = one.next();

                } else {
                    break;
                }

            }else{
                xorList.add(b);
                if(one.hasNext()){
                    a= one.hasNext() ?  one.next() : a;
                }else {
                    xorList.add(a);
                    break;
                }

            }
        }
        while(one.hasNext()){
            xorList.add(one.next());
        }
        while(two.hasNext()){
            xorList.add(two.next());
        }
        xorList.sort();
        return xorList;
    }

}
