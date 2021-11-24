package apidemo;
/*
Calculator cal=new Calculator()
cal.sum(5,7)

 */
public class Calculator {

    private double internalAdd(double num1, double num2){
        return  num1+num2;
    }

    public double sum(double num1, double num2){
        return internalAdd(num1,num2);
    }

    public double sub(double num1, double num2){
        return num1-num2;
    }
}
