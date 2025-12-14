package calculator.controller;

import calculator.util.InputValidator;
import calculator.view.InputView;

public class CalculatorController {
    public void run() {
        String input = InputView.requestNumbers();
        InputValidator.validateInput(input);
    }
}
