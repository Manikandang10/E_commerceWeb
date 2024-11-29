package com.EcomWeb.ECommerceWeb.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String Brand;
    private String Description;
    private long Price;
    private int Stock;

    @ManyToOne
    @JoinColumn(name = "Subcat",nullable = false,unique = false)
    private SubCategory Subcategory;

    @ManyToOne
    @JoinColumn(name = "Category",nullable = false)
    private Category Category;
}
