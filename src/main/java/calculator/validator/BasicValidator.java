package calculator.validator;

// 입력값 1차 검증
public class BasicValidator {
    public void validate(String input) {
        if (input.matches("^//.*")) {
            if (!input.contains("\\n"))
                throw new IllegalArgumentException("커스텀 구분자의 마무리가 존재하지 않습니다.");
            return;
        }
        if (input.matches("^,.*") || input.matches("^:.*"))
            return;
        if (input.matches("^\\d.*"))
            return;
        if (!input.isEmpty())
            throw new IllegalArgumentException("문자열이 숫자나 기본 구분자, 커스텀 구분자 지정으로 시작하지 않습니다.");
    }
}
