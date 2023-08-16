package com.ames.provatecnica.models.dtos.Create;

import java.sql.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.criteria.CriteriaBuilder.In;

public class DesktopCreationDTO {
    @Schema(description = "Descripción del producto", example = "Desktop")
    private String description;

    @Schema(description = "Indica si el producto está activo", example = "true")
    private Boolean isActive;

    @Schema(description = "Precio del producto", example = "1000.0")
    private double price;

    @Schema(description = "Fecha de entrada del producto", example = "2021-10-10")
    private Date entryDate;

    @Schema(description = "Tipo de producto", example = "Desktop")
    private String type;

    @Schema(description = "Potencia de la fuente de poder", example = "500")
    private Integer powerSupply;

    @Schema(description = "Indica si el equipo es para gaming", example = "true")
    private Boolean gaming;

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

    



}
