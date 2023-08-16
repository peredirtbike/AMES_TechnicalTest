package com.ames.provatecnica.models.dtos.Create;

import java.sql.Date;

import io.swagger.v3.oas.annotations.media.Schema;

public class LaptopCreationDTO {
     @Schema(description = "Descripción del producto", example = "Laptop")
    private String description;

    @Schema(description = "Indica si el producto está activo", example = "true")
    private Boolean isActive;

    @Schema(description = "Precio del producto", example = "10200.0")
    private double price;

    @Schema(description = "Fecha de entrada del producto", example = "2021-10-10")
    private Date entryDate;

    @Schema(description = "Tipo de producto", example = "Desktop")
    private String type;

    @Schema(description = "Capacidad de la batería", example = "5000")
    private Integer batteryCapacity;

    @Schema(description = "Amperaje del cargador", example = "500")
    private Integer chargerAmperage;



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
