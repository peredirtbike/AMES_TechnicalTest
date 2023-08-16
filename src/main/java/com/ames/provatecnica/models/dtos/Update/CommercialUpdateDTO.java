package com.ames.provatecnica.models.dtos.Update;
import io.swagger.v3.oas.annotations.media.Schema;

//fet per que no es puguin modificar ni les unitats venudes ni el total de ventes.


public class CommercialUpdateDTO {

    @Schema(description = "Nombre del comercial", example = "John", required = true)
    private String name;

    @Schema(description = "Apellido del comercial", example = "Doe", required = true)
    private String lastName;
    
    @Schema(description = "Número de teléfono del comercial", example = "123456789")
    private String phone;

    @Schema(description = "Correo electrónico del comercial", example = "johndoe@johndoe.com")
    private String email;

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

}
