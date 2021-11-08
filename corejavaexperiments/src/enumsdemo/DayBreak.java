package enumsdemo;

public enum DayBreak {

    MorningTeaBreak("11am"),
    LunchBreak("1pm"),
    EveningTeaBreak("4pm");

    private String time;

    DayBreak(String time){
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}
