package com.ames.provatecnica.models;

import jakarta.persistence.*;
import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity(name = "desktop")
@PrimaryKeyJoinColumn(name = "product_code")
public class DesktopModel extends ProductModel {
    
    @Schema(description = "Potencia de la fuente de poder", example = "500")
    private Integer powerSupply;

    @Schema(description = "Indica si el equipo es para gaming", example = "true")
    private Boolean gaming;

    //polimorfismo

    @Override
    public void updateAttributes(ProductModel request) {
        if (request instanceof DesktopModel) {
            DesktopModel desktopRequest = (DesktopModel) request;
            this.powerSupply = desktopRequest.getPowerSupply();
            this.gaming = desktopRequest.getGaming();
        }
    }

    //constructor

    public DesktopModel() {
    }

    public DesktopModel(String description, Boolean isActive, double price, Date entryDate, String type, Integer powerSupply, Boolean gaming) {
        super(description, isActive, price, entryDate, type);
        this.powerSupply = powerSupply;
        this.gaming = gaming;
    }

    public DesktopModel(Integer powerSupply, Boolean gaming) {
        this.powerSupply = powerSupply;
        this.gaming = gaming;
    }

    //getters and setters

    public Integer getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(Integer powerSupply) {
        this.powerSupply = powerSupply;
    }

    public Boolean getGaming() {
        return gaming;
    }

    public void setGaming(Boolean gaming) {
        this.gaming = gaming;
    }

    //getters and setters

    
}
