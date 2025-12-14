package calculator.service;

import static calculator.constant.CalculatorConstant.BASIC_SEPARATOR;
import static calculator.constant.CalculatorConstant.CUSTOM_END;
import static calculator.constant.CalculatorConstant.CUSTOM_START;
import static calculator.constant.CalculatorConstant.CUSTOM_START_REGEX;

import java.util.Arrays;
import java.util.List;

public class CalculatorService {

    public long sum(String input) {
        long result = 0;
        String separator = String.join("|", BASIC_SEPARATOR);
        if (input.matches(CUSTOM_START_REGEX)) {
            separator = input.substring(input.indexOf(CUSTOM_START) + CUSTOM_START.length(),
                    input.indexOf(CUSTOM_END));
        }
        List<String> numbers = Arrays.asList(input.split(separator, -1));
        for (String number : numbers) {
            if (number.isBlank()) {
                continue;
            }
            result += Long.parseLong(number);
        }
        return result;
    }
}
