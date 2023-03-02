package com.example.medicare.service;

import com.example.medicare.dto.MedicineDto;
import com.example.medicare.module.Cart;
import com.example.medicare.module.Medicine;
import com.example.medicare.module.User;
import com.example.medicare.repository.CartRepository;
import com.example.medicare.repository.MedicineRepository;
import com.example.medicare.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class CartServiceImplementation implements CartService {

    @Autowired private CartRepository cartRepository;

    @Autowired private MedicineRepository medicineRepository;

    @Autowired private UserRepository userRepository;
    @Autowired private ModelMapper modelMapper;

    @Override
    public Cart saveCart(long medicineId) {
        Medicine medicine = this.medicineRepository.searchMedicineByMedicineId(medicineId);
        if(medicine != null){
            User user = this.userRepository.searchUserByEmail("anshul@gmail.com");
            if(user == null){
                return null;
            }
            List<Cart> list = this.cartRepository.findByUser(user);
            for(Cart item: list){
                if(item.getMedicineName().equals(medicine.getMedicineName())){
                    item.setQuantity(item.getQuantity()+1);
                    return this.cartRepository.save(item);
                }
            }

            Cart cart = new Cart();
            cart.setMedicine(medicine.getMedicineName());
            cart.setUser(user);
            cart.setQuantity(cart.getQuantity()+1);
            return this.cartRepository.save(cart);
        }
        return null;
    }

    @Override
    public List<MedicineDto> getCartDetails() {
        User user = this.userRepository.searchUserByEmail("anshul@gmail.com");
        List<Cart> list = this.cartRepository.findByUser(user);
        List<MedicineDto> list1 = new ArrayList<MedicineDto>();
        for(Cart item : list){
            Medicine medicine = this.medicineRepository.searchMedicineByMedicineName(item.getMedicineName());
            if(medicine == null){
                this.cartRepository.delete(item);
            }
            else{
                MedicineDto medicineDto = this.modelMapper.map(medicine,MedicineDto.class);
                list1.add(medicineDto);
            }
        }
        return list1;
    }

    @Override
    public List<MedicineDto> checkOut() {
        List<MedicineDto> list = this.getCartDetails();
        this.emptyCart();
        return list;
    }

    @Override
    public List<MedicineDto> emptyCart() {
        User user = this.userRepository.searchUserByEmail("anshul@gmail.com");
        List<Cart> list = this.cartRepository.findByUser(user);
        for(Cart item: list){
            this.cartRepository.delete(item);
        }
        return this.getCartDetails();
    }

    @Override
    public void decreaseQuantity(String medicineName) {
        User user = this.userRepository.searchUserByEmail("anshul@gmail.com");
        List<Cart> list = this.cartRepository.findByUser(user);
        for(Cart item: list){
            if(item.getMedicineName().equals(medicineName)){
                item.setQuantity(item.getQuantity()-1);
                this.cartRepository.save(item);
                return;
            }
        }
    }

    @Override
    public void increaseQuantity(String medicineName) {
        User user = this.userRepository.searchUserByEmail("anshul@gmail.com");
        List<Cart> list = this.cartRepository.findByUser(user);
        for(Cart item: list){
            if(item.getMedicineName().equals(medicineName)){
                item.setQuantity(item.getQuantity()+1);
                this.cartRepository.save(item);
                return;
            }
        }
    }

    @Override
    public void deleteItem(String medicineName) {
        User user = this.userRepository.searchUserByEmail("anshul@gmail.com");
        List<Cart> list = this.cartRepository.findByUser(user);
        for(Cart item: list){
            if(item.getMedicineName().equals(medicineName)){
                item.setUser(null);
                this.cartRepository.delete(item);
                return;
            }
        }
    }

}
