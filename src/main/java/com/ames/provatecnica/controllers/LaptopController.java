package com.ames.provatecnica.controllers;

import com.ames.provatecnica.models.LaptopModel;
import com.ames.provatecnica.models.dtos.Create.LaptopCreationDTO;
import com.ames.provatecnica.services.LaptopService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/products/laptop")
public class LaptopController {
    @Autowired
    private LaptopService laptopService;

    //new Laptop
    @Operation(summary = "createLaptop", description = "Crea un nou laptop a la base de dades passant els paràmetres necessaris")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Laptop creat", content = @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = LaptopModel.class))),
            @ApiResponse(responseCode = "500", description = "Error intern del servidor", content = @Content) })

    @PostMapping("/new")
    public ResponseEntity<LaptopModel> createLaptop(@RequestBody LaptopCreationDTO laptopDTO) {
        try{
        laptopDTO.setType("laptop");
        LaptopModel createdLaptop = laptopService.saveLaptop(laptopDTO);
        return new ResponseEntity<>(createdLaptop, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update Laptop
    @Operation(summary = "updateLaptop", description = "Actualitza un laptop a la base de dades passant a la URL el id del laptop a actualitzar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Laptop actualitzat", content = @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = LaptopModel.class))),
            @ApiResponse(responseCode = "404", description = "Laptop no trobat", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error intern del servidor", content = @Content) })

    @PutMapping("{id}")
    public ResponseEntity<LaptopModel> updateLaptop(@PathVariable("id") Long id, @RequestBody LaptopModel updatedLaptop) {
        LaptopModel laptop = laptopService.updateLaptop(id, updatedLaptop);
        if (laptop != null) {
            return new ResponseEntity<>(laptop, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}