package com.zup.ecommerce.model;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Client client;
    @ManyToMany
    @JoinTable(
            name = "product_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dateHour;
    private Double totalValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Calendar getDateHour() {
        return dateHour;
    }

    public void setDateHour(Calendar dateHour) {
        this.dateHour = dateHour;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Order(Client client, List<Product> products, OrderStatus orderStatus, Calendar dateHour) {
        this.client = client;
        this.products = products;
        this.orderStatus = orderStatus;
        this.dateHour = dateHour;
    }
}
