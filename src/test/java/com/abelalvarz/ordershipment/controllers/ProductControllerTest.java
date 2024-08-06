package com.abelalvarz.ordershipment.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/product"))
                .andExpect(status().isOk());
    }

    @Test
    void getAllProductByCategory() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/product/category?category=COMPUTING"))
                .andExpect(status().isOk());
    }

    @Test
    void getProductById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/product/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}