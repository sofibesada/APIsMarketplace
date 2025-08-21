package com.uade.tpo.Marketplace.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class OrderDetail {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private int quantity;
    @Column
    private float subtotal;
    
    @ManyToOne
    @JoinColumn (name = "id_order", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn (name = "id_product", nullable = false)
    private Product product;


}
