package com.elice.project.ch1105.practice1;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
//[지시사항1] - WebSocket을 사용하기 위한 어노테이션 추가
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //[지시사항2] - `/websocket-endpoint` 경로의 엔드포인트를 가지는 `WebSocketHandlerImpl` 핸들러를 추가
        WebSocketHandlerImpl webSocketHandler = new WebSocketHandlerImpl();
        registry.addHandler(webSocketHandler, "websocket-endpoint");
    }
}