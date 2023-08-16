package com.ames.provatecnica.repositories;

import com.ames.provatecnica.models.ClientModel;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {

    //find by commercial id
    List<ClientModel> findByCommercialId(Long commercialId);


}
