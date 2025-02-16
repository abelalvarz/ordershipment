package com.abelalvarz.ordershipment.repositories;

import com.abelalvarz.ordershipment.entities.Product;
import com.abelalvarz.ordershipment.enums.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(Category category);
}
