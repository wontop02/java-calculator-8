package calculator.controller;

import calculator.validator.CustomDelimiterValidator;

public class ParsedInputController {
    CustomDelimiterValidator cdv = new CustomDelimiterValidator();

    public String customizeDelimiter(String input) {
        String delimiter = input.substring(2, input.lastIndexOf("\\n"));
        cdv.validate(delimiter);
        return delimiter;
    }
}
