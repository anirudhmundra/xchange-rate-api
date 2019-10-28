package com.xchange.rates.service;

import com.xchange.rates.external.CurrencyExternal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class CurrencyService {
    @Autowired
    private CurrencyExternal currencyExternal;
    @Autowired
    private RateService rateService;

    @Cacheable(value = "currencies")
    public Map<String, String> getCurrencies(){
        Map<String, String> currenciesMap = currencyExternal.getCurrencies();
        Set<String> currenciesEligibleForRates = rateService.getCurrenciesEligibleForRates();

        Map<String, String> filteredCurrenciesMap = new HashMap<>();
        currenciesEligibleForRates.stream().forEach(currencyCode ->{
            if(currenciesMap.containsKey(currencyCode)){
                filteredCurrenciesMap.put(currencyCode,currenciesMap.get(currencyCode));
            }
        });

        return filteredCurrenciesMap;
    }
}
