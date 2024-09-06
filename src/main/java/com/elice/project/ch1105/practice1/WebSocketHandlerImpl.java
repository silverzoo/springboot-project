package com.elice.project.ch1105.practice1;


import org.springframework.web.socket.*;

//[지시사항3] - WebSocket을 핸들링하기 위한 인터페이스 구현
public class WebSocketHandlerImpl implements WebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("WebSocket 연결 성공!");
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        if (message instanceof TextMessage) {
            String payload = ((TextMessage) message).getPayload();
            System.out.println("Received message: " + payload);
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        System.err.println("WebSocket 오류 발생: " + exception.getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        System.out.println("WebSocket 연결 종료!");
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
