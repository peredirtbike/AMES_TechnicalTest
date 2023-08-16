package com.ames.provatecnica.controllers;

import com.ames.provatecnica.models.DesktopModel;
import com.ames.provatecnica.models.dtos.Create.DesktopCreationDTO;
import com.ames.provatecnica.services.DesktopService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/products/desktop")
public class DesktopController {
    @Autowired
    private DesktopService desktopService;

    //new desktop
    @Operation(summary = "createDesktop", description = "Crea un nou desktop a la base de dades passant els paràmetres necessaris")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Desktop creat", content = @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = DesktopModel.class))),
            @ApiResponse(responseCode = "500", description = "Error intern del servidor", content = @Content) })

    @PostMapping("/new")
    public ResponseEntity<DesktopModel> createDesktop(@RequestBody DesktopCreationDTO desktop) {
        try{
        desktop.setType("desktop");
        DesktopModel createdDesktop = desktopService.saveDesktop(desktop);
        return new ResponseEntity<>(createdDesktop, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //update desktop
    @Operation(summary = "updateDesktop", description = "Actualitza un desktop a la base de dades passant a la URL el id del desktop a actualitzar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Desktop actualitzat", content = @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = DesktopModel.class))),
            @ApiResponse(responseCode = "404", description = "Desktop no trobat", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error intern del servidor", content = @Content) })

    @PutMapping("{id}")
    public ResponseEntity<DesktopModel> updateDesktop(@PathVariable("id") Long id, @RequestBody DesktopModel updatedDesktop) {
        DesktopModel desktop = desktopService.updateDesktop(id, updatedDesktop);
        if (desktop != null) {
        return new ResponseEntity<>(desktop, HttpStatus.OK);
        } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    

    // Otros métodos y endpoints relacionados con los desktops
}