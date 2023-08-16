package com.ames.provatecnica.services;

import com.ames.provatecnica.models.DesktopModel;
import com.ames.provatecnica.models.dtos.Create.DesktopCreationDTO;
import com.ames.provatecnica.repositories.DesktopRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import org.springframework.stereotype.Service;



@Service
public class DesktopService {

    @Autowired
    private DesktopRepository desktopRepository;

    //save desktop
    public DesktopModel saveDesktop(DesktopCreationDTO desktopDTO) {
        if (desktopDTO != null) {
            DesktopModel desktop = new DesktopModel();
            desktop.setDescription(desktopDTO.getDescription());
            desktop.setIsActive(desktopDTO.getIsActive());
            desktop.setPrice(desktopDTO.getPrice());
            desktop.setEntryDate(desktopDTO.getEntryDate());
            desktop.setPowerSupply(desktopDTO.getPowerSupply());
            desktop.setGaming(desktopDTO.getGaming());
            desktop.setType(desktopDTO.getType());
            return desktopRepository.save(desktop);
        } else {
            return null;
        }
    }

    //update desktop
    public DesktopModel updateDesktop(Long desktopId, DesktopModel updatedDesktop) {
        Optional<DesktopModel> existingDesktopOptional = desktopRepository.findById(desktopId);
        
        if (existingDesktopOptional.isPresent()) {
            DesktopModel existingDesktop = existingDesktopOptional.get();
            
            existingDesktop.setDescription(updatedDesktop.getDescription());
            existingDesktop.setIsActive(updatedDesktop.getIsActive());
            existingDesktop.setPrice(updatedDesktop.getPrice());
            existingDesktop.setEntryDate(updatedDesktop.getEntryDate());
            existingDesktop.setPowerSupply(updatedDesktop.getPowerSupply());
            existingDesktop.setGaming(updatedDesktop.getGaming());
            //se ha quitado el type para evitar problemas

            return desktopRepository.save(existingDesktop);
        } else {
            return null;
        }
    }
    
}