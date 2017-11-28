package com.softuni.controller;

import com.softuni.entity.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DecimalFormat;

@Controller
public class HomeController {
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("operator", "+");
		model.addAttribute("view", "views/calculatorForm");
		return "base-layout";
	}

	@PostMapping("/")
    public  String calculate(@RequestParam String leftOperand,
                             @RequestParam String operator,
                             @RequestParam String rightOperand,
                             Model model) {
        double numberOne;
        double numberTwo;

	    try {
	        numberOne = Double.parseDouble(leftOperand);
        } catch (NumberFormatException ex) {
	        numberOne = 0;
        }

        try {
	        numberTwo = Double.parseDouble(rightOperand);
        } catch (NumberFormatException ex) {
	        numberTwo = 0;
        }

        Calculator calculator = new Calculator(numberOne, numberTwo, operator);

        double result = calculator.CalculateResult();

        String resultStr = String.valueOf(result);
        if (operator.equals("/") && numberTwo == 0) resultStr = "Error!";

        model.addAttribute("leftOperand", calculator.getLeftOperand());
        model.addAttribute("operator", calculator.getOperator());
        model.addAttribute("rightOperand", calculator.getRightOperand());
        model.addAttribute("result", resultStr);
	    model.addAttribute("view", "views/calculatorForm");

	    return "base-layout";
    }
}