package com.ames.provatecnica.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.ames.provatecnica.repositories.ClientRepository;
import com.ames.provatecnica.repositories.CommercialRepository;
import com.ames.provatecnica.models.ClientModel;
import com.ames.provatecnica.models.dtos.Create.ClientCreationDTO;

import java.util.List;
import java.util.Optional;



@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CommercialRepository commercialRepository;


    //get all clients **DONE**
    public List<ClientModel> getAllClients() {
        return (List<ClientModel>) clientRepository.findAll();
    }

    //get client by id **DONE**
    public Optional<ClientModel> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    //save client **DONE**
   public ClientModel saveClient(ClientCreationDTO clientDTO) {
    if (clientDTO != null) {
        ClientModel client = new ClientModel(
            clientDTO.getName(),
            clientDTO.getLastName(),
            clientDTO.getPhone(),
            clientDTO.getEmail(),
            clientDTO.getAddress(),
            clientDTO.isPreferential(),
            clientDTO.isHasDiscount()
        );
        // Puedes realizar cualquier validación adicional o configuración antes de guardar

        return clientRepository.save(client);
    }
    return null;
}

    //update client by id **DONE**
    public ClientModel updateClientById(ClientModel request, Long id) {
        Optional<ClientModel> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            ClientModel client = optionalClient.get();
            client.setName(request.getName());
            client.setLastName(request.getLastName());
            client.setPhone(request.getPhone());
            client.setEmail(request.getEmail());
            client.setAddress(request.getAddress());
            client.setPreferential(request.isPreferential());
            client.setHasDiscount(request.isHasDiscount());
            return clientRepository.save(client);
        }
        return null;
    }

    //delete client by id **DONE**
    public boolean deleteClientById(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // get client by commercial id
    public List<ClientModel> getClientByCommercialId(Long id) {
        return clientRepository.findByCommercialId(id);
    }

}
