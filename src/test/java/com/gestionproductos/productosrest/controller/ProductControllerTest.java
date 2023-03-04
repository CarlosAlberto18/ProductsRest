package com.gestionproductos.productosrest.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@WebAppConfiguration
class ProductControllerTest {

    private final static String BASE_URL = "/products";

    MockMvc mockMvc;
    @Autowired
    private WebApplicationContext webApplicationContext;


    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void productListController() throws Exception {
        MvcResult mockMvcList = mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL)).andReturn();

        assertEquals(200,mockMvcList.getResponse().getStatus());
    }
}