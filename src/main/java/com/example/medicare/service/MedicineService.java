package com.example.medicare.service;

import com.example.medicare.dto.MedicineDto;

import java.util.List;

public interface MedicineService {
    MedicineDto saveMedicine(MedicineDto medicineDto);
    void deleteMedicine(long id);
    MedicineDto updateMedicine(MedicineDto medicineDto);
    List<MedicineDto> getAllMedicines();
    List<MedicineDto> getMedicineByDiseaseName(String diseaseName);
    MedicineDto getMedicineByMedicineName(String medicineName);
}
