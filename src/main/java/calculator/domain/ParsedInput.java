package calculator.domain;

import java.util.List;

public class ParsedInput {
    private final List<Integer> numbers;

    public ParsedInput(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int additionNumbers() {
        int result = 0;
        for (int num : numbers)
           result += num;
        return result;
    }
}
