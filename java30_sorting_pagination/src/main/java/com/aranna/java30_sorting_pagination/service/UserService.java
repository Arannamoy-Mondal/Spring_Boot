package com.aranna.java30_sorting_pagination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.aranna.java30_sorting_pagination.model.User;
import com.aranna.java30_sorting_pagination.repo.UserRepo;

@Service
public class UserService {
    @Autowired
    public UserRepo userRepo;
    public Page<User> findAll(int pageNumber,int pageSize,String sortDir,String sortBy){
        if(userRepo.findAll().size()==0){
            for(int i=1;i<=100;i++){
                userRepo.save(
                    User.builder()
                    .userName("user"+i)
                    .email("user"+i+"@gmail.com")
                    .build()
                );
            }
        }
        // ------------- sorting ----------------
        Sort sort=sortDir.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending(); 
        Pageable pageable=PageRequest.of(pageNumber, pageSize,sort);
        return userRepo.findAll(pageable);
    }
}
