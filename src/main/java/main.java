import Stack.MyStack;

import java.util.Iterator;

/**
 * Created by diasonov on 09.02.2017.
 */



public class main {

    public static void main(String[] args){

        int k = 5;
        int num =0;
        int test = 0;
        Integer array[] = {1,2,-54,-4,-7};

        for(int i=0;i<k;i++){
            if(array[i]<0 && array[i]%10 != -4){
                //test = array[i]%10;
                if(array[i]<num)
                {
                    num = array[i];
                }
            }
        }

        System.out.print(num);

        return;

    }

}
