package com.ames.provatecnica.models;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;


@Entity
@Table(name = "commercial")
public class CommercialModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID del comercial", example = "1", hidden = true)
    private long id;

    @Schema(description = "Nombre del comercial", example = "John", required = true)
    private String name;

    @Schema(description = "Apellido del comercial", example = "Doe", required = true)
    private String lastName;

    @Schema(description = "Número de teléfono del comercial", example = "123456789")
    private String phone;

    @Schema(description = "Correo electrónico del comercial", example = "jdoe@ames.com", required = true)
    private String email;

    @Schema(description = "Unidades vendidas por el comercial", example = "10")
    private int unitsSold;

    @Schema(description = "Ventas totales del comercial", example = "1000.0")
    private double totalSales;

    @JsonIgnore
    @OneToMany(mappedBy = "commercial")
    private List<ClientModel> clients;

    @JsonIgnore
    @OneToMany(mappedBy = "commercial")
    private List<ProductModel> products;


    // Constructor por defecto
    public CommercialModel() {
    }

    // Constructor con parámetros
    public CommercialModel(String name, String lastName, String phone, String email, int unitsSold, double totalSales) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.unitsSold = unitsSold;
        this.totalSales = totalSales;
    }

    //constructor con la relación

    public CommercialModel(String name, String lastName, String phone, String email, int unitsSold, double totalSales,
                           List<ClientModel> clients, List<ProductModel> products) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.unitsSold = unitsSold;
        this.totalSales = totalSales;
        this.clients = clients;
        this.products = products;
    }

    
    // Getters y setters
    
    public long getId() {
            return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(int unitsSold) {
        this.unitsSold = unitsSold;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public List<ClientModel> getClients() {
        return clients;
    }

    public void setClients(List<ClientModel> clients) {
        this.clients = clients;
    }

    public List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(List<ProductModel> products) {
        this.products = products;
    }
}