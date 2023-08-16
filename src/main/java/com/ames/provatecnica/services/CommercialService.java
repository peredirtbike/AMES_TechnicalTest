package com.ames.provatecnica.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ames.provatecnica.models.ClientModel;
import com.ames.provatecnica.models.CommercialModel;
import com.ames.provatecnica.models.dtos.Create.CommercialCreationDTO;
import com.ames.provatecnica.models.dtos.Update.CommercialUpdateDTO;
import com.ames.provatecnica.repositories.CommercialRepository;
import com.ames.provatecnica.repositories.ClientRepository;

@Service
public class CommercialService {

    @Autowired
    CommercialRepository commercialRepository;

    @Autowired
    ClientRepository clientRepository;

    //save commercial
    public CommercialModel saveCommercial(CommercialCreationDTO commercialDTO) {
        if (commercialDTO != null) {
            CommercialModel commercial = new CommercialModel();
            commercial.setName(commercialDTO.getName());
            commercial.setLastName(commercialDTO.getLastName());
            commercial.setPhone(commercialDTO.getPhone());
            commercial.setEmail(commercialDTO.getEmail());
            //es setejen els valors a 0 i se suma cada vegada que es fa una venta
            commercial.setUnitsSold(0);
            commercial.setTotalSales(0);
            return commercialRepository.save(commercial);

        } 
        return null;
    }

    //update commercial by id
    public CommercialModel updateCommercialById(CommercialUpdateDTO commercialUpdateDTO, Long id) {
        Optional<CommercialModel> optionalcommercial = commercialRepository.findById(id);
        if (optionalcommercial.isPresent()) {
            CommercialModel commercial = optionalcommercial.get();
            commercial.setName(commercialUpdateDTO.getName());
            commercial.setLastName(commercialUpdateDTO.getLastName());
            commercial.setPhone(commercialUpdateDTO.getPhone());
            commercial.setEmail(commercialUpdateDTO.getEmail());
            return commercialRepository.save(commercial);
        } else {
            return null;
        }
    }

    //add client to comercial
    public ClientModel addClientToCommercial(Long idCommercial, Long idClient) {
        Optional<CommercialModel> optionalCommercial = commercialRepository.findById(idCommercial);
        Optional<ClientModel> optionalClient = clientRepository.findById(idClient);
    
        if (optionalCommercial.isPresent() && optionalClient.isPresent()) {
            CommercialModel commercial = optionalCommercial.get();
            ClientModel client = optionalClient.get();
            client.setCommercial(commercial);
            return clientRepository.save(client);
        }
    
        return null;
    }

    
}
