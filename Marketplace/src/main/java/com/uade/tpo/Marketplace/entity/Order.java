package com.uade.tpo.Marketplace.entity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
 //forma de cambiar el nombre de la tabla (ya que order tabla reservada de mysql)
public class Order {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column 
    private LocalDateTime date;
    @Column
    private Long total;
    @Column 
    private String state;

    @ManyToOne //join entre las dos--> esta orden q es de 1 unico usuario se relaciona con esta orden
    @JoinColumn(name = "id_user", nullable = false) //si o si tiene q haber user_id sino ordern no se persiste (para eso nullable q es un booleano) 
    private User user;

    @OneToOne(mappedBy = "payment")
    private Payment payment;

    @OneToMany(mappedBy = "orderDetail")
    private List<OrderDetail> orderDetail;


}
