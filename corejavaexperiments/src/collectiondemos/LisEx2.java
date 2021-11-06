package collectiondemos;

import java.util.ArrayList;
import java.util.List;

public class LisEx2 {

    /*
        if odd number is found ,replace it with the next even number
        first way
     */
    public List<Integer> convert1(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int element = list.get(i);
            if (!(element % 2 == 0)) {
                int even = element + 1;
                list.set(i, even);
            }
        }
        return list;
    }

    /*
       if odd number is found ,replace it with the next even number
       second way
    */
    public List<Integer> convert2(List<Integer> list) {
        List<Integer> result = new ArrayList<>();
        for (int element : list) {
            if (element % 2 == 0) {
                result.add(element);
            } else {
                int even = element + 1;
                result.add(even);

            }
        }
        return result;
    }


}
