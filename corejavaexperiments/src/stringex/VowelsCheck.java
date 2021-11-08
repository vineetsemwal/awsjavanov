package stringex;

import java.util.*;
public class VowelsCheck {

    boolean checkAllVowelsExist(String input){
        Set<String>found=new HashSet<>();
        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            if(ch=='a' || ch=='e'||ch=='i' || ch=='o' || ch=='u'){
                String charStr=""+ch;
                found.add(charStr);
            }
        }
        if(found.size()==5){
            return true;
        }

        return false;

    }
}
