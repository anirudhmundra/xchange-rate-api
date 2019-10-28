package com.xchange.rates.controller;

import com.xchange.rates.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/currencies")
    public Map<String, String> getCurrencies(){
        return currencyService.getCurrencies();
    }
}
