package com.uade.tpo.Marketplace.entity;

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
@Table(name= "orders") //forma de cambiar el nombre de la tabla (ya que order tabla reservada de mysql)
public class Order {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long count;

    @ManyToOne //join entre las dos--> esta orden q es de 1 unico usuario se relaciona con esta orden
    @JoinColumn(name = "user_id", nullable = false) //si o si tiene q haber user_id sino ordern no se persiste (para eso nullable q es un booleano) 
    private User user;

}
