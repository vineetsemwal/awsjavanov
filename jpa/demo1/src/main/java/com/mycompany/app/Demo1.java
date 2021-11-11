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
        Employee emp1 = new Employee();
        emp1.setName("kaushik");
        emp1.setSalary(90000);

        Employee emp2 = new Employee();
        emp2.setName("harikishan");
        emp2.setSalary(80000);

        transaction.begin();
        em.persist(emp1);
        em.persist(emp2);
        System.out.println("emp1 id generated=" + emp1.getId());
        System.out.println("emp2 id generated=" + emp2.getId());
        display(emp1);
        display(emp2);


        transaction.commit();
        em.close();
    }

    void display(Employee emp) {
        System.out.println("id=" + emp.getId() + " name=" + emp.getName() + " sal=" + emp.getSalary());
    }


}
