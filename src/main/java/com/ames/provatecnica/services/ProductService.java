package com.ames.provatecnica.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.ames.provatecnica.models.ProductModel;
import com.ames.provatecnica.repositories.ProductRepository;


@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    //Get all products
    public List<ProductModel> getProductsByType(String type) {
        return productRepository.findByType(type);
    }

    //get all products by commercial id
    public List<ProductModel> getProductsByCommercialId(Long id) {
        return productRepository.findByCommercialId(id);
    }
    
}
