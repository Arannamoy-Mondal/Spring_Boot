package com.aranna.project5_e_commerce.service;

import java.util.List;

import com.aranna.project5_e_commerce.model.BrandResponse;

public interface BrandService {
    List<BrandResponse> getAllBrands();
    BrandResponse getBrandById(Integer id);
}
