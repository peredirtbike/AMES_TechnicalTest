package com.ames.provatecnica.repositories;

import com.ames.provatecnica.models.LaptopModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<LaptopModel, Long> {
}