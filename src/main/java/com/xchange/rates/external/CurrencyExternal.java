package com.xchange.rates.external;

import com.google.gson.Gson;
import com.xchange.rates.constants.Constants;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class CurrencyExternal {

    public Map<String, String> getCurrencies(){
        String url = Constants.CurrencyURL;

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        Gson gson = new Gson();
        Map<String,String> currencies = gson.fromJson(response, Map.class);

        return currencies;
    }
}
