package com.mycompany.app;

import javax.persistence.*;

public class Demo1 {

    public static void main(String arg[]) {
        Demo1 demo = new Demo1();
        demo.start();
    }


    public void start() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        EmployeeAddress address1 = new EmployeeAddress();
        address1.setCity("mumbai");
        address1.setHouseAddress("abcd road, mannat");


        Employee emp1 = new Employee();
        emp1.setName("kaushik");
        emp1.setSalary(90000);


        transaction.begin();
        em.persist(address1);
        emp1.setAddress(address1);

        em.persist(emp1);

        address1.setEmployee(emp1);

        System.out.println("emp1 id generated=" + emp1.getId());
        display(emp1);
        display(emp1.getAddress());



        System.out.println("find employee with address");
        Employee foundEmployee=em.find(Employee.class,emp1.getId());
        display(foundEmployee);
        EmployeeAddress foundAddress1=foundEmployee.getAddress();
        display(foundAddress1);


        System.out.println("fetchhing addrees and then employee from address");
        EmployeeAddress foundAddress2=em.find(EmployeeAddress.class,address1.getId());
        Employee empFromAdd=foundAddress2.getEmployee();
        display(empFromAdd);
        display(foundAddress2);


        transaction.commit();
        em.close();
    }

    void display(Employee emp) {
        System.out.println("id=" + emp.getId() + " name=" + emp.getName() + " sal=" + emp.getSalary());
    }

    void display(EmployeeAddress address) {
        System.out.println("address-"+address.getId()+"-"+address.getCity()+"-"+address.getHouseAddress());
    }

}
