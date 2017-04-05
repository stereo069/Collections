import ThreadList.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Created by diasonov on 28.03.2017.
 */
public class main4 {

    public static void main(String[] args) throws IOException {
        ThreadList list = new ThreadList();

        int code = 0;
        Scanner in = new Scanner(System.in);
        do {
            code = menu();

            switch (code){
                case 1:{
                    System.out.print("enter name : ");
                    String name = in.nextLine();
                    System.out.print("enter phone : ");
                    Integer phone = in.nextInt();
                    student student = new student(name,phone);
                    list.add(student);
                }break;
                case 2:{
                    System.out.print("enter phone : ");
                    Integer phone = in.nextInt();
                    list.deleteByPhone(phone);
                }break;
                case 3:{
                    System.out.print("enter name : ");
                    String name = in.nextLine();
                    list.deleteByName(name);
                }break;
                case 4:{
                    System.out.println("enter phone : ");
                    Integer phone = in.nextInt();
                    String name = list.searchByphone(phone);
                    if(name.length()==0){
                        System.out.println("Not found");
                        break;
                    }
                    System.out.println("Name : " + name);
                }
                case 5:{
                    System.out.println("enter name : ");
                    String name = in.nextLine();
                    Integer phone = list.searchByName(name);
                    if(phone == 0) {
                        System.out.println("not found");
                        break;
                    }
                    System.out.println("Phone : " + phone);
                }break;
                case 6:{

                    System.out.println("is empty : " +list.isEmpty());
                }break;
                case  7:{
                    printName(list);
                }break;
                case 8:{
                    printPhone(list);
                }break;
                case 9:{
                    revprintName(list);
                }break;
                case 10:{
                    revprintPhone(list);
                }break;
                case 11:{
                    readFile("data/data.txt",list);
                }break;
            }

        }while(code!=0);
        in.close();
        return;
    }

    public static int menu(){
        Scanner in = new Scanner(System.in);
        System.out.println("1 - add");
        System.out.println("2 - remove by phone");
        System.out.println("3 - remove by Name");
        System.out.println("4 - search by phone");
        System.out.println("5 - search by Name");
        System.out.println("6 - is empty");
        System.out.println("7 - print by Name");
        System.out.println("8 - print by Phone");
        System.out.println("9 - rev print by name");
        System.out.println("10- rev print by Phone");
        System.out.println("11- readFile");
        System.out.println("0 - exit");
        int  n ;
        n = in.nextInt();
       // in.close();

        return n;
    }

    public static void printPhone(ThreadList list) {
        System.out.println("-----------------------------------");
        System.out.println("           Print by Phone          ");
        System.out.println("-----------------------------------");
        TIteratorPhone iterator2 = list.IteratorPhone();
        if(!iterator2.hasNext()){ System.out.println("list is empty"); return;}
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next().toString());
        }
    }

    public static void revprintPhone(ThreadList list) {
        System.out.println("-----------------------------------");
        System.out.println("       rev Print by Phone          ");
        System.out.println("-----------------------------------");
        TIteratorPhone iterator2 = list.IteratorPhone();
        student firts = new Student("",0);
        if(!iterator2.hasNext()){ System.out.println("list is empty"); return;}
        while (iterator2.hasNext()) {
            firts = iterator2.next();
        }
        System.out.println(firts.toString());
        while(iterator2.hasPrev()){
            firts = iterator2.prev();
            System.out.println(firts.toString());

        }
    }

    public static void revprintName(ThreadList list) {
        System.out.println("-----------------------------------");
        System.out.println("        rev Print by Name          ");
        System.out.println("-----------------------------------");
        TIteratorName iterator2 = list.IteratorName();
        student firts = new Student("",0);
        if(!iterator2.hasNext()){ System.out.println("list is empty"); return;}
        while (iterator2.hasNext()) {
            firts = iterator2.next();
        }
        System.out.println(firts.toString());
        while(iterator2.hasPrev()){
            firts = iterator2.prev();
            System.out.println(firts.toString());

        }
    }

    public static void printName(ThreadList list) {
        System.out.println("-----------------------------------");
        System.out.println("           Print by Name           ");
        System.out.println("-----------------------------------");
        TIteratorName iterator2 = list.IteratorName();
        if(!iterator2.hasNext()){ System.out.println("list is empty"); return;}
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next().toString());
        }
    }

    public static void readFile(String source,ThreadList list){
        System.out.println("Read from "+source);
        Path path = Paths.get(source);
        try{
            List<String> lines = Files.readAllLines(path);
            ListIterator<String> iterator = lines.listIterator();
            while(iterator.hasNext()){
                String name = iterator.next();
                Integer phone = 0;
                if(iterator.hasNext()) phone = Integer.parseInt(iterator.next());

                student student = new student(name,phone);
                list.add(student);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error reading");
        }
    }
}