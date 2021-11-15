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

        Department dev=new Department();
        dev.setDeptName("development");


        Employee emp1 = new Employee();
        emp1.setName("kaushik");
        emp1.setSalary(90000);

        Employee emp2 = new Employee();
        emp2.setName("aisha");
        emp2.setSalary(80000);

        transaction.begin();

        em.persist(dev);

        emp1.setDepartment(dev);
        emp2.setDepartment(dev);

        em.persist(emp1);
        em.persist(emp2);

        System.out.println("fetching employee and its dept");
        Employee foundEmp=em.find(Employee.class,emp1.getId());
        display(foundEmp);
        Department foundDept=foundEmp.getDepartment();
        display(foundDept);


        transaction.commit();
        em.close();
    }

    void display(Employee emp) {
        System.out.println("id=" + emp.getId() + " name=" + emp.getName() + " sal=" + emp.getSalary());
    }

    void display(Department dept) {
        System.out.println("department-"+dept.getId()+"-"+dept.getDeptName());
    }

}
