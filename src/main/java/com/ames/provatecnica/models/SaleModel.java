package com.ames.provatecnica.models;

import jakarta.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "sale")
public class SaleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID de la venta", example = "1", hidden = true)
    private long id;

    @Schema(description = "Fecha de la venta", example = "2021-10-10")
    private Date saleDate;

    @Schema(description = "Cantidad de productos vendidos", example = "10")
    private int quantity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientModel client;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductModel product;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "commercial_id")
    private CommercialModel commercial;

    // Constructor, getters y setters
    public SaleModel() {
    }

    public SaleModel(Date saleDate, int quantity) {
        this.saleDate = saleDate;
        this.quantity = quantity;
    }

    //getters y setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public CommercialModel getCommercial() {
        return commercial;
    }

    public void setCommercial(CommercialModel commercial) {
        this.commercial = commercial;
    }
        
    // Resto de código de la clase

    
}