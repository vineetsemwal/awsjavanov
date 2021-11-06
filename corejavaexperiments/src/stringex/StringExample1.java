package stringex;

/*
"Arpit.MehtaID123456DTIT80L";
 */
public class StringExample1 {

    public static void main(String args[]) {
       StringExample1 example=new StringExample1();
       String input="Arpit.MehtaID123456DTIT80L";
       example.convert(input);
    }

    public Employee convert(String input) {
        int idStartIndex = input.indexOf("ID");
        String name = input.substring(0, idStartIndex);//Arpit.Mehta
        int nameDotIndex = name.indexOf(".");
        String firstName = name.substring(0, nameDotIndex);
        String lastName = name.substring(nameDotIndex + 1);
        int idValueStart = idStartIndex + 2;
        int dtStartIndex = input.indexOf("DT");
        String idStr = input.substring(idValueStart, dtStartIndex);
        int id = Integer.parseInt(idStr);
        int deptValueStart = dtStartIndex + 2;
        int deptValueEnd = deptValueStart + 2;
        String dept = input.substring(deptValueStart, deptValueEnd);
        String salaryStrInLac = input.substring(deptValueEnd);
        System.out.println("salary start ="+salaryStrInLac);
        String salStr = salaryStrInLac.substring(0, salaryStrInLac.length() - 1);
        double salary = Double.parseDouble(salStr);
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setDept(dept);
        employee.setSalaryInLac(salary);
       return employee;
    }


}


