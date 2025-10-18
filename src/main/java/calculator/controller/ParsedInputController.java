package calculator.controller;

import calculator.domain.ParsedInput;
import calculator.validator.BasicValidator;
import calculator.validator.CustomDelimiterValidator;
import calculator.validator.NegativeValidator;
import calculator.validator.OtherCharacterValidator;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ParsedInputController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    BasicValidator basicV = new BasicValidator();
    CustomDelimiterValidator customDelimiterV = new CustomDelimiterValidator();
    OtherCharacterValidator otherCharacterV = new OtherCharacterValidator();
    NegativeValidator negativeV = new NegativeValidator();

    public void run() {
        String customDelimiter = "";

        String input = inputView.requestInput();
        basicV.validate(input);
        if (input.matches("^//.*"))
            customDelimiter = customizeDelimiter(input);

        String[] strNumbers = splitString(input, customDelimiter);
        List<Integer> numbers = extractNumbers(strNumbers);
        ParsedInput parsedInput = new ParsedInput(numbers);

        int result = parsedInput.additionNumbers();
        outputView.printResult(result);
    }

    public String customizeDelimiter(String input) {
        String delimiter = input.substring(2, input.lastIndexOf("\\n"));
        customDelimiterV.validate(delimiter);
        return delimiter;
    }

    public String[] splitString(String input, String delimiter) {
        if (delimiter.isEmpty())
            return input.split(",|:");
        input = input.substring(input.indexOf("\\n") + 2);
        String regex = Pattern.quote(delimiter);
        return input.split(regex);
    }

    public List<Integer> extractNumbers(String[] strNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String strNum : strNumbers) {
            if (strNum.isEmpty()) {
                numbers.add(0);
                continue;
            }
            otherCharacterV.validate(strNum);
            int num = Integer.parseInt(strNum);
            negativeV.validate(num);
            numbers.add(num);
        }
        return numbers;
    }

}
