package calculator.domain;

import java.util.List;

public class ParsedInput {
    private List<Integer> numbers;
    private int result;

    public ParsedInput(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int additionNumbers() {
        this.result = 0;
        for (int num : numbers)
           result += num;
        return result;
    }
}
