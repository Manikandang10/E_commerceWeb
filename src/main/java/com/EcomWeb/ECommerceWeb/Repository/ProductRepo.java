package com.EcomWeb.ECommerceWeb.Repository;

import com.EcomWeb.ECommerceWeb.Entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

    @Query(value = "Select * from product where subcat= :subcat",nativeQuery = true)
    List<Product> getBySubCategoryName(@Param("subcat") String subcat);

    @Query(value = "Select * from product where category= :cat",nativeQuery = true)
    List<Product> findByCategoryName(@Param("cat") String cat);

    @Query(value = "select * from product where brand= :bran",nativeQuery = true)
    List<Product> findByBrandName(@Param("bran") String bran);

    @Modifying
    @Transactional
    @Query(value = "delete from product where id= :id",nativeQuery = true)
    int deleteById(@Param("id") int id);
}
