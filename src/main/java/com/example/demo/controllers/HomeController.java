package com.example.demo.controllers;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/home")
    String getHome(Model model) {
        model.addAttribute("greeting");
        return "home";
    }

    @GetMapping("/converter")
    String getConverter() {
        return "converter";
    }

    @GetMapping("/calculator")
    String getCalculator() {
        return "calculator";
    }

    @PostMapping("/calculatorAnswer")
    String calculateAnswer(@RequestParam("expression") String expression, Model model) {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();

        try {
            Object result = parser.parseExpression(expression).getValue(context);
            model.addAttribute("ans", result.toString());
        } catch (Exception e) {
            model.addAttribute("ans", "Ошибка");
        }

        return "calculatorAnswer";
    }
}
