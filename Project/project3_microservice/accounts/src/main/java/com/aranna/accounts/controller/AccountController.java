package com.aranna.accounts.controller;

import org.springframework.web.bind.annotation.RestController;

import com.aranna.accounts.constants.AccountConstants;
import com.aranna.accounts.dto.CustomerDto;
import com.aranna.accounts.dto.ResponseDto;
import com.aranna.accounts.model.Account;
import com.aranna.accounts.repo.AccountRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path = "/user",produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountController {
    @Autowired
    private AccountRepo accountRepo;

    @GetMapping("/get")
    public ResponseEntity<?> getMethodName() {
        Account account = Account.builder().name("hello").build();
        accountRepo.save(account);
        List<Account> accounts = accountRepo.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(accounts);
    }
    
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto){
        return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ResponseDto(AccountConstants.STATUS_201,AccountConstants.MESSAGE_201));
    }

}
