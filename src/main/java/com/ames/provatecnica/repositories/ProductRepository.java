package com.ames.provatecnica.repositories;

import com.ames.provatecnica.models.ProductModel;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


@Repository
public interface ProductRepository  extends JpaRepository<ProductModel, Long>{
    List<ProductModel> findByType(String type);
    List<ProductModel> findByCommercialId(Long commercialId);


}
