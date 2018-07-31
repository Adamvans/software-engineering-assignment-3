/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.beans.Statement;
import java.sql.*;
import java.sql.PreparedStatement;

/**
 *
 * @author Adam Evans
 */
public class SqlConnecter {
    Connection con;
    PreparedStatement stmt;
    String userName;
    String password;
    String url;
    String database;
    String sqlCode;
    
    
    public SqlConnecter()  
    {
        this.userName = "epiz_22050198";
        this.password = "x3UkX8zPws5c";
        this.url = "jdbc:mysql://sql107.epizy.com/epiz_22050198_stocks";
        this.database = "epiz_22050198_stocks";
        try
        {
            Class.forName("java.sql.Driver");
        }
        catch(ClassNotFoundException c)
        {
            String error = "class not found: " + c.getMessage();
            System.err.println(error);
        }
        try
        {
            this.con = DriverManager.getConnection(url, userName, password);
            this.stmt = (PreparedStatement) con.createStatement();
        }
        catch(SQLException e)
        {
            String error = "SQL connection failed: " + e.getMessage();
            System.err.println(error);
        }
//        this.sqlCode = "CREATE TABLE IF NOT EXISTS users(\n"
//                + "	id integer PRIMARY KEY AUTO_INCREMENT,\n"
//                + "	name text NOT NULL,\n"
//                + "	password text NOT NULL,\n"
//                + ");";
//        this.stmt.execute(sqlCode);
//        this.sqlCode = "CREATE TABLE IF NOT EXISTS stock(\n"
//                + "	id integer PRIMARY KEY AUTO_INCREMENT,\n"
//                + "	cost integer NOT NULL,\n"
//                + "	name text NOT NULL,\n"
//                + "	ticker text NOT NULL,\n"
//                + ");";
//        this.stmt.execute(sqlCode);
    }
    
    public void insertData(String name, String ticker, int cost)
    {
        String insert = "INSERT INTO  `epiz_22050198_stocks`.`stock` (`id` ,`cost` , `name`, 'ticker') VALUES (NULL ,  '"+ cost +"', '"+ name +"', '"+ ticker +"')";
        try
        {
            this.stmt.execute(insert);
        }
        catch(SQLException e)
        {
            System.err.println("SQL insert failed: " + e.getMessage());
        }
    }
    
    public void insertUser(String username, String password)
    {
        String insert = "INSERT INTO  `epiz_22050198_stocks`.`users` (`id` ,`username` , `password`) VALUES (NULL ,  '"+ username +"', '"+ password +"')";
        try
        {
            this.stmt.execute(insert);
        }
        catch(SQLException e)
        {
            System.err.println("SQL insert failed: " + e.getMessage());
        }
    }
    
    public void getData()
    {
        
    }
    
    public void getPassword()
    {
        
    }
    
    public void closeCon()
    {
        
    }
    
    
}
