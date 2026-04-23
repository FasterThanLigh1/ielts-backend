package com.fasterthanligh1.ielts_backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnWelcomeMessage_WhenNameIsProvided() throws Exception {
        mockMvc.perform(get("/api/user").param("name", "gemini"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, GEMINI!"));
    }

    @Test
    void shouldReturn500_WhenNameIsMissing() throws Exception {
        mockMvc.perform(get("/api/user"))
                .andExpect(status().isInternalServerError());
    }
}