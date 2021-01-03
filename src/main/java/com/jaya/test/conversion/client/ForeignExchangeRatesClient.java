package com.jaya.test.conversion.client;

import com.jaya.test.conversion.controller.response.RateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "api.exchangeratesapi.io", url = "https://api.exchangeratesapi.io/latest")
public interface ForeignExchangeRatesClient {

    @GetMapping
    RateResponse getRate(@RequestParam("symbols") final List<String> symbols, @RequestParam("base") final String base);
}
