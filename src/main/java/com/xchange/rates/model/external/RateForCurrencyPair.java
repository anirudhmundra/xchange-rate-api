package com.xchange.rates.model.external;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;
import java.util.Map;

@JsonSerialize
public class RateForCurrencyPair {

    @JsonProperty("rates")
    private Map<String, Double> ratesOfCurrency;

    @JsonProperty("base")
    private String baseCurrency;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @JsonProperty("date")
    private Date dateOfExchangeRate;

    public void setRatesOfCurrency(Map<String, Double> ratesOfCurrency) {
        this.ratesOfCurrency = ratesOfCurrency;
    }

    public Map<String, Double> getRatesOfCurrency() {
        return ratesOfCurrency;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public Date getDateOfExchangeRate() {
        return dateOfExchangeRate;
    }

    public void setDateOfExchangeRate(Date dateOfExchangeRate) {
        this.dateOfExchangeRate = dateOfExchangeRate;
    }
}
