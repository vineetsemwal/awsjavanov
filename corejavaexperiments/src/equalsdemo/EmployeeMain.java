package equalsdemo;

public class EmployeeMain {

    public  static void main(String[] args){
        Employee emp1=new Employee();
        emp1.setId(1);
        emp1.setName("prachi");

        Employee emp2=new Employee();
        emp2.setId(1);
        emp2.setName("prachi");

        boolean identity=emp1==emp2;
        boolean equals=emp1.equals(emp2);

        System.out.println("identity="+identity);//false
        System.out.println("equality="+equals);//true

    }
}
