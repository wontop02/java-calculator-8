package calculator.service;

import static calculator.constant.CalculatorConstant.BASIC_SEPARATOR;
import static calculator.constant.CalculatorConstant.CUSTOM_END;
import static calculator.constant.CalculatorConstant.CUSTOM_START;
import static calculator.constant.CalculatorConstant.CUSTOM_START_REGEX;

import java.util.Arrays;
import java.util.List;

public class CalculatorService {
    public long calculateResult(String input) {
        String separator = String.join("|", BASIC_SEPARATOR);
        List<String> numbers = Arrays.asList(input.split(separator, -1));
        if (input.matches(CUSTOM_START_REGEX)) {
            separator = input.substring(input.indexOf(CUSTOM_START) + CUSTOM_START.length(),
                    input.indexOf(CUSTOM_END));
            String numberSection = input.substring(input.indexOf(CUSTOM_END) + CUSTOM_END.length());
            numbers = Arrays.asList(numberSection.split(separator, -1));
        }
        return sum(numbers);
    }

    private long sum(List<String> numbers) {
        long result = 0;
        for (String number : numbers) {
            if (number.isBlank()) {
                continue;
            }
            result += Long.parseLong(number);
        }
        return result;
    }
}
