package com.ames.provatecnica.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ames.provatecnica.models.SaleModel;

@Repository
public interface SaleRepository extends JpaRepository<SaleModel, Long> {
        List<SaleModel> findByCommercialId(Long commercialId);

}
