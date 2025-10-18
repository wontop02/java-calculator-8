package calculator.controller;

import calculator.validator.CustomDelimiterValidator;
import calculator.validator.NegativeValidator;
import calculator.validator.OtherCharacterValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ParsedInputController {
    CustomDelimiterValidator cdv = new CustomDelimiterValidator();

    public String customizeDelimiter(String input) {
        String delimiter = input.substring(2, input.lastIndexOf("\\n"));
        cdv.validate(delimiter);
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
            int num = Integer.parseInt(strNum);
            numbers.add(num);
        }
        return numbers;
    }

}
