package calculator.validator;

public class OtherCharacterValidator {
    public void validate(String str) {
        if (!str.matches("^[\\d]*$"))
            throw new IllegalArgumentException("구분자가 아닌 문자는 입력할 수 없습니다.");
    }
}
