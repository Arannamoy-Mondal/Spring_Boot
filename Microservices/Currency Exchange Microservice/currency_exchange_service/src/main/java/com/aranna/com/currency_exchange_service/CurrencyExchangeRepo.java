package com.aranna.com.currency_exchange_service;



import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchange,Integer>{

    CurrencyExchange findByFromAndTo(String from,String to);

    
} 
