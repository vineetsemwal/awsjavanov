package stringex;
/*
// EXAMPLE INPUT BL7A20181201
//date format is yyyyMMdd
class ExpiryCheck {

    length of
    string is 12return true

    public boolean checkLength(String input)

    extract batch
    number and return true if found
    First four
    letters represent
    batch length:index 0,1,3
    should be
    alphabet,
    index 2
    should be
    number

    public boolean batchNumberCheck(String input)

    //Year is starting after batch number(length-4)
    //if year >= 2015 and year=<2020, return true, else false
    public boolean yearCheck(String input)

    //if month>=1 and month <=12,return true,else false
    public int monthCheck(String input)

    //if day>=1 and day<=31, return true else false
    public int dayCheck(String input)
}
*/

class ExpiryCheck{

    public static void main(String args[]){
        ExpiryCheck demo=new ExpiryCheck();
        String input="BL7A20181201";
        boolean result=demo.batchNumberCheck(input);
        System.out.println("result="+result);
    }

    public boolean batchNumberCheck(String input){
        char ch0=input.charAt(0);
        char ch1=input.charAt(1);
        char ch2=input.charAt(2);
        char ch3=input.charAt(3);
        boolean charCheck=(ch0>='A' && ch0<='Z') && (ch1>='A' && ch1<='Z') && (ch3>='A' && ch3<='Z');
        System.out.println("charcheck="+charCheck);
        boolean numCheck=ch2>='0' && ch2<='9';
        System.out.println("numcheck="+numCheck);
        boolean result= charCheck && numCheck;
        return result;
    }

    /*
    boolean checkCapitalChar(char ch){
        boolean check=ch>='A' && ch<='Z';
        return check ;
    }
    */

}