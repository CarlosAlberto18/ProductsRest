package com.gestionproductos.productosrest.repository;

import com.gestionproductos.productosrest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
