package com.elice.project;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DatabaseConnectionManager {

    private Connection connection;

    @PostConstruct
    public void init() {
        System.out.println("데이터베이스 연결 관리자 초기화(@PostConstruct)");
        try {
            //예시를 위한 가상 연결 URL
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?characterEncoding=UTF-8&serverTimezone=UTC&", "elice", "1234");
            System.out.println("데이터베이스 연결 성공");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("빈 소멸 전 정리 작업(@PreDestroy)");
        if(connection != null) {
            try {
                connection.close();
                System.out.println("데이터베이스 연결 종료");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

//출력 결과
