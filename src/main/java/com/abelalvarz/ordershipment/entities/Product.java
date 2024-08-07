package com.abelalvarz.ordershipment.entities;

import com.abelalvarz.ordershipment.enums.product.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String sku;

    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private Category category;
}
