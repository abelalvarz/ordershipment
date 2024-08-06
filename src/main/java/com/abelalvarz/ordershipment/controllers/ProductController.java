package com.abelalvarz.ordershipment.controllers;

import com.abelalvarz.ordershipment.converters.ResponseConverter;
import com.abelalvarz.ordershipment.dtos.response.Response;
import com.abelalvarz.ordershipment.enums.product.Category;
import com.abelalvarz.ordershipment.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/product")
public class ProductController {

    private final ResponseConverter responseConverter;
    private final ProductService productService;
    @GetMapping
    public ResponseEntity<Response> getAllProducts(){
        return ResponseEntity.ok(responseConverter.convert(productService.getAllProducts()));
    }

    @GetMapping("/category")
    public ResponseEntity<Response> getAllProductByCategory(@RequestParam("category")Category category){
        return ResponseEntity.ok(responseConverter.convert(productService.getAllByCategory(category)));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response> getProductById(@PathVariable("id") Long id){
        return ResponseEntity.ok(responseConverter.convert(productService.getProductById(id)));
    }
}
