package com.rohith.cicdDemo;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.TimeZone;

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public abstract class BaseIntegrationTest {

    @BeforeAll
    static void setup() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
    }

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres =
            new PostgreSQLContainer<>("postgres:16")
                    .withDatabaseName("testdb")
                    .withUsername("test")
                    .withPassword("test")
                    .withEnv("TZ", "Asia/Kolkata");

//    @DynamicPropertySource
//    static void configureProperties(DynamicPropertyRegistry registry) {
//
//        registry.add(
//                "spring.datasource.url",
//                postgres::getJdbcUrl);
//
//        registry.add(
//                "spring.datasource.username",
//                postgres::getUsername);
//
//        registry.add(
//                "spring.datasource.password",
//                postgres::getPassword);
//    }
}
