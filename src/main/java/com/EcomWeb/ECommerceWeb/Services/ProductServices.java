package com.EcomWeb.ECommerceWeb.Services;

import com.EcomWeb.ECommerceWeb.Entity.Category;
import com.EcomWeb.ECommerceWeb.Entity.Product;
import com.EcomWeb.ECommerceWeb.Entity.ProductDTO;
import com.EcomWeb.ECommerceWeb.Entity.SubCategory;
import com.EcomWeb.ECommerceWeb.Repository.CategoryRepo;
import com.EcomWeb.ECommerceWeb.Repository.ProductRepo;
import com.EcomWeb.ECommerceWeb.Repository.SubCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServices {

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    SubCategoryRepo subCategoryRepo;

    @Autowired
    ProductRepo productRepo;


    public List<ProductDTO> getAllProduct()
    {
        List<Product> products=productRepo.findAll();

        return products.stream().map(product -> new ProductDTO(
               product.getId(),
               product.getName(),
               product.getDescription(),
               product.getBrand(),
               product.getPrice(),
               product.getStock(),
               product.getSubcategory().getSubcategory(),
               product.getCategory().getCategory()
        )).collect(Collectors.toList());
    }

    public List<ProductDTO> getBySubCat(String Subcat)
    {
        List<Product> Products=productRepo.getBySubCategoryName(Subcat);
        return Products.stream().map(product -> new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getBrand(),
                product.getPrice(),
                product.getStock(),
                product.getSubcategory().getSubcategory(),
                product.getCategory().getCategory()
        )).collect(Collectors.toList());
    }

    public List<ProductDTO> getByCategoryName(String cat)
    {
        List<Product> products =productRepo.findByCategoryName(cat);

        return products.stream().map(product -> new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getBrand(),
                product.getPrice(),
                product.getStock(),
                product.getSubcategory().getSubcategory(),
                product.getCategory().getCategory()
        )).collect(Collectors.toList());
    }

    public List<ProductDTO> getByBrandname(String bran)
    {
        List<Product> Products=productRepo.findByBrandName(bran);

        return Products.stream().map(product ->new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getBrand(),
                product.getPrice(),
                product.getStock(),
                product.getSubcategory().getSubcategory(),
                product.getCategory().getCategory()
        )).collect(Collectors.toList());
    }

    public ResponseEntity<?> addProduct(ProductDTO productDTO)
    {
        Category category=categoryRepo.findById(productDTO.getCategory()).
                orElseThrow(()->new RuntimeException("Category Is Not Available"));

        SubCategory subCategory=subCategoryRepo.findById(productDTO.getSubCategory())
                .orElseThrow(()->new RuntimeException("Subcategory is Not Available Please check Subcategory"));


        Product product=new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setBrand(productDTO.getBrand());
        product.setDescription(productDTO.getDescription());
        product.setStock(productDTO.getStock());
        product.setPrice(productDTO.getPrice());
        product.setSubcategory(subCategory);
        product.setCategory(category);

        Product savepro=  productRepo.save(product);
        if(savepro.getId() >0)
        {
            return ResponseEntity.ok("Data Saved Successfully");
        }
        return  ResponseEntity.ok("Data Not Saved");
    }

    public ResponseEntity<?> UpdateProduct(ProductDTO productDTO)
    {
        Category category=categoryRepo.findById(productDTO.getCategory()).
                orElseThrow(()->new RuntimeException("Category Is Not Available"));

        SubCategory subCategory=subCategoryRepo.findById(productDTO.getSubCategory())
                .orElseThrow(()->new RuntimeException("Subcategory is Not Available Please check Subcategory"));


        Product product=new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setBrand(productDTO.getBrand());
        product.setStock(productDTO.getStock());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setSubcategory(subCategory);
        product.setCategory(category);

        Product UpdeteProduct=  productRepo.save(product);
        if(UpdeteProduct.getId() >0)
        {
            return ResponseEntity.ok("Data Updated Successfully");
        }
        return  ResponseEntity.ok("Data Not Updated");
    }

    public ResponseEntity<?> DeleteProduct(int proId)
    {
        int v=productRepo.deleteById(proId);

        if(v >0)
        {
            return ResponseEntity.ok("Successfully deleted.....");
        }
        else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Data is Not Deleted... ");
        }
    }
 }
