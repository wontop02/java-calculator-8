package calculator;

import calculator.controller.ParsedInputController;

public class Application {
    public static void main(String[] args) {
        ParsedInputController parsedInputController = new ParsedInputController();

        parsedInputController.run();
    }
}
