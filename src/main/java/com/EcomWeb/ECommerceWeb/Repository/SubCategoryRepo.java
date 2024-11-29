package com.EcomWeb.ECommerceWeb.Repository;

import com.EcomWeb.ECommerceWeb.Entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepo extends JpaRepository<SubCategory,String> {
}
