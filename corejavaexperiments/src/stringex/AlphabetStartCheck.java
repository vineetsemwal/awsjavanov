package stringex;

public class AlphabetStartCheck {
    public static void main(String[] args){
        AlphabetStartCheck demo=new AlphabetStartCheck();
        boolean result=demo.checkNameStartsWithAlphabet("1mohan");
        System.out.println("result="+result);
    }

    /**
     *  check first character is an alphabet between a-z  or A-Z
     * @param name : input string
     * @return true if it is character elese false
     */
   public boolean checkNameStartsWithAlphabet(String name){
        name=name.toLowerCase();
        char ch=name.charAt(0);
        boolean check=ch>='a' && ch<='z';
        return check;
    }

}
