package com.msdev.order_controller_api.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id")
    private UUID id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_description")
    private String description;
    @Column(name = "product_active")
    private boolean enable;
    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "product_category",referencedColumnName = "category_id")
    private Category category;
}
