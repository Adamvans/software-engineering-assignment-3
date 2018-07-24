/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Adam Evans
 */
public class SqlConnecter {
    Connection con;
    Statement stmt;
    String userName;
    String password;
    String url;
    
    
    public SqlConnecter() throws SQLException, ClassNotFoundException 
    {
        this.userName = "username";
        this.password = "password";
        this.url = "jdbc:sqlserver://MYPC\\SQLEXPRESS;databaseName=MYDB";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        this.con = DriverManager.getConnection(url, userName, password);
        this.stmt = (Statement) con.createStatement();
    }
    
    public void insertData()
    {
        
    }
    
    public void getData()
    {
        
    }
    
    public void closeCon()
    {
        
    }
    
    
}
