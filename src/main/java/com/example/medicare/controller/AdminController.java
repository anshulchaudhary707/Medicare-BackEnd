package com.example.medicare.controller;

import com.example.medicare.dto.MedicineDto;
import com.example.medicare.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired private MedicineService medicineService;

    @PostMapping("/addMedicine")
    public ResponseEntity<MedicineDto> addMedicine(@RequestBody MedicineDto medicineDto){
        MedicineDto medicineDto1 = this.medicineService.saveMedicine(medicineDto);
        return new ResponseEntity<MedicineDto>(medicineDto1, HttpStatus.OK);
    }

    @PostMapping("/updateMedicine")
    public ResponseEntity<MedicineDto> updateMedicine(@RequestBody MedicineDto medicineDto){
        MedicineDto medicineDto1 = this.medicineService.updateMedicine(medicineDto);
        return new ResponseEntity<MedicineDto>(medicineDto1, HttpStatus.OK);
    }

    @GetMapping("/deleteMedicine/{medicineId}")
    public ResponseEntity<String> deleteMedicine(@PathVariable("medicineId") long medicineId){
        this.medicineService.deleteMedicine(medicineId);
        return new ResponseEntity<String>("Medicine Deleted Successfully.",HttpStatus.OK);
    }
}
