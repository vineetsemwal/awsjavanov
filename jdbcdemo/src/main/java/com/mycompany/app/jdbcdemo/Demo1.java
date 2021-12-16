package com.mycompany.app.jdbcdemo;

//import org.postgresql.Driver;

import java.sql.*;


/**
 *  students
 *  id - long
 *  name- String
 *  age-int
 */
public class Demo1 {
    public static void main(String[] args) throws Exception{
        Demo1 demo1=new Demo1();
        demo1.start();
    }

    public void start() throws ClassNotFoundException, SQLException {
        //step1 register driver
        //Driver driver=new Driver();
        //DriverManager.registerDriver(driver);
        Class.forName("org.postgresql.Driver");

        //step2 create Connection
        String url="jdbc:postgresql://localhost:5432/training";
        Connection connection=DriverManager.getConnection(url,"postgres","scooby");

        //Create statement
        Statement statement=connection.createStatement();

        String insertSql="insert into students(id, name, age) values("+4+","+"kamali"+","+ 21+")";
        int rows=statement.executeUpdate(insertSql);
        System.out.println("rows inserted count="+rows);

        //step4 execute query
        String fetchSql="select * from students";
        ResultSet resultSet=statement.executeQuery(fetchSql);
        while(resultSet.next()){
          long id= resultSet.getLong("id");
          String name=resultSet.getString("name");
          int age=resultSet.getInt("age");
            System.out.println("id="+id+" name="+name+" age="+age);
        }


        statement.close();
        connection.close();

    }
}
