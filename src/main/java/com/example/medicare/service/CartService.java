package com.example.medicare.service;

import com.example.medicare.dto.MedicineDto;
import com.example.medicare.module.Cart;
import com.example.medicare.module.User;

import java.util.List;

public interface CartService {
    Cart saveCart(long medicineId);
    List<MedicineDto> getCartDetails();
    List<MedicineDto> checkOut();
    List<MedicineDto> emptyCart();
    void decreaseQuantity(String medicineName);
    void increaseQuantity(String medicineName);
    void deleteItem(String medicineName);
}
