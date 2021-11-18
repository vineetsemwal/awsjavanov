package stringex;

import java.util.HashSet;
import java.util.Set;

/**
 * check all letters are there in the input
 */
public class PanagramCheck {


    boolean check1(String input){
        input=input.toLowerCase();
        Set<String> set=new HashSet<>();
        for (int i=0;i <input.length();i++){
           char ch=input.charAt(i);
           if(ch>='a' && ch<='z'){
             String chStr=""+ch;
               set.add(chStr);
           }
        }
        int size= set.size();
        boolean check=size==26;
        return check;
    } 


}
