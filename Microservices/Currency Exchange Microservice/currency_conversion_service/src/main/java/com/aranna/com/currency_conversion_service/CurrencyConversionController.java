package com.aranna.com.currency_conversion_service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConversionController {

    @Autowired 
    private Environment environment;
    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public ResponseEntity<?> getMethodName(
        @PathVariable("from") String from,@PathVariable("to") String to,@PathVariable("quantity") Integer quantity
    ) {
        try{
            ResponseEntity<?> currencyConversion2=currencyExchangeProxy.getMethodName(from, to);
            CurrencyConversion currencyConversion1=new CurrencyConversion(1,"USD","INR",BigDecimal.valueOf(100),10,BigDecimal.valueOf(100));
            currencyConversion1.setPort(environment.getProperty("local.server.port"));
            System.out.println(currencyConversion2);
            return ResponseEntity.status(HttpStatus.OK).body(currencyConversion2);

        } catch (Exception e) {
          System.out.println(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ArrayList<>());
    }
    
}
