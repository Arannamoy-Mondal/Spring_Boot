package com.aranna.project5_e_commerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aranna.project5_e_commerce.entity.Brand;
import com.aranna.project5_e_commerce.model.BrandResponse;
import com.aranna.project5_e_commerce.repo.BrandRepo;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class BrandServiceImpl implements BrandService{
    @Autowired
    private BrandRepo brandRepo;

    @Override
    public List<BrandResponse> getAllBrands() {
        log.info("Fetching all brands.");
        List<Brand> brands=brandRepo.findAll();
        List<BrandResponse> brandResponses=new ArrayList<>();
        for(Brand brand:brands){
            brandResponses.add(BrandResponse.builder()
        .id(brand.getId()).name(brand.getName()).build());
        }
        return brandResponses;
    }

    @Override
    public BrandResponse getBrandById(Integer id) {
        log.info("Fetching brands id: {}",id);
        Brand brand=brandRepo.findById(id).orElse(null);
        BrandResponse brandResponse=BrandResponse.builder()
        .id(brand.getId()).name(brand.getName()).build();
        return brandResponse;
    }

}
