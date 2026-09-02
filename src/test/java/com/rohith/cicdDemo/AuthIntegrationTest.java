package com.rohith.cicdDemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rohith.cicdDemo.dto.UserRegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AuthIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldRegisterUser() throws Exception {

        UserRegisterRequest request =
                new UserRegisterRequest(
                        "Rohith S",
                        "rohith@test.com",
                        "9092525259",
                        "Maggi",
                        "secret123");

        mockMvc.perform(
                        post("/v1/auth/register")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldThrowErrorOnRegisterUser() throws Exception {

        UserRegisterRequest request =
                new UserRegisterRequest(
                        "Rohith S",
                        "rohith@test.com",
                        "909255259",
                        "Maggi",
                        "secret123");

        mockMvc.perform(
                        post("/v1/auth/register")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
}
