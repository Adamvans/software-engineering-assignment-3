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
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Ethgar
 */
@ServerEndpoint("/server")
public class Socket {
    SqlConnecter conn;
    
    public Socket(){this.conn = new SqlConnecter();}
    
    @OnOpen
    public void open(Session session) 
    {  
        
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
    public void handleMessage(String message, Session session) throws IOException 
    {
        JsonReader reader = Json.createReader(new StringReader(message));
            JsonObject jsonMessage = reader.readObject();
            
            if ("existingUser".equals(jsonMessage.getString("action"))) 
            {
                String user = jsonMessage.getString("user");
                JsonObject returnmassage = conn.getPassword(user);
                String password = returnmassage .getString(user);
                if(password.equals(jsonMessage.getString("pass")))
                {
                    session.getAsyncRemote().sendText("Match");
                }
                else
                {
                   session.getAsyncRemote().sendText("DontMatch"); 
                }
            
            if ("newUser".equals(jsonMessage.getString("action"))) 
            {
                conn.insertUser(jsonMessage.getString("user"), jsonMessage.getString("pass"));
            }
    }
}
