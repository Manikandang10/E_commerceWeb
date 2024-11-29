package com.EcomWeb.ECommerceWeb.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Subcategory")
@AllArgsConstructor
@NoArgsConstructor
public class SubCategory {

    @Id
    private String Subcategory;

    @ManyToOne
    @JoinColumn(name = "Maincategory")
    private Category category;
}
