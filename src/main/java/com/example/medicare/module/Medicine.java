package com.example.medicare.module;

import javax.persistence.*;

@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicine_generator")
    @SequenceGenerator(name = "medicine_generator", sequenceName = "medicine_seq", allocationSize = 1000)
    private long medicineId;
    @Column(unique = true)
    private String medicineName;
    private String medicineDescription;
    private String medicineDisease;
    private Double medicinePrice;
    private Boolean status;
    private Double medicineDiscount;

    public Medicine() {
    }

    public Medicine(String medicineName, String medicineDescription, String medicineDisease, Double medicinePrice, Boolean status, Double medicineDiscount) {
        this.medicineName = medicineName;
        this.medicineDescription = medicineDescription;
        this.medicineDisease = medicineDisease;
        this.medicinePrice = medicinePrice;
        this.status = status;
        this.medicineDiscount = medicineDiscount;
    }

    public long getMedicineId() {
        return medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineDescription() {
        return medicineDescription;
    }

    public void setMedicineDescription(String medicineDescription) {
        this.medicineDescription = medicineDescription;
    }

    public String getMedicineDisease() {
        return medicineDisease;
    }

    public void setMedicineDisease(String medicineDisease) {
        this.medicineDisease = medicineDisease;
    }

    public Double getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(Double medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getMedicineDiscount() {
        return medicineDiscount;
    }

    public void setMedicineDiscount(Double medicineDiscount) {
        this.medicineDiscount = medicineDiscount;
    }
}
