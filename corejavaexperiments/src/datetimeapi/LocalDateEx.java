package datetimeapi;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class LocalDateEx {
    final String pattern="dd/MM/yyyy";
    private DateTimeFormatter format =DateTimeFormatter.ofPattern(pattern);

    /*
       dd-MM-yyyy
       26-11-2021

     */
    public LocalDate convertToDate(String text){
       LocalDate date=LocalDate.parse(text, format);
       return date;
    }

    public String convertToText(LocalDate date){
       String text= date.format(format);
       return text;
    }

    public static void main(String args[]){
        LocalDateEx demo=new LocalDateEx();
        String dateText="15/08/1947";
        LocalDate date=demo.convertToDate(dateText);
        System.out.println("day="+date.getDayOfMonth()+" month="+date.getMonthValue() +" year="+date.getYear());

        LocalDate today =LocalDate.now();
        String todayText=demo.convertToText(today);
        System.out.println("today="+todayText);

        LocalDate covidIndia=LocalDate.of(2020,3,1);
        String covidDateText=demo.convertToText(covidIndia);
        System.out.println("covid date text="+covidDateText);
    }


}
