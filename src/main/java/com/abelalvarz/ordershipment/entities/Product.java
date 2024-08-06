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
@Table(name = "TC_PRODUCT")
public class Product {

    @Id
    private Long id;

    @Column(name = "SKU")
    private String sku;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CATEGORY")
    @Enumerated(EnumType.STRING)
    private Category category;
}
