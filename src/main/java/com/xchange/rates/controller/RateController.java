package com.xchange.rates.controller;

import com.xchange.rates.model.ExchangeRateForCurrencyPair;
import com.xchange.rates.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateController {
    @Autowired
    private RateService rateService;

    @GetMapping("/rates")
    public ExchangeRateForCurrencyPair getExchangeRateForCurrencyPair(@RequestParam String sourceCurrencyCode, @RequestParam String targetCurrencyCode){
        return rateService.getExchangeRateForCurrencyPair(sourceCurrencyCode, targetCurrencyCode);
    }
}
