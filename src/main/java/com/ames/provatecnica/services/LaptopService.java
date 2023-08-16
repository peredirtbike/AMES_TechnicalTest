package com.ames.provatecnica.services;

import com.ames.provatecnica.models.LaptopModel;
import com.ames.provatecnica.models.dtos.Create.LaptopCreationDTO;
import com.ames.provatecnica.repositories.LaptopRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository laptopRepository;


    //save laptop
    public LaptopModel saveLaptop(LaptopCreationDTO laptopDTO) {
        if (laptopDTO != null) {
            LaptopModel laptop = new LaptopModel();
            laptop.setDescription(laptopDTO.getDescription());
            laptop.setIsActive(laptopDTO.getIsActive());
            laptop.setPrice(laptopDTO.getPrice());
            laptop.setEntryDate(laptopDTO.getEntryDate());
            laptop.setBatteryCapacity(laptopDTO.getBatteryCapacity());
            laptop.setChargerAmperage(laptopDTO.getChargerAmperage());
            laptop.setType(laptopDTO.getType());
            return laptopRepository.save(laptop);
        } else {
            return null;
        }
    }

    public LaptopModel updateLaptop(Long laptopId, LaptopModel updatedLaptop) {
        Optional<LaptopModel> existingLaptopOptional = laptopRepository.findById(laptopId);
        if (existingLaptopOptional.isPresent()) {
            LaptopModel existingDesktop = existingLaptopOptional.get();
            existingDesktop.setDescription(updatedLaptop.getDescription());
            existingDesktop.setIsActive(updatedLaptop.getIsActive());
            existingDesktop.setPrice(updatedLaptop.getPrice());
            existingDesktop.setEntryDate(updatedLaptop.getEntryDate());
            existingDesktop.setBatteryCapacity(updatedLaptop.getBatteryCapacity());
            existingDesktop.setChargerAmperage(updatedLaptop.getChargerAmperage());

            return laptopRepository.save(existingDesktop);
        } else {
            return null;
        }
    }

    // Otros métodos específicos para LaptopModel
    
}