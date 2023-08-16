package com.ames.provatecnica.models.dtos.Create;
import io.swagger.v3.oas.annotations.media.Schema;

public class ClientCreationDTO {

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

    @Schema(description = "Indica si el cliente tiene descuento", example = "true")
    private boolean hasDiscount;

    @Schema(description = "Indica si el cliente es preferencial", example = "true")
    private boolean isPreferential;

    // Getters y setters (puedes usar Lombok para evitar escribirlos manualmente)
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
    public boolean isHasDiscount() {
        return hasDiscount;
    }
    public void setHasDiscount(boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }
    public boolean isPreferential() {
        return isPreferential;
    }
    public void setPreferential(boolean isPreferential) {
        this.isPreferential = isPreferential;
    }

    // Getters y setters (puedes usar Lombok para evitar escribirlos manualmente)

    
}
