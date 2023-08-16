package com.ames.provatecnica.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.ames.provatecnica.models.ClientModel;
import com.ames.provatecnica.models.CommercialModel;
import com.ames.provatecnica.models.dtos.Create.CommercialCreationDTO;
import com.ames.provatecnica.models.dtos.Update.CommercialUpdateDTO;
import com.ames.provatecnica.services.CommercialService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/comercials")

public class CommercialController {

    @Autowired
    private CommercialService commercialService;

    //crear comercial **DONE**
    @Operation(summary = "saveCommercial", description = "Crea un nou comercial a la base de dades passant els paràmetres necessaris")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Comercial creat", content = @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = CommercialModel.class))),
            @ApiResponse(responseCode = "500", description = "Error intern del servidor", content = @Content) })

    @PostMapping(path = "/newComercial")
    public ResponseEntity<CommercialModel> saveCommercial(@RequestBody CommercialCreationDTO commercialDTO) {
        try{
            CommercialModel savedCommercial = commercialService.saveCommercial(commercialDTO);
            return new ResponseEntity<>(savedCommercial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //actualitzar comercial **DONE**
    @Operation(summary = "updateCommercialById", description = "Actualitza un comercial a la base de dades passant a la URL el id del comercial a actualitzar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Comercial actualitzat", content = @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = CommercialModel.class))),
            @ApiResponse(responseCode = "404", description = "Comercial no trobat", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error intern del servidor", content = @Content) })

    @PutMapping(path = "/updateCommercial/{id}")
    public ResponseEntity<CommercialModel> updateCommercialById(@RequestBody CommercialUpdateDTO commercialUpdateDTO, @PathVariable("id") Long id) {
        CommercialModel updatedCommercial = commercialService.updateCommercialById(commercialUpdateDTO, id);
        if (updatedCommercial != null) {
            return new ResponseEntity<>(updatedCommercial, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //assignar client a comercial
    @Operation(summary = "updateCommercialClient", description = "Assigna un comercial a un client passant a la URL el id del comercial i el id del client a assignar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client assignat a comercial", content = @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ClientModel.class))),
            @ApiResponse(responseCode = "404", description = "Comercial no trobat", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error intern del servidor", content = @Content) })

    @PutMapping("newComercialClient/{id_comercial}/{id_client}")
    public ResponseEntity<String> updateCommercialClient(
            @PathVariable("id_comercial") Long commercialId,
            @PathVariable("id_client") Long clientId
    ) {
        ClientModel updatedClient = commercialService.addClientToCommercial(commercialId, clientId);
        if (updatedClient != null) {
            return ResponseEntity.ok("Client added to commercial");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Commercial not found");
        }
    }


}
    
