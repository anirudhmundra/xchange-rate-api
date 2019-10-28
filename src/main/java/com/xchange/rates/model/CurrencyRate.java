package com.xchange.rates.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class CurrencyRate {
    @JsonProperty("code")
    private String code;
    @JsonProperty("rate")
    private double rate;
    @JsonProperty("minAmount")
    private int minAmount;

    public CurrencyRate(String code, double rate) {
        this.code = code;
        this.rate = rate;
        this.minAmount = 100;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(int minAmount) {
        this.minAmount = minAmount;
    }
}
