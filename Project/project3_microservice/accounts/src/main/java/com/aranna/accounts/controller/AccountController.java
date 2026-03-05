package com.aranna.accounts.controller;

import org.springframework.web.bind.annotation.RestController;

import com.aranna.accounts.model.Account;
import com.aranna.accounts.repo.AccountRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/user")
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

}
