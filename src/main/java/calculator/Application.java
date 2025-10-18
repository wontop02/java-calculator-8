package calculator;

import calculator.controller.ParsedInputController;
import calculator.domain.ParsedInput;
import calculator.validator.BasicValidator;
import calculator.validator.CustomDelimiterValidator;
import calculator.validator.NegativeValidator;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        ParsedInputController parsedInputController = new ParsedInputController();

        parsedInputController.run();
    }
}
