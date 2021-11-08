package collectiondemos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/*
 {

    tamilnadu : { "chennai", "kajipuram" },

    "maharastra" : {"mumbai", "pune"}

  }

 */
public class MapEx1 {
   //map of keys state and values is Arraylist of cities
   private Map<String, ArrayList<String>> map = new HashMap<>();

    void add(String state, String city) {
        boolean exists = map.containsKey(state);
        if (exists) {
            ArrayList<String> cities = map.get(state);
            cities.add(city);

        } else {
            ArrayList<String> cities = new ArrayList<>();
            cities.add(city);
            map.put(state, cities);
        }
    }

    /**
     * case when state is given
     * @param state
     * @param city
     */
    void remove(String state, String city) {
        if (map.containsKey(state)) {
            ArrayList<String> cities = map.get(state);
            cities.remove(city);
        }
    }

    /**
     * case when state is not given
     * @param city
     */
    void remove(String city) {
        Set<String> states = map.keySet();
        for (String state : states) {
            ArrayList<String> cities = map.get(state);
            cities.remove(city);

        }
    }

}
