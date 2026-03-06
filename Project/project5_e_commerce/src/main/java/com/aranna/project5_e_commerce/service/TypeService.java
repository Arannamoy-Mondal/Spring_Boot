package com.aranna.project5_e_commerce.service;

import java.util.List;

import com.aranna.project5_e_commerce.model.TypeResponse;

public interface TypeService {
    List<TypeResponse> getAllTypes();
    TypeResponse getTypeById(Integer id);
}
