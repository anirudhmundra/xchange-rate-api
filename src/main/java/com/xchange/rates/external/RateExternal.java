package com.xchange.rates.external;

import com.xchange.rates.constants.Constants;
import com.xchange.rates.dto.external.RateForCurrencyPair;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RateExternal {

    public ResponseEntity<RateForCurrencyPair> getRateForCurrencyPair(String sourceCurrencyCode, String targetCurrencyCode){
        String url = Constants.RatesURL+"base="+sourceCurrencyCode+"&symbols="+targetCurrencyCode;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RateForCurrencyPair> rateForCurrency = restTemplate.getForEntity(url, RateForCurrencyPair.class);
        return rateForCurrency;
    }

    public ResponseEntity<RateForCurrencyPair> getCurrenciesEligibleForRates(){
        String url = Constants.RatesURL;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RateForCurrencyPair> currenciesEligibleForRates = restTemplate.getForEntity(url, RateForCurrencyPair.class);
        return currenciesEligibleForRates;
    }
}
