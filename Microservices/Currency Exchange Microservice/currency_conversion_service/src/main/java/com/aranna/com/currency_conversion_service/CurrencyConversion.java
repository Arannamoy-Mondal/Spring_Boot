package com.aranna.com.currency_conversion_service;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class CurrencyConversion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "currency_from")
    private String from;
    @Column(name = "currency_to")
    private String to;
    private BigDecimal conversionMutiple;
    private Integer quantity;
    private BigDecimal totalCalculatedAmount;
    private String port;
    public String getPort() {
        return port;
    }
    public void setPort(String port) {
        this.port = port;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public BigDecimal getConversionMutiple() {
        return conversionMutiple;
    }
    public void setConversionMutiple(BigDecimal conversionMutiple) {
        this.conversionMutiple = conversionMutiple;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getTotalCalculatedAmount() {
        return totalCalculatedAmount;
    }
    public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }
    public CurrencyConversion(Integer id, String from, String to, BigDecimal conversionMutiple, Integer quantity,
            BigDecimal totalCalculatedAmount) {
        this.from = from;
        this.to = to;
        this.conversionMutiple = conversionMutiple;
        this.quantity = quantity;
        this.totalCalculatedAmount = totalCalculatedAmount;
    }
    public CurrencyConversion() {
    }
}
