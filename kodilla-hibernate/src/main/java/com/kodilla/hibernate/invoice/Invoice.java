package com.kodilla.hibernate.invoice;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "INVOICES")
@Access(AccessType.PROPERTY)
public class Invoice {

    private int id;
    private String number;
    private List<Item> items = new ArrayList<>();

    public Invoice(String number) {
        this.number = number;
    }

    public Invoice(){}

    @Id
    @GeneratedValue
    @NotNull
    @Column (name = "INVOICE_ID")
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @NotNull
    @Column (name = "NUMBER")
    public String getNumber() {
        return number;
    }

    private void setNumber(String number) {
        this.number = number;
    }

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "invoice"
    )
    public List<Item> getItems() {
        return items;
    }

    private void setItems(List<Item> items) {
        this.items = items;
    }
}
