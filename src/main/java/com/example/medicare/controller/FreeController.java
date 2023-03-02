package com.example.medicare.controller;

import com.example.medicare.dto.MedicineDto;
import com.example.medicare.dto.UserDto;
import com.example.medicare.service.MedicineService;
import com.example.medicare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/free")
public class FreeController {

    @Autowired private UserService userService;
    @Autowired private MedicineService medicineService;
    @PostMapping("/addUser")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        UserDto userDto1 = this.userService.saveUser(userDto);
        return new ResponseEntity<UserDto>(userDto1, HttpStatus.OK);
    }
    @GetMapping("/search/name/{name}")
    public ResponseEntity<MedicineDto> searchMedicineByName(@PathVariable("name") String name){
        MedicineDto medicineDto =  this.medicineService.getMedicineByMedicineName(name);
        return new ResponseEntity<MedicineDto>(medicineDto,HttpStatus.OK);
    }

    @GetMapping("/search/disease/{name}")
    public ResponseEntity<List<MedicineDto>> searchMedicineByDisease(@PathVariable("disease") String disease){
        List<MedicineDto> list = this.medicineService.getMedicineByDiseaseName(disease);
        return new ResponseEntity<List<MedicineDto>>(list,HttpStatus.OK);
    }
}
