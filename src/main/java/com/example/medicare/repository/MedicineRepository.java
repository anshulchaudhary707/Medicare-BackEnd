package com.example.medicare.repository;

import com.example.medicare.module.Medicine;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedicineRepository extends CrudRepository<Medicine,Long> {
    Medicine searchMedicineByMedicineId(long medicineId);
    Medicine searchMedicineByMedicineName(String medicineName);
    List<Medicine> searchMedicineByMedicineDisease(String medicineDisease);
}
