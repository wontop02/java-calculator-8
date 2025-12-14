package calculator.controller;

import calculator.service.CalculatorService;
import calculator.util.InputValidator;
import calculator.view.InputView;

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public void run() {
        String input = InputView.requestNumbers();
        InputValidator.validateInput(input);
        Long result = calculatorService.sum(input);
    }
}
