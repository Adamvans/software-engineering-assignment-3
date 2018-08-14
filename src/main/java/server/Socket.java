/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;

/**
 *
 * @author Ethgar
 */
@ServerEndpoint("/server")
public class Socket {
    SqlConnecter conn = new SqlConnecter();
    StockPicker pick = new StockPicker();
    JsonArrayBuilder prices = Json.createArrayBuilder();
    
    public Socket(){}
    
    @OnOpen
    public void open(Session session) 
    {  
       //conn.insertUser("testuser", "testpassword");
       
    }
    
    @OnClose
    public void close(Session session) 
    {
        
    }
    
    @OnError
    public void onError(Throwable error) 
    {
        Logger.getLogger(Socket.class.getName()).log(Level.SEVERE, null, error);
    }
    
    @OnMessage
    public void handleMessage(String message, Session session) throws IOException, Exception 
    {
     
        JsonReader reader = Json.createReader(new StringReader(message));
        
        JsonArray jsonMessage = reader.readArray();
         
        System.out.println(jsonMessage);
         
       
         
       for(int i =0; i < jsonMessage.size(); i++)
       {
        
           String test = jsonMessage.getString(i);
           
           
            System.out.println(pick.getStockPrice(test));
            
           
                 prices.add(pick.getStockPrice(test));
            
            
       }
       
       JsonArray price = prices.build();
         
        System.out.println(price);
        
        session.getBasicRemote().sendObject(price);
        
         
    }
}
