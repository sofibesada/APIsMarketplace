package com.uade.tpo.Marketplace.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data

@Entity
public class Payment {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime fechapago;

    @Column
    private double count;

    @OneToOne
    @JoinColumn(name = "id_order", nullable= false)
    private Order order;

    @OneToOne
    @JoinColumn(name = "id_payment_method", nullable = false)
    private PaymentMethod paymentMethod;
    
}
