package com.ames.provatecnica.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ames.provatecnica.models.ProductModel;
import com.ames.provatecnica.services.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:5173")

@RequestMapping("/products")

public class ProductController {

    @Autowired
    private ProductService productService;


    //get all products
    @Operation(summary = "getAllProducts", description = "Obté tots els productes d'un tipus de la base de dades buscant el tipus per paràmetre (només pot ser 'laptop' o 'desktop')")

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Productes trobats", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProductModel.class)))),
        @ApiResponse(responseCode = "204", description = "No s'han trobat productes", content = @Content),
        //falta implementar classe d'error
        @ApiResponse(responseCode = "500", description = "Error intern del servidor", content = @Content) })    
    @GetMapping("{type}")
    public ResponseEntity<List<ProductModel>> getProductsByType(@PathVariable String type) {
        try{
        List<ProductModel> products = productService.getProductsByType(type);
        if (products.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //get all products by commercial id
    @Operation(summary = "getAllProductsforAComme", description = "Obté tots els productes d'un comercial de la base de dades buscant el id del comercial per paràmetre")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Productes trobats", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProductModel.class)))),
        @ApiResponse(responseCode = "204", description = "No s'han trobat productes", content = @Content),
        //falta implementar classe d'error
        @ApiResponse(responseCode = "500", description = "Error intern del servidor", content = @Content) })

    @GetMapping(path = "getAllProductsforAComme/{commercialId}")
    public ResponseEntity<List<ProductModel>> getProductsByCommercialId(@PathVariable Long commercialId) {
        try{
            List<ProductModel> products = productService.getProductsByCommercialId(commercialId);
            if (products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

        

}
