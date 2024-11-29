package com.EcomWeb.ECommerceWeb.Controller;

import com.EcomWeb.ECommerceWeb.Entity.Product;
import com.EcomWeb.ECommerceWeb.Entity.ProductDTO;
import com.EcomWeb.ECommerceWeb.Services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServices productServices;

    @GetMapping("/All")
    public List<ProductDTO> getAllProduct()
    {
        return productServices.getAllProduct();
    }

    @GetMapping("/subcategory/{subcate}")
    public List<ProductDTO> getAllProductBySubcat(@PathVariable String subcate)
    {
        return productServices.getBySubCat(subcate);
    }

    @GetMapping("/category/{cate}")
    public List<ProductDTO> getAllProductByCategory(@PathVariable String cate)
    {
        return productServices.getByCategoryName(cate);
    }

    @GetMapping("/Brand/{Brand}")
    public List<ProductDTO> getByBrand(@PathVariable String Brand)
    {
        return productServices.getByBrandname(Brand);
    }

    @PostMapping("/addNew")
    public ResponseEntity<?> AddProduct(@RequestBody ProductDTO productDTO)
    {
        return productServices.addProduct(productDTO);
    }

    @PutMapping("/Update")
    public ResponseEntity<?> UpdateProduct(@RequestBody ProductDTO productDTO)
    {
        return productServices.UpdateProduct(productDTO);
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<?> DeleteProduct(@PathVariable int id)
    {
        return productServices.DeleteProduct(id);
    }
}
