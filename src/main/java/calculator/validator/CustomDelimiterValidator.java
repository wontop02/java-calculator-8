package calculator.validator;

public class CustomDelimiterValidator {
    public void validate(String input) {
        if (input.isEmpty())
            throw new IllegalArgumentException("커스텀 구분자는 반드시 입력해야 합니다.");
        if (input.contains("\\n"))
            throw new IllegalArgumentException("\"\\n\"이 포함된 문자열을 구분자로 지정할 수 없습니다.");
    }
}
