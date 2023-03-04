package com.gestionproductos.productosrest.service;

import com.gestionproductos.productosrest.model.Product;
import com.gestionproductos.productosrest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> productList(){
        return productRepository.findAll();
    }
    public void saveProduct(Product product){
        productRepository.save(product);
    }
    public Product getProductoById(Integer id){
        return productRepository.findById(id).get();
    }
    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }
}
