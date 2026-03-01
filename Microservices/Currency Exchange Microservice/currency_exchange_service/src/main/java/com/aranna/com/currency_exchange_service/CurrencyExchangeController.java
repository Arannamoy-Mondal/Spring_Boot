package com.aranna.com.currency_exchange_service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/currency-exchange/from")
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;

    @GetMapping("/{from}/to/{to}")
    public ResponseEntity<?> getMethodName(@PathVariable("from") String from,@PathVariable("to") String to) {
        CurrencyExchange currencyExchange=new CurrencyExchange(100L,from,to,BigDecimal.valueOf(15));
        
        String property=environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(property);
        return ResponseEntity.status(HttpStatus.OK).body(
            currencyExchange
        );
    }
    
}
