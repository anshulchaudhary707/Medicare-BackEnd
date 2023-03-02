package com.example.medicare.module;

import javax.persistence.*;

@Entity
public class Cart {

   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_generator")
   @SequenceGenerator(name = "cart_generator", sequenceName = "cart_seq", allocationSize = 1000)
   private long id;

   private int quantity;

   private String medicineName;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Cart() { }

    public Cart(String medicineName, User user) {
        this.medicineName = medicineName;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicine(String medicineName) {
        this.medicineName = medicineName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
