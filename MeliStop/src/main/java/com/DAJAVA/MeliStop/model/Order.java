package com.DAJAVA.MeliStop.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    private Double totalPrice;
    private Boolean status;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;
}