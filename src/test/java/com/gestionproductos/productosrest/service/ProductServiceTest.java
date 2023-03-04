package com.gestionproductos.productosrest.service;

import com.gestionproductos.productosrest.model.Product;
import com.gestionproductos.productosrest.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        product = Product.builder().name("Laptop").precio(34).build();
    }

    @Test
    void productList() {
        Mockito.when(productRepository.findAll()).thenReturn(Arrays.asList(product));
        assertNotNull(productService.productList());
    }
}