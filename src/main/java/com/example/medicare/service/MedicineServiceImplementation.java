package com.example.medicare.service;

import com.example.medicare.dto.MedicineDto;
import com.example.medicare.module.Medicine;
import com.example.medicare.repository.MedicineRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicineServiceImplementation implements MedicineService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public MedicineDto saveMedicine(MedicineDto medicineDto) {
        Medicine medicine = this.modelMapper.map(medicineDto, Medicine.class);
        Medicine medicine1 = this.medicineRepository.save(medicine);
        MedicineDto medicineDto1 = this.modelMapper.map(medicine1, MedicineDto.class);
        return medicineDto1;
    }

    @Override
    public void deleteMedicine(long id) {
        Medicine medicine = this.medicineRepository.searchMedicineByMedicineId(id);
        this.medicineRepository.delete(medicine);
    }

    @Override
    public MedicineDto updateMedicine(MedicineDto medicineDto) {
        Medicine medicine = this.medicineRepository.searchMedicineByMedicineId(medicineDto.getMedicineId());
        System.out.println("Medicine id: " + medicine.getMedicineId());
        System.out.println("Medicine name: " + medicine.getMedicineName());
        medicine.setMedicineDescription(medicineDto.getMedicineDescription());
        medicine.setMedicineName(medicineDto.getMedicineName());
        medicine.setMedicineDisease(medicineDto.getMedicineDisease());
        medicine.setMedicinePrice(medicineDto.getMedicinePrice());
        this.medicineRepository.save(medicine);
        MedicineDto medicineDto1 = this.modelMapper.map(medicine, MedicineDto.class);
        return medicineDto1;
    }

    @Override
    public List<MedicineDto> getAllMedicines() {
        Iterable<Medicine> iterable = this.medicineRepository.findAll();
        List<MedicineDto> list = new ArrayList<MedicineDto>();
        for(Medicine item : iterable){
            MedicineDto medicineDto = this.modelMapper.map(item, MedicineDto.class);
            list.add(medicineDto);
        }
        return list;
    }

    @Override
    public List<MedicineDto> getMedicineByDiseaseName(String diseaseName) {
        List<Medicine> list = this.medicineRepository.searchMedicineByMedicineDisease(diseaseName);
        List<MedicineDto> list1 = new ArrayList<MedicineDto>();
        for(Medicine item: list){
            MedicineDto medicineDto = this.modelMapper.map(item, MedicineDto.class);
            list1.add(medicineDto);
        }
        return list1;
    }

    @Override
    public MedicineDto getMedicineByMedicineName(String medicineName) {
        Medicine medicine = this.medicineRepository.searchMedicineByMedicineName(medicineName);
        MedicineDto medicineDto = this.modelMapper.map(medicine,MedicineDto.class);
        return medicineDto;
    }
}
