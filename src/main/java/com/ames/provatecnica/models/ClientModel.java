package com.ames.provatecnica.models;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;


@Entity
@Table(name = "client")
public class ClientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID del cliente", example = "1", hidden = true)
    private long id;

    @Schema(description = "Nombre del cliente", example = "John", required = true)
    private String name;

    @Schema(description = "Apellido del cliente", example = "Doe", required = true)
    private String lastName;

    @Schema(description = "Número de teléfono del cliente", example = "123456789")
    private String phone;

    @Schema(description = "Correo electrónico del cliente", example = "john@example.com")
    private String email;

    @Schema(description = "Dirección del cliente", example = "123 Main St")
    private String address;

    @Schema(description = "Indica si el cliente es preferencial", example = "true")
    private Boolean isPreferential;

    @Schema(description = "Indica si el cliente tiene descuento", example = "true")
    private Boolean hasDiscount;
    
    @Schema(description = "Comercial asignado al cliente", hidden = true)
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "commercial_id")
    private CommercialModel commercial;

    // Constructor por defecto
       public ClientModel() {
    }

    // Constructor con parámetros
    public ClientModel(String name, String lastName, String phone, String email, String address,
                       Boolean isPreferential, Boolean hasDiscount) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.isPreferential = isPreferential;
        this.hasDiscount = hasDiscount;
    }

    // Constructor con la relación
    public ClientModel(String name, String lastName, String phone, String email, String address,
                       Boolean isPreferential, Boolean hasDiscount, CommercialModel commercial) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.isPreferential = isPreferential;
        this.hasDiscount = hasDiscount;
        this.commercial = commercial;
    }
    // getters y setters

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean isPreferential() {
        return isPreferential;
    }

    public void setPreferential(Boolean isPreferential) {
        this.isPreferential = isPreferential;
    }

    public Boolean isHasDiscount() {
        return hasDiscount;
    }

    public void setHasDiscount(Boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }

    public CommercialModel getCommercial() {
        return commercial;
    }

    public void setCommercial(CommercialModel commercial) {
        this.commercial = commercial;
    }


    
}
