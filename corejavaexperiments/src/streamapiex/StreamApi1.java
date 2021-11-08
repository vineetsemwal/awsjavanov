package streamapiex;

import java.util.Collection;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamApi1 {

    /**
     * find sum of all length of those strings starting fom A
     *  hello
     *  And
     *  Abcd
     *  good
     */
    public int count1(Collection<String> strings){
        int count=0;
        for(String str:strings){
            if(str.startsWith("a")){
              count=count+str.length();
            }
        }

        return count;

      }

      public int count2(Collection<String>strings){
      Optional<Integer>optional= strings.stream()
               .filter(str->str.startsWith("a"))
               .map(str->str.length())
               .reduce((num1,num2)->num1+num2);

      if(!optional.isPresent()){
          return 0;
      }

      int result=optional.get();
      return result;

    }


}
