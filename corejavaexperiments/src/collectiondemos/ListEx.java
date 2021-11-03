package collectiondemos;

import java.util.ArrayList;
import java.util.List;

public class ListEx {

    public static void main(String args[]){
        List<Integer>list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ListEx example=new ListEx();
        example.removeOddNumbers(list);
        example.display(list);


    }

    public void display(List<Integer>list){
        for(Integer num:list){
            System.out.println("number is "+num);
        }
    }

    public  void removeOddNumbers(List<Integer> list){
        List<Integer>toBeRemoved=new ArrayList<>();

        for (Integer num:list){
            if(num%2!=0){
            toBeRemoved.add(num);
            }
        }

        list.removeAll(toBeRemoved);

    }
}
