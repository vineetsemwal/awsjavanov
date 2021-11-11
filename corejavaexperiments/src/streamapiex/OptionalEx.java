package streamapiex;

import java.util.*;

public class OptionalEx {

    public static void main(String[] args) {
      List<Integer>list=new ArrayList<>();
      list.add(1);
      list.add(2);
      list.add(3);
      OptionalEx demo=new OptionalEx();
      Optional<Integer>optional1=demo.sum1(list);
      Optional<Integer>optional2=demo.sum2(list);
      if(optional1.isPresent()){
          int val= optional1.get();
          System.out.println("using stream api,value is "+val);
      }
      if(optional2.isPresent()){
          int val=optional2.get();
          System.out.println("not using stream api ,value is "+val);

      }
    }

    Optional<Integer> sum1(Collection<Integer> collection) {
        Optional<Integer> result = collection.stream()
                .reduce((num1, num2) -> num1 + num2);
        return result;
    }

    Optional<Integer> sum2(Collection<Integer> collection) {
        int total = 0;
        for (int element : collection) {
            total = total + element;
        }
        Optional<Integer> optional = Optional.of(total);
        return optional;
    }

}
