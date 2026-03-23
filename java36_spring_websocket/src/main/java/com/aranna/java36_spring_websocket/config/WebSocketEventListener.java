package com.aranna.java36_spring_websocket.config;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.aranna.java36_spring_websocket.controller.ChatMessage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class WebSocketEventListener {
    private final SimpMessageSendingOperations simpMessageSendingOperations;

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event){
        StompHeaderAccessor stompHeaderAccessor=StompHeaderAccessor.wrap(event.getMessage());
        String username=(String) stompHeaderAccessor.getSessionAttributes().get("username");
        if(username!=null){
            log.info("User disconnected: {}",username);
            var chatMessage=ChatMessage.builder()
            .sender(username)
            .build();
            simpMessageSendingOperations.convertAndSend("/topic/public",chatMessage);
        }
    }
}
