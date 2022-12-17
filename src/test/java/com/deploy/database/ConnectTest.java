package com.deploy.database;

import com.deploy.study.StudyApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootTest(classes = StudyApplication.class)
public class ConnectTest {

    @Value("${spring.datasource.driver-class-name}")
    private String DRIVER;

    @Value("${spring.datasource.url}")
    private String URL;

    @Value("${spring.datasource.username}")
    private String USER;

    @Value("${spring.datasource.password}")
    private String PW;

    @Test
    public void testConnection() throws Exception {
        Class.forName(DRIVER);
        Connection con = DriverManager.getConnection(URL, USER, PW);
        Assertions.assertNotNull(con);
    }

}
