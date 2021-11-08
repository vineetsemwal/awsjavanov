package doselectpractice;

import java.util.*;

public class Problem3 {
}


class Employee {
    private String name;
    private int salary;

    public Employee(String name, int sal) {
        this.name = name;
        this.salary = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

class EmployeeInfo {
    enum SortMethod {
        BYNAME, BYSALARY
    }

    public List<Employee> sort(List<Employee> emps, final SortMethod method) {
        if (method.equals(SortMethod.BYNAME)) {
            NameComparator comparator = new NameComparator();
            emps.sort(comparator);
            return emps;
        }

        SalaryComparator comparator = new SalaryComparator();
        emps.sort(comparator);
        return emps;


    }


    class SalaryComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee employee1, Employee employee2) {
            int sal1 = employee1.getSalary();
            int sal2 = employee2.getSalary();
            int compare = sal1 - sal2;
            return compare;
        }
    }


    class NameComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee employee1, Employee employee2) {
            String name1 = employee1.getName();
            String name2 = employee2.getName();
            int compare = name1.compareTo(name2);
            return compare;
        }
    }


    public boolean isCharacterPresent(Collection<Employee> emps, String character) {
       for(Employee emp:emps){
           String name=emp.getName();
           boolean check=name.startsWith(character);
           if(check){
               return true;
           }
       }
       return false;
    }

}