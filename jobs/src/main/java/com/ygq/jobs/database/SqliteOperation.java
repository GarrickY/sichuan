package com.ygq.jobs.database;

import java.sql.*;

public class SqliteOperation {
    String sqlDriver = "org.sqlite.JDBC";
    Connection connection;
    Statement statement;
    String sql;

    public void connectDatabase() throws ClassNotFoundException, SQLException {

        connection = DriverManager.getConnection("jdbc:sqlite:ygq.db");   //连接数据库ygq.db,不存在则创建
        statement = connection.createStatement(); //创建连接对象，是Java的一个操作数据库的重要接口
    }

    public void createDatabase() throws SQLException {
        sql = "create table userlist(name varchar(20),age varchar(20))";   //设置table字段及属性
        statement.executeUpdate("drop table if exists userlist"); //判断是否有表userlist的存在。有则删除
        statement.executeUpdate(sql);   //创建数据库
    }

    public void insertData() throws SQLException, ClassNotFoundException {
        connectDatabase();
        createDatabase();
        System.out.println("insert data into table: userlist");
        statement.executeUpdate("insert into userlist values('guiqing','50')");//向数据库中插入数据
        statement.executeUpdate("insert into userlist values('shu','49')");//向数据库中插入数据
        ResultSet result = statement.executeQuery("select * from userlist");
        getData();
    }

    public void deleteData() throws SQLException, ClassNotFoundException {
        connectDatabase();
        createDatabase();
        System.out.println("delete data...");
        statement.executeUpdate("insert into userlist values('hejiang','200')");//向数据库中插入数据
        getData();
        statement.executeUpdate("delete from userlist where name='hejiang'");//向数据库中插入数据
        System.out.println("delete data from table: userlist");
        getData();
    }

    public void modifyData() throws SQLException, ClassNotFoundException {
        connectDatabase();
        createDatabase();
        System.out.println("Update tables...");
        statement.executeUpdate("insert into userlist values('chongqing','150')");//向数据库中插入数据
        getData();
        System.out.println("Update tables result...");
        statement.executeUpdate("update userlist set age='100' where name='chongqing'");//向数据库中插入数据
        System.out.println("delete data from table: userlist");
        getData();
    }

    public void getData() throws SQLException, ClassNotFoundException {
        System.out.println("Get data...");
        ResultSet result = statement.executeQuery("select * from userlist");
        while (result.next()) {
            System.out.println("Name is " + result.getString("name"));
            System.out.println("Age is " + result.getString("age"));
        }
        result.close();
    }

    protected void finalize() throws SQLException {
        connection.close();
        System.out.println("connection is connected.");
    }
}
