package com.ames.provatecnica.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ames.provatecnica.models.ClientModel;
import com.ames.provatecnica.models.CommercialModel;
import com.ames.provatecnica.models.ProductModel;
import com.ames.provatecnica.models.SaleModel;
import com.ames.provatecnica.models.dtos.Create.SaleCreationDTO;
import com.ames.provatecnica.repositories.ClientRepository;
import com.ames.provatecnica.repositories.CommercialRepository;
import com.ames.provatecnica.repositories.ProductRepository;
import com.ames.provatecnica.repositories.SaleRepository;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private CommercialRepository commercialRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ClientRepository clientRepository;
    
    //get all sales by commercial id
    public List<SaleModel> getSalesByCommercialId(Long commercialId) {
        return saleRepository.findByCommercialId(commercialId);
    }

    @Transactional
    public SaleModel registerSale(SaleCreationDTO saleDTO) {
        CommercialModel commercial = commercialRepository.findById(saleDTO.getCommercialId()).orElse(null);
        ProductModel product = productRepository.findById(saleDTO.getProductId()).orElse(null);
        ClientModel client = clientRepository.findById(saleDTO.getClientId()).orElse(null);

        if (commercial != null && product != null && client != null) {
            SaleModel sale = new SaleModel();
            sale.setCommercial(commercial);
            sale.setProduct(product);
            sale.setClient(client);
            sale.setQuantity(saleDTO.getQuantity());
            sale.setSaleDate(new Date());

            double totalSaleAmount = product.getPrice() * saleDTO.getQuantity();

            commercial.setTotalSales(commercial.getTotalSales() + totalSaleAmount);
            commercial.setUnitsSold(commercial.getUnitsSold() + saleDTO.getQuantity());

            saleRepository.save(sale);
            commercialRepository.save(commercial);

            return sale;
        }

        return null;
    }
}