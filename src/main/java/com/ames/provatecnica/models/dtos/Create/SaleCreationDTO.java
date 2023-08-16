package com.ames.provatecnica.models.dtos.Create;
import java.sql.Date;

import io.swagger.v3.oas.annotations.media.Schema;

public class SaleCreationDTO {

    @Schema(description = "Id del cliente", example = "1", required = true)
    private Long clientId;

    @Schema(description = "Id del comercial", example = "1", required = true)
    private Long commercialId;

    @Schema(description = "Id del producto", example = "1", required = true)
    private Long productId;

    @Schema(description = "Fecha de la venta", example = "2021-10-10", required = true)
    private Date saleDate;

    @Schema(description = "Cantidad de productos vendidos", example = "10", required = true)
    private int quantity;
    

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getCommercialId() {
        return commercialId;
    }

    public void setCommercialId(Long commercialId) {
        this.commercialId = commercialId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    


    
}
