package com.abelalvarz.ordershipment.services.impl;

import com.abelalvarz.ordershipment.entities.Product;
import com.abelalvarz.ordershipment.enums.product.Category;
import com.abelalvarz.ordershipment.exceptions.ResourceNotFoundException;
import com.abelalvarz.ordershipment.repositories.ProductRepository;
import com.abelalvarz.ordershipment.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getAllByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Product was not found with id"+id));
    }
}
