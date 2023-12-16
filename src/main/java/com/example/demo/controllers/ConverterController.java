package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/converter")
public class ConverterController {

    @PostMapping
    public String convertCurrency(@RequestParam("amount") double amount,
                                  @RequestParam("sourceCurrency") String sourceCurrency,
                                  @RequestParam("targetCurrency") String targetCurrency,
                                  Model model) {

        double result = calculateConversion(amount, sourceCurrency, targetCurrency);

        model.addAttribute("result", result);
        return "converter";
    }

    private double calculateConversion(double amount, String sourceCurrency, String targetCurrency) {
        double usdToEurRate = 0.93;
        double usdToRubRate = 92.80;
        double eurToUsdRate = 1 / usdToEurRate;
        double eurToRubRate = 95.21;

        switch (sourceCurrency + targetCurrency) {
            case "USDEUR":
                return amount * usdToEurRate;
            case "EURUSD":
                return amount * eurToUsdRate;
            case "USDRUB":
                return amount * usdToRubRate;
            case "RUBUSD":
                return amount / usdToRubRate;
            case "EURRUB":
                return amount * eurToRubRate;
            case "RUBEUR":
                return amount / eurToRubRate;
            case "USDUSD":
            case "EUREUR":
            case "RUBRUB":
                return amount;
            default:
                return 0;
        }
    }
}
