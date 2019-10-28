package com.xchange.rates.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class ExchangeRateForCurrencyPair {
    @JsonProperty("sourceCurrency")
    private CurrencyRate sourceCurrency;
    @JsonProperty("targetCurrency")
    private CurrencyRate targetCurrency;

    public CurrencyRate getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(CurrencyRate sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public CurrencyRate getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(CurrencyRate targetCurrency) {
        this.targetCurrency = targetCurrency;
    }
}
