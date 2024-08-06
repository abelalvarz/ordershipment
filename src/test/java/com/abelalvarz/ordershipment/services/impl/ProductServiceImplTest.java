package com.abelalvarz.ordershipment.services.impl;

import com.abelalvarz.ordershipment.entities.Product;
import com.abelalvarz.ordershipment.enums.product.Category;
import com.abelalvarz.ordershipment.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void getAllProducts() {
        List<Product> productList = getProductList();
        Mockito.when(productRepository.findAll()).thenReturn(productList);

        List<Product> result = productService.getAllProducts();
        assertEquals(2,result.size());
        assertEquals("HP Model", result.get(0).getName());
        assertEquals("ERICSSON Model", result.get(1).getName());

    }

    @Test
    void getAllByCategory() {
        List<Product> productList = getProductList();
        Mockito.when(productRepository.findByCategory(Category.COMPUTING)).thenReturn(productList);

        List<Product> result = productService.getAllByCategory(Category.COMPUTING);
        assertEquals(2,result.size());
        assertEquals("HP Model",result.get(0).getName());
        assertEquals("ERICSSON Model",result.get(1).getName());
    }

    @Test
    void getProductById() {

        Product product = new Product(1L,"SKU","Computer","Product test", Category.COMPUTING);
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Product result = productService.getProductById(1L);
        assertEquals("Computer", result.getName());
    }

    private List<Product> getProductList(){
        List<Product> productList = new ArrayList<>();
        productList.add(Product.builder()
                .category(Category.COMPUTING)
                .name("HP Model")
                .sku("hp-model-sku")
                .description("Hp computer")
                .id(1L)
                .build());
        productList.add(Product.builder()
                .category(Category.COMPUTING)
                .name("ERICSSON Model")
                .sku("ericsson-model-sku")
                .description("Ericsson computer")
                .id(2L)
                .build());
        return productList;
    }
}