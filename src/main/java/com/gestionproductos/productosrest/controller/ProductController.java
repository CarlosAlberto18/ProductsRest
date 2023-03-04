package com.gestionproductos.productosrest.controller;

import com.gestionproductos.productosrest.model.Product;
import com.gestionproductos.productosrest.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Operation(summary = "Get all Products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all Products",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Products not found",
                    content = @Content) })
    @GetMapping()
    public List<Product> productListController(){
        return productService.productList();
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getbyId(@PathVariable Integer id){
        try {
            Product product = productService.getProductoById(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (Exception exception){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping()
    public void saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
    }
    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product, @PathVariable Integer id){
        try {
            Product product1 = productService.getProductoById(id);
            product1.setName(product.getName());
            product1.setPrecio(product.getPrecio());
            productService.saveProduct(product1);
            return new ResponseEntity<Product>(HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
    }
}
