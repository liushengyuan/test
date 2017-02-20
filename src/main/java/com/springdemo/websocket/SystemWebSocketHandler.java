package com.springdemo.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.springframework.messaging.Message;  
import org.springframework.web.socket.CloseStatus;  
import org.springframework.web.socket.TextMessage;  
import org.springframework.web.socket.WebSocketHandler;  
import org.springframework.web.socket.WebSocketMessage;  
import org.springframework.web.socket.WebSocketSession;  
  
/**
 *  SystemWebSocketHandler 配合WebSocketConfig 由spring管理  当做bean为单例模式 
 *  
 * @author jfw
 *
 */
public class SystemWebSocketHandler implements WebSocketHandler {  
       
    private Logger log = LoggerFactory.getLogger(SystemWebSocketHandler.class);  
      
    
    private static final Set<SystemWebSocketHandler> connections =
            new CopyOnWriteArraySet<SystemWebSocketHandler>();
    
    private static final String GUEST_PREFIX = "Guest";
    private static final AtomicInteger connectionIds = new AtomicInteger(0);
    private final String nickname;
    private WebSocketSession session;
    
    public SystemWebSocketHandler() {
        nickname = GUEST_PREFIX + connectionIds.getAndIncrement();
    }
   
    //相当于 @OnOpen
    @Override  
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {  
        log.info("ConnectionEstablished");  
        
        this.session = session;
        connections.add(this);
        String message = String.format("* %s %s", nickname, "has joined.");
        broadcast(new TextMessage(message));
        
    }  
   
    //相当于 @OnMessage
    @Override  
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {  
        log.info("handleMessage" + message.toString());  
        String filteredMessage = String.format("%s: %s",
                nickname, message.toString());
        broadcast(new TextMessage(filteredMessage));
        //sendMessageToUsers(new TextMessage(message.toString()));  
        //session.sendMessage(new TextMessage(new Date() + ""));  
    }  
   
    @Override  
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {  
        if(session.isOpen()){  
            session.close();  
        }  
        connections.remove(this);  
          
        log.info("handleTransportError" + exception.getMessage());  
    }  
   
    // @OnClose
    @Override  
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {  
    	connections.remove(this);
    	String message = String.format("* %s %s",
                nickname, "has disconnected.");
        broadcast(new TextMessage(message));
        log.info("afterConnectionClosed" + closeStatus.getReason());  
          
    }  
   
    @Override  
    public boolean supportsPartialMessages() {  
        return false;  
    }  
   
    /** 
     * 给所有在线用户发送消息 
     * 
     * @param message 
     */  
    private static void broadcast(TextMessage message) {
        for (SystemWebSocketHandler client : connections) {
            try {
                synchronized (client) {
                	client.session.sendMessage(message);
                }
            } catch (IOException e) {
                //log.debug("Chat Error: Failed to send message to client", e);
                connections.remove(client);
                try {
                    client.session.close();
                } catch (IOException e1) {
                    // Ignore
                }
                String messageEnd = String.format("* %s %s",
                        client.nickname, "has been disconnected.");
                broadcast(new TextMessage(messageEnd));
            }
        }
    }
}  
