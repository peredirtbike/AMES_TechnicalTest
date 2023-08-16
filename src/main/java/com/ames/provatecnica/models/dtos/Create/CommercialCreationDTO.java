package com.ames.provatecnica.models.dtos.Create;
import io.swagger.v3.oas.annotations.media.Schema;


public class CommercialCreationDTO {

    @Schema(description = "Nombre del comercial", example = "John", required = true)
    private String name;

    @Schema(description = "Apellido del comercial", example = "Doe", required = true)
    private String lastName;
    
    @Schema(description = "Número de teléfono del comercial", example = "123456789")
    private String phone;

    @Schema(description = "Correo electrónico del comercial", example = "johndoe@johndoe.com")
    private String email;

    @Schema(description = "Unidades vendidas", example = "1")
    private int unitsSold = 0;

    @Schema(description = "Ventas totales", example = "1000.0")
    private double totalSales = 0.0;

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

}
