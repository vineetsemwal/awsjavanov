package enumsdemo;

public class WeekDayMain {

    public static void main(String args[]){
        WeekDay sun1=WeekDay.Sunday;
        WeekDay sun2=WeekDay.Sunday;
        WeekDay mon=WeekDay.Monday;
        if(sun1==sun2){
            System.out.println("yes same object");
        }
        System.out.println("sunday="+sun1+" "+sun1.ordinal());
        System.out.println("moday="+mon+" "+mon.ordinal());

        WeekDay[] values=WeekDay.values();
        for(WeekDay day:values){
            System.out.println(day+" "+day.ordinal());
        }
    }
}
