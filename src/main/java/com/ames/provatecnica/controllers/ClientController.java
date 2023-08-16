package com.ames.provatecnica.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ames.provatecnica.services.ClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import com.ames.provatecnica.models.ClientModel;
import com.ames.provatecnica.models.dtos.Create.ClientCreationDTO;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.CrossOrigin;



@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/clients")

public class ClientController {

    @Autowired
    private ClientService clientService;


    //get all clients **DONE**
    @Operation(summary = "getAllClients", description = "Obté tots els clients de la base de dades")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Clients trobats", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClientModel.class)))),
            @ApiResponse(responseCode = "204", description = "No s'han trobat clients", content = @Content),
            //falta implementar classe d'error
            @ApiResponse(responseCode = "500", description = "Error intern del servidor", content = @Content) })

    @GetMapping(path = "/getAllClients")
    public ResponseEntity<List<ClientModel>> getAllClients() {
        try {
            List<ClientModel> clients = clientService.getAllClients();

            if (clients.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(clients, HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @Operation(summary = "saveClient", description = "Guarda un client a la base de dades passant els paràmetres necessaris")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Client guardat", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClientModel.class)))),
            @ApiResponse(responseCode = "500", description = "Error intern del servidor", content = @Content) })

    //save client **DONE**
    @PostMapping(path = "/newClient")
    public ResponseEntity<ClientModel> saveClient(@RequestBody ClientCreationDTO clientDTO) {
        try {
            ClientModel savedClient = clientService.saveClient(clientDTO);
            return new ResponseEntity<>(savedClient, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "getClientById", description = "Obté un client de la base de dades per id passant el id per paràmetre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client trobat", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClientModel.class)))),
            @ApiResponse(responseCode = "404", description = "Client no trobat", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error intern del servidor", content = @Content) })

    //get client by id **DONE**
    @GetMapping(path = "{id}")
    public ResponseEntity<ClientModel> getClientById(@PathVariable("id") Long id) {
    Optional<ClientModel> optionalClient = clientService.getClientById(id);
        if (optionalClient.isPresent()) {
            ClientModel client = optionalClient.get();
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "updateClientById", description = "Actualitza un client de la base de dades passant a la URL el id del client a actualitzar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client actualitzat", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClientModel.class)))),
            @ApiResponse(responseCode = "404", description = "Client no trobat", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error intern del servidor", content = @Content) })

    //update client by id **DONE**
    @PutMapping(path = "updateClient/{id}")
    public ResponseEntity<ClientModel> updateClientById(@RequestBody ClientModel request, @PathVariable("id") Long id) {
        ClientModel updatedClient = clientService.updateClientById(request, id);
        if (updatedClient != null) {
            return new ResponseEntity<>(updatedClient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "deleteClientById", description = "Elimina un client de la base de dades per id passant el id per paràmetre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Client eliminat", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClientModel.class)))),
            @ApiResponse(responseCode = "404", description = "Client no trobat", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error intern del servidor", content = @Content) })
    //delete client by id **DONE**
    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteClientById(@PathVariable("id") Long id) {
        try{
            boolean deleted = clientService.deleteClientById(id);
            if (deleted) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "getClientsByCommercialId", description = "Obté tots els clients de la base de dades per id del comercial passant el id del comercial per paràmetre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Clients trobats", content = @Content(array = @ArraySchema(schema = @Schema(implementation = ClientModel.class)))),
            @ApiResponse(responseCode = "404", description = "No s'han trobat clients", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error intern del servidor", content = @Content) })

    //get clients by commercial id
    @GetMapping(path = "getAllCustomersforAComme/{commercialId}")
    public ResponseEntity<List<ClientModel>> getClientsByCommercialId(@PathVariable Long commercialId) {
        List<ClientModel> clients = clientService.getClientByCommercialId(commercialId);

        if (clients != null) {
            return new ResponseEntity<>(clients, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

}
