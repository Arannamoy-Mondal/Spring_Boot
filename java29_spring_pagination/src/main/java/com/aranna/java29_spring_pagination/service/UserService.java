package com.aranna.java29_spring_pagination.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.aranna.java29_spring_pagination.model.User;
import com.aranna.java29_spring_pagination.repo.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public Page<User> findAll(int pageSize,int pageNum){

        if(userRepo.findAll().size()==0){
            List<User> users=new ArrayList<>();
            for (int i = 1; i <= 100; i++) {
                // users.add(
                  User user=User.builder()
                //   .id(i)
                  .userName("user"+i)
                  .email("user"+i+"@user.com")
                  .age(i+10)
                  .build()  
                  ;
                // );
                userRepo.save(user);
            }
            userRepo.saveAll(users);
        }
        

        // ------------- Pagination -----------
        Pageable pageable=PageRequest.of(pageNum, pageSize);
        return userRepo.findAll(pageable);
    }
}
