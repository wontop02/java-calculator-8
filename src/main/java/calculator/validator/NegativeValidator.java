package calculator.validator;

public class NegativeValidator {
    public void validate(int num) {
        if (num < 0)
            throw new IllegalArgumentException("구분자가 아닌 문자는 입력할 수 없습니다.");
    }
}
