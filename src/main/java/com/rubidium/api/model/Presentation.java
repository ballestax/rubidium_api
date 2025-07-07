package com.rubidium.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "presentations")
public class Presentation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "serie")
    private int serie;

    @Column(name = "price")
    private double price;

    @Column(name = "isdefault")
    private boolean _default;

    @Column(name = "isenabled")
    private boolean _enabled;

    @ManyToOne
    @JoinColumn(name ="product_id")
    @JsonBackReference
    private Product product;
}
