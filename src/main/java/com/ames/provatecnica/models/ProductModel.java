package com.ames.provatecnica.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Código del producto", example = "1", hidden = true)
    private Long productCode;

    @Schema(description = "Descripción del producto", example = "Laptop")
    private String description;

    @Schema(description = "Indica si el producto está activo", example = "true")
    private Boolean isActive;

    @Schema(description = "Precio del producto", example = "1000.0")
    private double price;

    @Schema(description = "Fecha de entrada del producto", example = "2021-10-10")
    private Date entryDate;

    @Schema(description = "Tipo de producto", example = "Laptop")
    private String type;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "commercial_id")
    private CommercialModel commercial;

    // Polimorfismo
    public abstract void updateAttributes(ProductModel request);

    // Constructor
    public ProductModel() {
    }

    public ProductModel(String description, Boolean isActive, double price, Date entryDate, String type) {
        super();
        this.description = description;
        this.isActive = isActive;
        this.price = price;
        this.entryDate = entryDate;
        this.type = type;
    }

    // Getters y setters
    public Long getProductCode() {
        return productCode;
    }

    public void setProductCode(Long productCode) {
        this.productCode = productCode;
    }

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

    public CommercialModel getCommercial() {
        return commercial;
    }

    public void setCommercial(CommercialModel commercial) {
        this.commercial = commercial;
    }
}