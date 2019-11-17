package com.xchange.rates.service;

import com.xchange.rates.constants.Constants;
import com.xchange.rates.external.RateExternal;
import com.xchange.rates.model.CurrencyRate;
import com.xchange.rates.model.ExchangeRateForCurrencyPair;
import com.xchange.rates.dto.external.RateForCurrencyPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class RateService {
    @Autowired
    private RateExternal rateExternal;

    public ExchangeRateForCurrencyPair getExchangeRateForCurrencyPair(String sourceCurrencyCode, String targetCurrencyCode){
        RateForCurrencyPair rateForCurrencyPair = rateExternal.getRateForCurrencyPair(sourceCurrencyCode, targetCurrencyCode).getBody();

        ExchangeRateForCurrencyPair exchangeRateForCurrencyPair = new ExchangeRateForCurrencyPair();
        exchangeRateForCurrencyPair.setSourceCurrency(new CurrencyRate(sourceCurrencyCode, Constants.RateOfSourceCurrency));
        exchangeRateForCurrencyPair.setTargetCurrency(new CurrencyRate(targetCurrencyCode,rateForCurrencyPair.getRatesOfCurrency().get(targetCurrencyCode)));

        return exchangeRateForCurrencyPair;
    }

    protected Set<String> getCurrenciesEligibleForRates(){
        RateForCurrencyPair rateForCurrency = rateExternal.getCurrenciesEligibleForRates().getBody();

        Map<String,Double> currenciesMap = rateForCurrency.getRatesOfCurrency();

        Set<String> currencyCodeSet = new HashSet<>();
        currencyCodeSet.add(rateForCurrency.getBaseCurrency());
        currencyCodeSet.addAll(currenciesMap.keySet());

        return currencyCodeSet;
    }
}
