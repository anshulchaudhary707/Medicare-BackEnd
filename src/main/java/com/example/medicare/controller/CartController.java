package com.example.medicare.controller;

import com.example.medicare.dto.MedicineDto;
import com.example.medicare.module.Cart;
import com.example.medicare.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class CartController {

    @Autowired private CartService cartService;
    @GetMapping("/addToCart/{medicineId}")
    public ResponseEntity<String> addToCart(@PathVariable(name = "medicineId") long medicineId){
        this.cartService.saveCart(medicineId);
        return new ResponseEntity<String>("Item has been added to cart successfully.",HttpStatus.OK);
    }

    @GetMapping("/getCartDetails")
    public ResponseEntity<List<MedicineDto>> getCartDetails(){
        List<MedicineDto> list = this.cartService.getCartDetails();
        return new ResponseEntity<List<MedicineDto>>(list, HttpStatus.OK);
    }

    @GetMapping("/checkOut")
    public ResponseEntity<List<MedicineDto>> checkOut(){
        return new ResponseEntity<List<MedicineDto>>(this.cartService.checkOut(),HttpStatus.OK);
    }

    @GetMapping("/emptyCart")
    public ResponseEntity<List<MedicineDto>> emptyCart(){
        List<MedicineDto> list = this.cartService.emptyCart();
        return new ResponseEntity<List<MedicineDto>>(list,HttpStatus.OK);
    }
    @GetMapping("/decrease/{medicineName}")
    public void decreaseQuantity(@PathVariable(name = "medicineName") String medicineName){
        this.cartService.decreaseQuantity(medicineName);
    }
    @GetMapping("/increase/{medicineName}")
    public void increaseQuantity(@PathVariable(name = "medicineName") String medicineName){
        this.cartService.increaseQuantity(medicineName);
    }
    @GetMapping("/deleteItem/{medicineName}")
    public void deleteItem(@PathVariable(name = "medicineName") String medicineName){
        this.cartService.deleteItem(medicineName);
    }
}
