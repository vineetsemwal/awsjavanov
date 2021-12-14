package datetimeapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeEx {
    final String pattern="dd/MM/yyyy-HH:mm";
    private DateTimeFormatter format =DateTimeFormatter.ofPattern(pattern);

    /*
       dd-MM-yyyy
       26-11-2021
     */
    public LocalDateTime convertToDateTime(String text){
        LocalDateTime date=LocalDateTime.parse(text, format);

        return date;
    }

    public String convertToText(LocalDateTime dateTime){
        String text= dateTime.format(format);
        return text;
    }


    public static void main(String args[]){
        DateTimeEx demo=new DateTimeEx();
        String text="26/11/2021-13:38";
        LocalDateTime dateTime=demo.convertToDateTime(text);
        System.out.println(dateTime.getHour()+" "+dateTime.getMinute()+" "+dateTime.getMonthValue());
        LocalDateTime now=LocalDateTime.now();
        String nowText=demo.convertToText(now);
        System.out.println("now text="+nowText);
    }
}
