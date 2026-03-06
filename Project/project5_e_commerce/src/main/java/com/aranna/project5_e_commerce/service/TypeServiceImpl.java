package com.aranna.project5_e_commerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aranna.project5_e_commerce.entity.Type;
import com.aranna.project5_e_commerce.model.TypeResponse;
import com.aranna.project5_e_commerce.repo.TypeRepo;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepo typeRepo;

    @Override
    public List<TypeResponse> getAllTypes() {   
        log.info("Fetching all type");
        List<Type> types=typeRepo.findAll();
        List<TypeResponse> typeResponses=new ArrayList<>();
        for(Type type:types){
            typeResponses.add(
                TypeResponse
                .builder()
                .id(type.getId())
                .name(type.getName())
                .build()
            );
        }
        return typeResponses;
    }

    @Override
    public TypeResponse getTypeById(Integer id) {
    log.info("Fetching type id: {}",id);
      Type type=typeRepo.findById(id).orElse(null);
      TypeResponse typeResponse=TypeResponse.builder()
      .id(type.getId())
      .name(type.getName())
      .build();
      return typeResponse;
    }

}
