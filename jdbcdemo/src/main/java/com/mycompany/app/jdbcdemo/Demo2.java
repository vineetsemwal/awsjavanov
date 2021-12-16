package com.mycompany.app.jdbcdemo;

//import org.postgresql.Driver;

import java.sql.*;


/**
 * students
 * id - long
 * name- String
 * age-int
 */
public class Demo2 {
    public static void main(String[] args) throws Exception {
        Demo2 demo1 = new Demo2();
        demo1.start();
    }

    public void start() throws ClassNotFoundException, SQLException {
        //step1 register driver
        //Driver driver=new Driver();
        //DriverManager.registerDriver(driver);
        Class.forName("org.postgresql.Driver");

        //step2 create Connection
        String url = "jdbc:postgresql://localhost:5432/training";
        Connection connection = DriverManager.getConnection(url, "postgres", "scooby");

        //Create statement
        String insertSql = "insert into students(id, name, age) values(?, ?, ?)";
        PreparedStatement insertStatement = connection.prepareStatement(insertSql);
        insertStatement.setLong(1, 5);
        insertStatement.setString(2, "narmrata");
        insertStatement.setInt(3, 21);
        int rows = insertStatement.executeUpdate();
        System.out.println("rows inserted count=" + rows);
        insertStatement.close();

        //step4 execute query
        String fetchSql = "select * from students";
        PreparedStatement fetchStatement = connection.prepareStatement(fetchSql);
        ResultSet resultSet = fetchStatement.executeQuery();
        //resultmetadata gives information about data
        ResultSetMetaData resultSetMetaData= resultSet.getMetaData();
        int colsCount=resultSetMetaData.getColumnCount();
        for(int i=1;i<=colsCount;i++){
           String name= resultSetMetaData.getColumnLabel(i);
           String dataType=resultSetMetaData.getColumnTypeName(i);
            System.out.println("column name="+name+" datatye="+dataType);
        }

        System.out.println("columns count="+colsCount+" ");
        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println("id=" + id + " name=" + name + " age=" + age);
        }


        fetchStatement.close();
        connection.close();

    }
}
