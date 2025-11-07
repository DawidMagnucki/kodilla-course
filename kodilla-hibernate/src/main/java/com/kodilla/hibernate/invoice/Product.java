package com.kodilla.hibernate.invoice;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table (name = "PRODUCTS")
@Access(AccessType.PROPERTY)
public class Product {

    private int id;
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public Product() {}

    @Id
    @GeneratedValue
    @NotNull
    @Column (name = "PRODUCT_ID", unique = true)
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @NotNull
    @Column (name = "NAME")
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
