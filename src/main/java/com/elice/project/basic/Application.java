package com.elice.project.basic;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        DatabaseConnectionManager dbManager = context.getBean(DatabaseConnectionManager.class);
        Connection connection = dbManager.getConnection();
        System.out.println("데이터 베이스 연결 성공: " + connection != null);
        context.close();
    }
}
