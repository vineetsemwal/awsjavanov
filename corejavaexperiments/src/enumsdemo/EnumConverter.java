package enumsdemo;

public class EnumConverter {

    public WeekDay toEnum(String input){
        WeekDay weekdays[]=WeekDay.values();
        for(WeekDay weekDay:weekdays){
            String name=weekDay.name();
            if(name.equalsIgnoreCase(input)){
                return weekDay;
            }
        }
        throw new InvalidWeekDayException("invalid enum "+input);
    }

}
