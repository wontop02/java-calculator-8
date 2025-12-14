package calculator.util;

import static calculator.constant.CalculatorConstant.BASIC_SEPARATOR;
import static calculator.constant.CalculatorConstant.CUSTOM_END;
import static calculator.constant.CalculatorConstant.CUSTOM_LENGTH;
import static calculator.constant.CalculatorConstant.CUSTOM_START;
import static calculator.constant.CalculatorConstant.MAX_NUMBER;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private static final String CUSTOM_START_REGEX = "^" + CUSTOM_START + ".*";
    private static final String ONLY_DIGIT_REGEX = "^[0-9]+$";
    private static final String DIGITS_AND_SEPARATOR_ONLY_REGEX = "^[0-9%s]+$";

    private static final String INVALID_CUSTOM_END = "커스텀 구분자 지정 완료 문자열을 찾을 수 없습니다.";
    private static final String INVALID_CUSTOM_LENGTH =
            String.format(
                    "커스텀 구분자의 길이는 %d여야 합니다.", CUSTOM_LENGTH
            );
    private static final String CUSTOM_CAN_NOT_NUMBER = "커스텀 구분자는 숫자일 수 없습니다.";
    private static final String INVALID_RANGE =
            String.format(
                    "%d 이하의 숫자만 입력해 주세요.",
                    MAX_NUMBER
            );
    private static final String NOT_DIGITS_AND_SEPARATOR_ONLY = "구분자와 숫자를 제외한 문자가 존재합니다.";

    public static void validateInput(String input) {
        if (input.matches(CUSTOM_START_REGEX)) {
            validateInputWithCustom(input);
            return;
        }
        String regex = String.join("|", BASIC_SEPARATOR);
        validateInputFormat(input, regex);
        List<String> inputs = Arrays.asList(input.split(regex, -1));
        inputs.forEach(InputValidator::validateWithinIntRange);
    }

    public static void validateInputWithCustom(String input) {
        validateCustomEnd(input);
        String custom = input.substring(input.indexOf(CUSTOM_START) + CUSTOM_START.length(), input.indexOf(CUSTOM_END));
        validateCustomLength(custom);
        validateCustomNotNumber(custom);
        validateInputFormat(input, custom);
        List<String> inputs = Arrays.asList(input.split(custom, -1));
        inputs.forEach(InputValidator::validateWithinIntRange);
    }

    private static void validateCustomEnd(String input) {
        if (!input.contains(CUSTOM_END)) {
            throw new IllegalArgumentException(INVALID_CUSTOM_END);
        }
    }

    private static void validateCustomLength(String custom) {
        if (custom.length() > CUSTOM_LENGTH || custom.isBlank()) {
            throw new IllegalArgumentException(INVALID_CUSTOM_LENGTH);
        }
    }

    private static void validateCustomNotNumber(String custom) {
        if (custom.matches(ONLY_DIGIT_REGEX)) {
            throw new IllegalArgumentException(CUSTOM_CAN_NOT_NUMBER);
        }
    }

    private static void validateInputFormat(String input, String separator) {
        if (input.isBlank()) {
            return;
        }
        String regex = String.format(DIGITS_AND_SEPARATOR_ONLY_REGEX, separator);
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(NOT_DIGITS_AND_SEPARATOR_ONLY);
        }
    }

    private static void validateWithinIntRange(String input) {
        if (input.isBlank()) {
            return;
        }
        BigInteger value = new BigInteger(input);
        if (value.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0
                || value.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
    }
}
