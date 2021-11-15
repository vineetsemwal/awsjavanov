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

        EmployeeAddress address2 = new EmployeeAddress();
        address2.setCity("Chennai");
        address2.setHouseAddress("xyz road, rajni home");


        Employee emp1 = new Employee();
        emp1.setName("kaushik");
        emp1.setSalary(90000);


        Employee emp2 = new Employee();
        emp2.setName("harikishan");
        emp2.setSalary(80000);

        transaction.begin();
        em.persist(address1);
        emp1.setAddress(address1);

        em.persist(emp1);

        em.persist(address2);
        emp2.setAddress(address2);
        em.persist(emp2);

        em.persist(emp2);
        System.out.println("emp1 id generated=" + emp1.getId());
        System.out.println("emp2 id generated=" + emp2.getId());
        display(emp1);
        display(emp1.getAddress());
        display(emp2);
        display(emp2.getAddress());

        System.out.println("find employee with address");
        Employee foundEmployee=em.find(Employee.class,emp1.getId());
        display(foundEmployee);
        EmployeeAddress foundAddress=foundEmployee.getAddress();
        display(foundAddress);


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
