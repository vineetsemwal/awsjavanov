package enumsdemo;

public class DayBreakMain {

    public static void main(String args[]){
        DayBreak lunch=DayBreak.LunchBreak;
        String lunchTime=lunch.getTime();
        System.out.println("break="+lunch+" time="+lunchTime);
    }
}
