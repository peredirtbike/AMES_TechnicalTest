package com.ames.provatecnica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ames.provatecnica.services.SaleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.RestController;

import com.ames.provatecnica.models.ProductModel;
import com.ames.provatecnica.models.SaleModel;
import com.ames.provatecnica.models.dtos.Create.SaleCreationDTO;

import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @Operation(summary = "getSalesByCommercialId", description = "Obté totes les vendes de la base de dades per id del comercial passant l'id del comercial per paràmetre")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ventes trobades", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProductModel.class)))),
        @ApiResponse(responseCode = "204", description = "No s'han trobat ventes", content = @Content),
        //falta implementar classe d'error
        @ApiResponse(responseCode = "500", description = "Error intern del servidor", content = @Content) })
    
        @GetMapping(path = "getAllSalesforAComme/{commercialId}")
        public ResponseEntity<List<SaleModel>> getSalesByCommercialId(@PathVariable Long commercialId) {
            try {
                List<SaleModel> sales = saleService.getSalesByCommercialId(commercialId);
                if (sales == null || sales.isEmpty()) {
                    return ResponseEntity.notFound().build();
                } else {
                    return ResponseEntity.ok(sales);
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
    
    @Operation(summary = "registerSale", description = "Crea una nova venta passant els paràmetres necessaris")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Venda creada", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProductModel.class)))),
        @ApiResponse(responseCode = "500", description = "Error intern del servidor", content = @Content) })

    @PostMapping("/registerSale")
    public ResponseEntity<SaleModel> registerSale(@RequestBody SaleCreationDTO sale) {
        try{
            SaleModel createdSale = saleService.registerSale(sale);
            return new ResponseEntity<>(createdSale, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   

}
