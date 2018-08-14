/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;


import java.math.BigDecimal;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author Adam Evans
 */
public class SqlConnecter {
    Connection con;
    Statement stmt;
    String userName;
    String password;
    String hostname;
    String dbName;
    String port;
    String url;
    ResultSet rs;
    String sqlCode;
    
    
    public SqlConnecter()  
    {
        this.userName = "sql3250594";
        this.password = "3SnKBehkyi";
        this.hostname = "sql3.freemysqlhosting.net";
        this.dbName = "sql3250594";
        this.port = "3306";
        this.url =  "jdbc:mysql://" + hostname + ":" + port + "/" + dbName;
        this.stmt = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException c)
        {
            String error = "class not found: " + c.getMessage();
            System.err.println(error);
        }
        try
        {
            this.con = DriverManager.getConnection(url, userName, password);
        }
        catch(SQLException e)
        {
            String error = "SQL connection failed: " + e.getMessage();
            System.err.println(error);
        }
        this.sqlCode = "CREATE TABLE IF NOT EXISTS "+ this.dbName +".users("
                + "	id integer PRIMARY KEY AUTO_INCREMENT,"
                + "	name text NOT NULL,"
                + "	password text NOT NULL"
                + ")";
        try 
        {
            this.stmt = this.con.createStatement();
            this.stmt.execute(sqlCode);
        } 
        catch (SQLException ex) 
        {
            String error = "cant create table: " + ex.getMessage();
            System.err.println(error);
        }
        this.sqlCode = "CREATE TABLE IF NOT EXISTS "+ this.dbName +".stock(\n"
                + "	id integer PRIMARY KEY AUTO_INCREMENT,"
                + "	cost integer NOT NULL,"
                + "	name text NOT NULL,"
                + "	ticker text NOT NULL"
                + ")";
        try 
        {
            this.stmt.execute(sqlCode);
        } 
        catch (SQLException ex) 
        {
            String error = "cant create table: " + ex.getMessage();
            System.err.println(error);
        }
    }
    
    public void insertData(String name, String ticker, int cost)
    {
        String insert = "INSERT INTO  "+ this.dbName +".stock VALUES (default ,  '"+ cost +"', '"+ name +"', '"+ ticker +"')";
        try
        {
            this.stmt.execute(insert);
        }
        catch(SQLException e)
        {
            String error = "SQL insert failed: " + e.getMessage();
            System.err.println(error);
        }
    }
    
    public void insertUser(String username, String password)
    {

        String insert = "INSERT INTO  "+ this.dbName +".users VALUES (default ,  '"+ username +"', '"+ password +"')";
        try
        {
            this.stmt.execute(insert);
        }
        catch(SQLException e)
        {
            String error = "cant insert into: " + e.getMessage();
            System.err.println(error);
        }

    }
    
    public JsonObject getData()
    {
       String get = "SELECT * FROM "+ this.dbName +".stock";
       try
        {
           this.rs = this.stmt.executeQuery(get);
        }
        catch(SQLException e)
        {
            String error = "SQL query failed: " + e.getMessage();
            System.err.println(error);
        }
       return createMessage();
    }
    
    public JsonObject getPassword(String user)
    {
        String get = "SELECT * FROM "+ this.dbName +".users WHERE name = '"+user+"'";
        try
        {
            this.rs = this.stmt.executeQuery(get);
        }
        catch(SQLException e)
        {
            String error = "SQL query failed: " + e.getMessage();
            System.err.println(error);
        }
        return createpwdMessage();
    }
    
    private JsonObject createpwdMessage() {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        try 
        {
            while (this.rs.next())
            {
                builder.add(rs.getString("username"),rs.getString("password"));
            }
        } 
        catch (SQLException ex) 
        {
            System.err.println("SQL query failed: " + ex.getMessage());
        }
                
        JsonObject addMessage = builder.build();
        return addMessage;
    }
    
    private JsonObject createMessage() {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        try 
        {
            while (this.rs.next())
            {
                builder.add(rs.getString("name"),rs.getString("ticker"));
                builder.add(rs.getString("name"),rs.getString("cost"));
            }
        } 
        catch (SQLException ex) 
        {
            String error = "SQL result failed: " + ex.getMessage();
            System.err.println(error);
        }
                
        JsonObject addMessage = builder.build();
        return addMessage;
    }
    
    public void closeCon()
    {
        
    }
    
    
}
