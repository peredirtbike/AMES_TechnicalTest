package com.ames.provatecnica.repositories;

import com.ames.provatecnica.models.CommercialModel;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CommercialRepository extends JpaRepository<CommercialModel, Long> {
    
}