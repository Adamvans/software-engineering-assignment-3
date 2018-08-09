/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
    }
}
