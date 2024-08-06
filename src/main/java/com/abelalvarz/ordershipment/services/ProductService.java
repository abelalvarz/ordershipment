package com.abelalvarz.ordershipment.services;

import com.abelalvarz.ordershipment.entities.Product;
import com.abelalvarz.ordershipment.enums.product.Category;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    List<Product> getAllByCategory(Category category);
    Product getProductById(Long id);
}
