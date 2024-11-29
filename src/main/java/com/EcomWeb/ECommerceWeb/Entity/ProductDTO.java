package com.EcomWeb.ECommerceWeb.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private int id;
    private String name;
    private String Description;
    private String Brand;
    private long price;
    private int Stock;


    private String SubCategory;
    private String Category;


}
