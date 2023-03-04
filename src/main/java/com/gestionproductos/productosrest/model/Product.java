package com.gestionproductos.productosrest.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product{
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private float precio;
}
