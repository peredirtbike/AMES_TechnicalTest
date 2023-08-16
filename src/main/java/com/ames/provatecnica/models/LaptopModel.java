package com.ames.provatecnica.models;

import jakarta.persistence.*;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity(name = "laptop")
@PrimaryKeyJoinColumn(name = "product_code")
public class LaptopModel extends ProductModel {
    
    @Schema(description = "Capacidad de la batería", example = "5000")
    private Integer batteryCapacity;

    @Schema(description = "Amperaje del cargador", example = "500")
    private Integer chargerAmperage;

    @Override
    public void updateAttributes(ProductModel request) {
        if (request instanceof LaptopModel) {
            LaptopModel laptopRequest = (LaptopModel) request;
            this.batteryCapacity = laptopRequest.getBatteryCapacity();
            this.chargerAmperage = laptopRequest.getChargerAmperage();
        }
    }

    //constructor 
    public LaptopModel() {
    }

    public LaptopModel(String description, Boolean isActive, double price, Date entryDate, String type, Integer batteryCapacity, Integer chargerAmperage) {
        super(description, isActive, price, entryDate, type);
        this.batteryCapacity = batteryCapacity;
        this.chargerAmperage = chargerAmperage;
    }

    public LaptopModel(Integer batteryCapacity, Integer chargerAmperage) {
        this.batteryCapacity = batteryCapacity;
        this.chargerAmperage = chargerAmperage;
    }

    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public Integer getChargerAmperage() {
        return chargerAmperage;
    }

    public void setChargerAmperage(Integer chargerAmperage) {
        this.chargerAmperage = chargerAmperage;
    }
   
}
